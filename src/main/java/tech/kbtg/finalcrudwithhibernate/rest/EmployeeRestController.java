package tech.kbtg.finalcrudwithhibernate.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.kbtg.finalcrudwithhibernate.entity.Employee;
import tech.kbtg.finalcrudwithhibernate.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping ( "/api/employees" )
public class EmployeeRestController
{
	private EmployeeService employeeService;

	public EmployeeRestController( EmployeeService employeeService )
	{
		this.employeeService = employeeService;
	}

	@GetMapping ( "/" )
	public List < Employee > findAll()
	{
		return employeeService.findAll();
	}

	@GetMapping ( "/{employeeId}" )
	public Employee getEmployeeById( @PathVariable int employeeId )
	{
		Employee employee = employeeService.findById( employeeId );

		if ( employee == null )
		{
			throw new RuntimeException( "Employee id not found - " + employeeId );
		}

		return employee;
	}

	@PostMapping ( "/" )
	public Employee addEmployee( @RequestBody Employee employee )
	{
		employee.setId( 0 );

		Employee newEmployee = employeeService.save( employee );

		return newEmployee;
	}

	@PutMapping ( "/" )
	public Employee updateEmployee( @RequestBody Employee employee )
	{
		Employee updatedEmployee = employeeService.save( employee );

		return updatedEmployee;
	}

	@DeleteMapping ( "/{employeeId}" )
	public String deleteEmployeeId( @PathVariable int employeeId )
	{
		Employee employee = employeeService.findById( employeeId );

		if ( employee == null )
		{
			throw new RuntimeException( "Employee id not found - " + employeeId );
		}

		employeeService.deleteById( employeeId );

		return "Deleted employee id - " + employeeId;
	}
}
