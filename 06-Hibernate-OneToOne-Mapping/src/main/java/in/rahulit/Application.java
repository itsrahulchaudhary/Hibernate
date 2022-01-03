package in.rahulit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.rahulit.entity.Answer;
import in.rahulit.entity.Question;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		System.out.println("Hibernate Project Started ::");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating object
		Question qn = new Question();
		qn.setQuestionId(124);
		qn.setQuestion("What is Java???");

		// creating object
		Answer an = new Answer();
		an.setAnswerId(101);
		an.setAnswer("Java is a programming language");

		qn.setAnswer(an);
		an.setQuestion(qn);
		Session session = factory.openSession();

		Transaction txt = session.beginTransaction();
		session.save(qn);
		//session.save(an);
		txt.commit();
		
		// fetching data
		Question ques = (Question) session.get(Question.class, 124);
		System.out.println(ques.getQuestion());
		System.out.println(ques.getAnswer().getAnswer());

		session.close();
		factory.close();
	}

}
