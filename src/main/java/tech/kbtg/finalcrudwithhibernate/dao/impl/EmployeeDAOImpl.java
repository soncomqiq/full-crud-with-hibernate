package tech.kbtg.finalcrudwithhibernate.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import tech.kbtg.finalcrudwithhibernate.dao.EmployeeDAO;
import tech.kbtg.finalcrudwithhibernate.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{
	private EntityManager entityManager;

	public EmployeeDAOImpl( EntityManager entityManager )
	{
		this.entityManager = entityManager;
	}

	@Override
	public Employee save( Employee employee )
	{
		return entityManager.merge( employee );
	}

	@Override
	public List < Employee > findAll()
	{
		TypedQuery < Employee > query = entityManager.createQuery( "FROM Employee" , Employee.class );
		List < Employee > employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById( Integer id )
	{
		return entityManager.find( Employee.class, id );
	}

	@Override
	public void deleteById( Integer id )
	{
		Employee employee = 
				entityManager.find( Employee.class , id );
		entityManager.remove( employee );
	}
}
