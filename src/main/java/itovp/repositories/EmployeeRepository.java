package itovp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import itovp.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("SELECT e FROM Employee e " +
            "inner join e.managementLevel_id ml " +
            "where ml.lvl > :lvl")
    List<Employee> getManagers(@Param("lvl") int lvl);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Employee e set e.manager = (select manager.manager from Employee manager where manager.employeeId like CONCAT('%',:employeeManagerId,'%')) " +
            " where e.manager.employeeId like CONCAT('%',:employeeManagerId,'%')")
    void updateSubs(@Param("employeeManagerId") String managerId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Employee e where e.employeeId like CONCAT('%',:employeeId,'%')")
    void delete(@Param("employeeId") String managerId);
}
