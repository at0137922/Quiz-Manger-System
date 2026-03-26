import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String title;                    // Quiz title
    private List<Question> questions;        // List of questions

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    protected List<Question> getQuestions() {
        return questions;  // Protected to allow subclasses to access questions
    }
}