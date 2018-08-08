package itovp.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EmployeeDTO {

    public String employeeId;

    public String surname;

    public String name;

    public String manager_id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public Date birthday;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public Date hiringDate;

    public String email;

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
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

    public void setManagementLevel_id(int managementLevel_id) {
        this.managementLevel_id = managementLevel_id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int managementLevel_id;

    public double salary;

    public String address;

}
