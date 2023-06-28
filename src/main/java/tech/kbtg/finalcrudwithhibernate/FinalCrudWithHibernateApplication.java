package tech.kbtg.finalcrudwithhibernate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.kbtg.finalcrudwithhibernate.entity.Employee;
import tech.kbtg.finalcrudwithhibernate.service.EmployeeService;

@SpringBootApplication
public class FinalCrudWithHibernateApplication
{

	public static void main( String[] args )
	{
		SpringApplication.run( FinalCrudWithHibernateApplication.class , args );
	}

	@Bean
	public CommandLineRunner commandLineRunner( EmployeeService employeeService )
	{
		return runner -> {
			initData( employeeService );
		};
	}

	private void initData( EmployeeService employeeService )
	{
		Employee employee1 = new Employee( "Somsri" , "Manugtong" , "somsri.m@hotmail.com" );
		Employee employee2 = new Employee( "Sompong" , "Tongdee" , "sompong.t@hotmail.com" );
		Employee employee3 = new Employee( "Somruk" , "Meetung" , "somruk.m@hotmail.com" );

		employeeService.save( employee1 );
		employeeService.save( employee2 );
		employeeService.save( employee3 );
	}
}
