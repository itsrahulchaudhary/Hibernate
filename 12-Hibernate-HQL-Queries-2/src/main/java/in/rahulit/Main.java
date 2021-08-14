package in.rahulit;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Main {
	public static void main(String[] args) {
		System.out.println("Hibernate Project Started ::");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		System.out.println("--------------Create-----------------------------");
		// Case-1
		//String query = "from Student2";    
		
		// Case-2
		//String query = "from Student2 where city='Delhi'";
		
		// Case-3
		//String query = "from Student2 where city= :x";		
		//Query createQuery1 = session.createQuery(query);
		// createQuery1.setParameter("x", "Delhi");
		
		// Case-4
		//String query = "from Student2 as s where s.city= :x and s.name=:n";		
		//Query createQuery = session.createQuery(query);
		//createQuery.setParameter("x", "Delhi");
		//createQuery.setParameter("n", "Ranjan");
		
//		Query createQuery = session.createQuery(query);
//		List<Student2> list = createQuery.list();
//		
//		for(Student2 s : list) {
//			System.out.println(s.getName()+" :: "+s.getCertificate().getCource());
//		}
		
		System.out.println("--------------Delete-----------------------------");
		Transaction beginTransaction = session.beginTransaction();
//		Query createQuery2 = session.createQuery("delete from Student2 as s where s.city= :c");
//		createQuery2.setParameter("c",  "Noida");
//		int executeUpdate = createQuery2.executeUpdate();
//		System.out.println(executeUpdate+" objected deleted");

		System.out.println("--------------Update-----------------------------");
//	    Query createQuery3 = session.createQuery("update Student2 set city=:c where name=:n");
//		createQuery3.setParameter("c",  "Noidaaa11");
//		createQuery3.setParameter("n",  "Ramesh");
//		int executeUpdate2 = createQuery3.executeUpdate();
//		System.out.println(executeUpdate2+" objected updated");
		Query query = session.createQuery("update Student2 set city = 'DIALOG212345'" +
				" where id = '111'");
                 int result = query.executeUpdate();
                 System.out.println(result+" objected updated");
		
		System.out.println("--------------Join Query-----------------------------");
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
