package in.rahulit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.rahulit.entity.StudentDetail;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		System.out.println("Hibernate Project Started ::");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		StudentDetail std = (StudentDetail) session.get(StudentDetail.class, 2);
		System.out.println(std);
		
		// contains() method check data is available in first level cache
		System.out.println(session.contains(std));
		
		System.out.println("-------------------------------------");

		StudentDetail std2 = (StudentDetail) session.get(StudentDetail.class, 2);
		System.out.println(std2);

		session.close();

		factory.close();
	}

}
