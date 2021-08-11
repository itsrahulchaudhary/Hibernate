package in.rahulit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
 
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {

	@Id
	private int questionId;
	private String question;
    // By default we have LAZY loading but we not to change then we can write as EAGER loading
	// LAZY loading simply menas when we are calling get data from session it will not fire query unit we have to 
	// call method explicitly.
	// EAGER loading simply means when we are calling get data from session then only it will fire query.
	@OneToMany(mappedBy = "question" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Answer> answers;

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;

	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}