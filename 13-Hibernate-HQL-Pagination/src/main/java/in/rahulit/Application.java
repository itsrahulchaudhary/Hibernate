package in.rahulit;

import java.util.List;

import org.hibernate.Query;
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
		
		 Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		 SessionFactory sessionFactory = configure.buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 
		 Query createQuery = session.createQuery("from StudentDetail");
			createQuery.setFirstResult(0);
			createQuery.setMaxResults(5);
			
			List<StudentDetail> list = createQuery.list();
			for(StudentDetail sd : list) {
				System.out.println(sd.getId()+" :: "+sd.getName()+" :: "+sd.getCity());
			}
			session.close();
			sessionFactory.close();
		 
	}

}
