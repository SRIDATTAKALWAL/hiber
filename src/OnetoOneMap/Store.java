package OnetoOneMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Store {
    public static void main(String[] args) {
        // Create configuration and load hibernate.cfg.xml
        Configuration  cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Answer.class);
        cfg.addAnnotatedClass(Question.class);

        // Build session factory and open session
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        try {
            // Begin transaction
            session.beginTransaction();

            // Create Answer
            Answer ans = new Answer();
            ans.setAnswer("Java is a programming language.");

            // Save Answer first (so it gets an ID)
            session.save(ans);

            // Create Question
            Question q = new Question();
            q.setQuestion("What is Java?");
            q.setAnswer(ans); // Set foreign key relation

            // Save Question
            session.save(q);

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Saved: " + q);
        } finally {
            session.close();
            factory.close();
        }
    }
}