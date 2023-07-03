package tech.kbtg.finalcrudwithhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kbtg.finalcrudwithhibernate.entity.Employee;

public interface EmployeeRepository extends JpaRepository< Employee, Integer >
{
}
