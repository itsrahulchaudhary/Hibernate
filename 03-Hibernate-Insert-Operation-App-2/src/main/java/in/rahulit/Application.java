package in.rahulit;

import java.io.FileInputStream;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.rahulit.entity.Address;
import in.rahulit.entity.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

		System.out.println("Hibernate Project Started ::");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Create student object
		Student st = new Student();
		st.setId(102);
		st.setName("Shashank");
		st.setCity("Delhi");
		System.out.println(st);

		// Create address object
		Address ad = new Address();
		ad.setStreet("stree-1");
		ad.setCity("Noida");
		ad.setCreatedDate(new Date());
		ad.setOpen(true);
		ad.setX(12.12);
		System.out.println(ad);

		// Reading pictures
		FileInputStream fs = new FileInputStream("src/main/java/kia.png");
		byte[] data = new byte[fs.available()];
		fs.read(data);
		ad.setImg(data);
		fs.close();

		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();
		session.save(st);
		session.save(ad);

		txt.commit();
		session.close();

	}

}
