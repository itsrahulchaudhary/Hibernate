package in.rahulit;

import java.util.ArrayList;
import java.util.List;

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
		Session session = factory.openSession();
    /*
		// creating object
		Question q1 = new Question();
		q1.setQuestionId(124);
		q1.setQuestion("What is Java???");

		// creating object
		Answer an = new Answer();
		an.setAnswerId(101);
		an.setAnswer("Java is a programming language");
		an.setQuestion(q1);

		Answer an2 = new Answer();
		an2.setAnswerId(102);
		an2.setAnswer("with the help of java we develop software");
		an2.setQuestion(q1);

		List<Answer> ans = new ArrayList<Answer>();
		ans.add(an);
		ans.add(an2);

		q1.setAnswers(ans);
		

		Transaction txt = session.beginTransaction();
		session.save(q1);
		session.save(an);
		session.save(an2);

		txt.commit();
     */
		
		// fetching data 
		Question ques = (Question) session.get(Question.class, 124);
		
		// It is working as Lazy beacuse we didnt call ques.getanswer() method. and it is not selecting complete query
		System.out.println(ques.getQuestion());
		/*
		   select
	          question0_.questionId as question1_1_0_,
	          question0_.question as question2_1_0_ 
	       from
	          Question question0_ 
	       where
	          question0_.questionId=?
		 */
		
		// When we call ques.getanswer() then it will call select complete query
		System.out.println(ques.getAnswers().size());
		/*
		     select
                 answers0_.question_questionId as question3_1_1_,
                 answers0_.answerId as answerId1_0_1_,
                 answers0_.answerId as answerId1_0_0_,
                 answers0_.answer as answer2_0_0_,
                 answers0_.question_questionId as question3_0_0_ 
              from
                 Answer answers0_ 
              where
                 answers0_.question_questionId=?
		 */
		session.close();
		factory.close();

	}

}
