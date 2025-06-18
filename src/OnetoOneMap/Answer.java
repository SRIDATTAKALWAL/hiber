package OnetoOneMap;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Answer")
public class Answer {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int ansid;

	    private String answer;

	    @OneToOne(mappedBy = "answer")  // Mapped by the 'answer' field in Question
	    private Question question;

	    public Answer() {
		
			// TODO Auto-generated constructor stub
		}
		public Answer(String string) {
			// TODO Auto-generated constructor stub
		}
		// Getters and Setters
	    public int getAnsid() { return ansid; }
	    public void setAnsid(int ansid) { this.ansid = ansid; }

	    public String getAnswer() { return answer; }
	    public void setAnswer(String answer) { this.answer = answer; }

	    public Question getQuestion() { return question; }
	    public void setQuestion(Question question) { this.question = question; }
}