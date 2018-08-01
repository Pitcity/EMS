package itovp.services;

import itovp.entities.Employee;
import itovp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeRepository.delete(employee);
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

        listOfEmpl.parallelStream().forEach((Employee e) -> e.setSalary(e.getSalary().multiply(new BigDecimal(coefficient))));

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

        listOfEmpl.parallelStream().forEach((Employee e) -> e.setSalary(e.getSalary().add(new BigDecimal(value))));

        employeeRepository.save(listOfEmpl);
    }
}
