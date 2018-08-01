package itovp.repositories;

import itovp.entities.Employee;
import itovp.entities.ManagementLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementLevelsRepository extends JpaRepository<ManagementLevel, Integer> {

}
