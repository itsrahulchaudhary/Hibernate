package in.rahulit;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.rahulit.entity.Student;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Hibernate Project Started ::");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		System.out.println("--------------Create-----------------------------");
		// Case-1
		//String query = "from Student";   
		
		// Case-2
		//String query = "from Student where city='Delhi'";
		
		// Case-3
		//String query = "from Student where city= :x";		
		//Query createQuery = session.createQuery(query);
		//createQuery.setParameter("x", "Delhi");
		
		// Case-4
		String query = "from Student as s where s.city= :x and s.name=:n";		
		Query createQuery = session.createQuery(query);
		createQuery.setParameter("x", "Delhi");
		createQuery.setParameter("n", "Lala");
		
		//Query createQuery = session.createQuery(query);
		List<Student> list = createQuery.list();
		
		for(Student s : list) {
			System.out.println(s.getName()+" :: "+s.getCertificate().getCource());
		}
	
		session.close();
		factory.close();
	}

}
