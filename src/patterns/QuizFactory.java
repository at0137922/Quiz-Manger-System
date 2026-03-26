public class QuizFactory {
    public static Quiz createQuiz(String type, String title) {
        if (type.equalsIgnoreCase("timed")) {
            return new TimedQuiz(title);
        } else if (type.equalsIgnoreCase("standard")) {
            return new Quiz(title);
        } else {
            throw new IllegalArgumentException("Unknown quiz type: " + type);
        }
    }
}