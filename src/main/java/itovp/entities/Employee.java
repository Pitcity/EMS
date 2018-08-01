package itovp.entities;


import com.google.gson.annotations.JsonAdapter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblEmployees")
@Embeddable
public class Employee {

    @Id
    String employeeId;

    @NotNull
    private String surname;

    @NotNull
    private String name;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @NotNull
    private Date birthday;

    @NotNull
    private Date hiringDate;

    @NotNull
    @Email
    private String email;

    @ManyToOne
    private ManagementLevel managementLevel_id;

    @NotNull
    private BigDecimal salary;

    private String address;

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setManagementLevel_id(ManagementLevel managementLevel_id) {
        this.managementLevel_id = managementLevel_id;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Employee getManager() {
        return manager;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public String getEmail() {
        return email;
    }

    public ManagementLevel getManagementLevel_id() {
        return managementLevel_id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }
}
