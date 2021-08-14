package in.rahulit.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 

public class InsertStudentDetailData {
	public static void main(String[] args) {

		System.out.println("Hibernate Project Started ::");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();

		for (int i = 1; i <= 100; i++) {
			StudentDetail detail = new StudentDetail();
			detail.setId(i);
			detail.setName("Name - " + String.valueOf(i));
			detail.setCity("City - " + String.valueOf(i));
			session.save(detail);
		}

		txt.commit();
		session.close();
		factory.close();
	}

}
