package in.rahulit;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.rahulit.entity.StudentDetail;

 

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(StudentDetail.class);
	    criteria.add(Restrictions.eq("city", "City - 11"));
		//criteria.add(Restrictions.gt("id", 30));

		List<StudentDetail> list = criteria.list();
		for(StudentDetail sd : list) {
			System.out.println(sd.getId()+" :: "+sd.getName());
		}
		session.close();
		factory.close();
	}

}
