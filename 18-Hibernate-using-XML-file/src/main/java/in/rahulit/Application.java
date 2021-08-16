package in.rahulit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.rahulit.entity.Person;

@SpringBootApplication
public class Application {
// // src/main/java/person.hbm.xml
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Person person = new Person(122, "Rajesh", "Mumbai", "12345");

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(person);
		transaction.commit();
		session.close();
		factory.close();

	}

}
