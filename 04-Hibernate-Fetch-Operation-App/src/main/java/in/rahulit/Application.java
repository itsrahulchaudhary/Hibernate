package in.rahulit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.rahulit.entity.Student;

 

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	        // get() , load()
			System.out.println("Hibernate Project Started ::");
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			
			// get() method return null if object does not found
			Student student = (Student) session.get(Student.class, 102);
			System.out.println(student);
			
			// load() method return Object not found exception if object does not found
			//Student student2 = (Student) session.load(Student.class, 102);
			//System.out.println(student2);

			session.close();
			factory.close();
	}

}
