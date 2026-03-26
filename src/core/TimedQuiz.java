public class TimedQuiz extends Quiz {
    private int timeLimit;  // Time limit in seconds

    public TimedQuiz(String title) {
        super(title);
        this.timeLimit = 60;  // Default time limit
    }

    public TimedQuiz(String title, int timeLimit) {
        super(title);
        this.timeLimit = timeLimit;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
}