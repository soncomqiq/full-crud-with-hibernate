package tech.kbtg.finalcrudwithhibernate.dao;

import tech.kbtg.finalcrudwithhibernate.entity.Employee;

import java.util.List;

public interface EmployeeDAO
{
	List <Employee> findAll();
	Employee save(Employee employee);
	Employee findById(Integer id);
	void deleteById(Integer id);
}
