package in.rahulit;

 

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		System.out.println("Hibernate Project Started ::");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
 
		
		System.out.println("--------------Delete-----------------------------");
		Transaction beginTransaction = session.beginTransaction();
//		Query createQuery2 = session.createQuery("delete from Student2 as s where s.city= :c");
//		createQuery2.setParameter("c",  "Noida");
//		int executeUpdate = createQuery2.executeUpdate();
//		System.out.println(executeUpdate+" objected deleted");
// 
		//Query org.hibernate.SharedSessionContract.createQuery(String queryString)
		System.out.println("--------------Update-----------------------------");
//	    Query createQuery3 = session.createQuery("update Student set city=:c where id=110");
//		createQuery3.setParameter("c",  "Noidaaa");
//		//createQuery3.setParameter("n",  "Ramesh");
//		int executeUpdate2 = createQuery3.executeUpdate();
//		System.out.println(executeUpdate2+" objected updated");
		Query query = session.createQuery("update Student set city = 'DIALOG2'" +
				" where id = '111'");
                 int result = query.executeUpdate();
                 System.out.println(result+" objected updated");
		
//		System.out.println("--------------Join Query-----------------------------");
//		Query createQuery4 = session.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answers as a");
//		List<Object[]> list2 = createQuery4.list();
//		for(Object[] o : list2) {
//			System.out.println(Arrays.toString(o));
//		}

		beginTransaction.commit();
		session.close();
		factory.close();
	}

}
