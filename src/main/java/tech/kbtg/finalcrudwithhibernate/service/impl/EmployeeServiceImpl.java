package tech.kbtg.finalcrudwithhibernate.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.kbtg.finalcrudwithhibernate.entity.Employee;
import tech.kbtg.finalcrudwithhibernate.repository.EmployeeRepository;
import tech.kbtg.finalcrudwithhibernate.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl( EmployeeRepository employeeRepository )
	{
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List < Employee > findAll()
	{
		return employeeRepository.findAll();
	}

	@Override
	public Employee save( Employee employee )
	{
		return employeeRepository.save( employee );
	}

	@Override
	public Employee findById( Integer id )
	{
		Optional < Employee > employeeOptional = employeeRepository.findById( id );
		if ( employeeOptional.isPresent() )
		{
			return employeeOptional.get();
		}
		else
		{
			throw new RuntimeException( "Didn't find Employee ID - " + id );
		}
	}

	@Override
	public void deleteById( Integer id )
	{
		employeeRepository.deleteById( id );
	}
}
