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
		
		// Hibernate Object State
		// Transient
		// Persistance
		// Detached
		// Removed
		
		System.out.println("Hibernate Project Started ::");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Create the object
		Student st = new Student();
		st.setId(110);
		st.setName("Ranjan");
		st.setCity("Delhi");
		st.setCertificate(new Certificate("SpringBoot", "2 months"));
		//student :: Transient


		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();
		session.save(st);
        //student :: Persistent - session, database
		st.setName("Lala");
		
		txt.commit();
		session.close();
		//student :: Detached
		st.setName("Ramu");
		System.out.println("Name :: "+st.getName());
		factory.close();
		
		
		
		
	}

}
