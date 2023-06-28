package tech.kbtg.finalcrudwithhibernate.service;

import tech.kbtg.finalcrudwithhibernate.entity.Employee;

import java.util.List;

public interface EmployeeService
{
	List< Employee > findAll();
	Employee save(Employee employee);
	Employee findById(Integer id);
	void deleteById(Integer id);
}
