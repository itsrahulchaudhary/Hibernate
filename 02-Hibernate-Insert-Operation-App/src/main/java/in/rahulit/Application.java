package in.rahulit;

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

		// Create student object
		Student std1 = new Student();
		std1.setId(101);
		std1.setName("Raja");
		std1.setCity("Rani");
		System.out.println(std1);

		Student std2 = new Student();
		std2.setId(102);
		std2.setName("Raja");
		std2.setCity("Rani");
		System.out.println(std2);

		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();
		session.save(std1);
		session.save(std2);

		txt.commit();
		session.close();
	}

}
