package in.rahulit;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.rahulit.entity.Employee;
import in.rahulit.entity.Project;
 

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Hibernate Project Started ::");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		
		emp1.setEid(101);
		emp1.setEmployeename("Ranjan");
		
		emp2.setEid(102);
		emp2.setEmployeename("Vijay");
		
		Project pro1 = new Project();
		Project pro2 = new Project();
		
		pro1.setPid(201);
		pro1.setProjectname("LMS");
		
		pro2.setPid(202);
		pro2.setProjectname("BMS");
		
		List<Employee> empList = new ArrayList<>();
		List<Project> proList = new ArrayList<>();
		
		empList.add(emp1);
		empList.add(emp2);
		
		proList.add(pro1);
		proList.add(pro2);
		

		emp1.setProjects(proList);
		pro1.setEmployees(empList);
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();
		session.save(emp1);
		session.save(emp2);
		session.save(pro1);
		session.save(pro2);
		txt.commit();

		
		session.close();
		factory.close();
	}

}
