import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private List<Observer> observers = new ArrayList<>();
    private DataLayer dataLayer;
    private Quiz currentQuiz;
    private int score = 0;

    public QuizManager() {
        this.dataLayer = DataLayer.getInstance();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void startQuiz(Quiz quiz) {
        this.currentQuiz = quiz;
        this.score = 0;
        notifyObservers("Quiz started: " + quiz.getTitle());
    }

    public void submitAnswer(int questionIndex, int answerIndex) {
        if (currentQuiz != null && questionIndex < currentQuiz.getQuestions().size()) {
            Question question = currentQuiz.getQuestions().get(questionIndex);
            if (question.isCorrect(answerIndex)) {
                score++;
                notifyObservers("Answer " + (questionIndex + 1) + " is correct!");
            } else {
                notifyObservers("Answer " + (questionIndex + 1) + " is incorrect.");
            }
        }
    }

    public void completeQuiz() {
        if (currentQuiz != null) {
            String message = "Quiz completed: " + currentQuiz.getTitle() + 
                           " | Score: " + score + "/" + currentQuiz.getQuestions().size();
            notifyObservers(message);
            dataLayer.saveQuiz(currentQuiz);
            currentQuiz = null;
        }
    }

    public int getScore() {
        return score;
    }

    public Quiz getCurrentQuiz() {
        return currentQuiz;
    }
}