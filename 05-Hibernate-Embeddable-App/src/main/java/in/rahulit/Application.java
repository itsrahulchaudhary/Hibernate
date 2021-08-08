package in.rahulit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.rahulit.entity.Certificate;
import in.rahulit.entity.Student;
 

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		System.out.println("Hibernate Project Started ::");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student st = new Student();
		st.setId(110);
		st.setName("Ranjan");
		st.setCity("Delhi");

		Certificate ct = new Certificate();
		ct.setCource("SpringBoot & Micro");
		ct.setDuration("3 months");

		st.setCertificate(ct);

		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();
		session.save(st);

		txt.commit();
		session.close();
		factory.close();
	}

}
