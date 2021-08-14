package in.rahulit;

import java.util.List;

import org.hibernate.SQLQuery;
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
		
		//SQL Query
		String q = "select * from studentdetail";
		SQLQuery createSQLQuery = session.createSQLQuery(q);
	    createSQLQuery.addEntity(StudentDetail.class);
		List<StudentDetail> list = createSQLQuery.list();
		for(StudentDetail detail : list) {
			System.out.println(detail.getId()+" :: "+detail.getName()+" :: "+detail.getCity());
		}
		session.close();
		factory.close();
	}

}
