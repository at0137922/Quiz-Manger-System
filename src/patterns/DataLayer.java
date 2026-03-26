import java.util.HashMap;
import java.util.Map;

public class DataLayer {
    private static DataLayer instance;           // Singleton instance
    private Map<String, Quiz> quizzes;           // Store quizzes by title

    private DataLayer() {
        this.quizzes = new HashMap<>();
    }

    public static synchronized DataLayer getInstance() {
        if (instance == null) {
            instance = new DataLayer();
        }
        return instance;
    }

    public void saveQuiz(Quiz quiz) {
        quizzes.put(quiz.getTitle(), quiz);
    }

    public Quiz getQuiz(String title) {
        return quizzes.get(title);
    }

    public Map<String, Quiz> getAllQuizzes() {
        return new HashMap<>(quizzes);
    }
}