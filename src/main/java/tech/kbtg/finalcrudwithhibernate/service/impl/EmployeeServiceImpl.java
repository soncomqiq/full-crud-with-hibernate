package tech.kbtg.finalcrudwithhibernate.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.kbtg.finalcrudwithhibernate.dao.EmployeeDAO;
import tech.kbtg.finalcrudwithhibernate.entity.Employee;
import tech.kbtg.finalcrudwithhibernate.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeDAO employeeDAO;

	public EmployeeServiceImpl( EmployeeDAO employeeDAO )
	{
		this.employeeDAO = employeeDAO;
	}

	@Override
	public List < Employee > findAll()
	{
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee save( Employee employee )
	{
		return employeeDAO.save( employee );
	}

	@Override
	public Employee findById( Integer id )
	{
		return employeeDAO.findById( id );
	}

	@Override
	@Transactional
	public void deleteById( Integer id )
	{
		employeeDAO.deleteById( id );
	}
}
