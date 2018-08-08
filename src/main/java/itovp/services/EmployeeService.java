package itovp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import itovp.dto.EmployeeDTO;
import itovp.entities.Employee;
import itovp.repositories.EmployeeRepository;
import itovp.repositories.ManagementLevelsRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ManagementLevelsRepository managementLevelsRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public Employee findOne(String employeeId) {
        return employeeRepository.findOne(employeeId);
    }


    public void addEmployee(EmployeeDTO employee) {
        Employee empl = employeeRepository.findOne(employee.employeeId);
        if (empl == null) {
            empl = new Employee();
            empl.setEmployeeId(employee.employeeId);
            empl.setSurname(employee.surname);
            empl.setName(employee.name);
            empl.setBirthday(employee.birthday);
            empl.setHiringDate(employee.hiringDate);
        }
        empl.setEmail(employee.email);
        empl.setAddress(employee.address);
        empl.setSalary(employee.salary);
        if (employee.manager_id != null && !employee.manager_id.equals("")) {
            empl.setManager(employeeRepository.findOne(employee.manager_id));
        }
        empl.setManagementLevel_id(managementLevelsRepository.findOne(employee.managementLevel_id));
        employeeRepository.save(empl);
    }

    public void removeEmployee(String employeeId) {
        employeeRepository.updateSubs(employeeId);
        employeeRepository.delete(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /*
     * Changes salary to all the employees with a coefficient
     * @param coefficient to decrease or increase the salary
     *       reduce salary if less then 1
     *       increase if more then 1
     * */
    @Transactional
    public void changeSalaryToAllWithCoef(double coefficient) {
        List<Employee> listOfEmpl = employeeRepository.findAll();

        listOfEmpl.parallelStream().forEach((Employee e) -> e.setSalary((int) (e.getSalary() * coefficient)));

        employeeRepository.save(listOfEmpl);
    }

    /*
     * Changes salary to all the employees by some amount
     * @param value to decrease or increase the salary
     *       decrease salary if less then 0
     *       increase if more then 0
     * */
    @Transactional
    public void changeSalaryToAllWithValue(double value) {
        List<Employee> listOfEmpl = employeeRepository.findAll();

        listOfEmpl.parallelStream().forEach((Employee e) -> e.setSalary((int) (e.getSalary() + value)));

        employeeRepository.save(listOfEmpl);
    }

    public List<Employee> getManagers(int lvl) {
        return employeeRepository.getManagers(lvl);
    }
}
