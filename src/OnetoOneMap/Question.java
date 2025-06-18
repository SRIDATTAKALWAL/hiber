package OnetoOneMap;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question; // ✅ Correct field name

    @OneToOne
    @JoinColumn(name = "answer_id") // foreign key column
    private Answer answer;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    // ToString method for clean print
    @Override
    public String toString() {
        return "Question{id=" + id + 
               ", question='" + question + '\'' + 
               ", answer=" + answer + '}';
    }
}