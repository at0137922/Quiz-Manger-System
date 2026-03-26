public class Main {
    public static void main(String[] args) {
        System.out.println("===== Quiz Manager System Test =====\n");

        // Part 1: Test Question and Quiz Classes
        System.out.println("--- Part 1: Question and Quiz Classes ---");
        Question q1 = new Question("What is 2 + 2?", 
                                   new String[]{"3", "4", "5"}, 1);
        Question q2 = new Question("What is the capital of France?", 
                                   new String[]{"Berlin", "Paris", "Rome"}, 1);

        Quiz basicQuiz = new Quiz("General Knowledge");
        basicQuiz.addQuestion(q1);
        basicQuiz.addQuestion(q2);

        System.out.println("Quiz: " + basicQuiz.getTitle());
        for (Question question : basicQuiz.getQuestions()) {
            System.out.println("  Question: " + question.getPrompt());
        }
        System.out.println();

        // Part 2: Test Singleton Pattern (DataLayer)
        System.out.println("--- Part 2: Singleton Pattern (DataLayer) ---");
        DataLayer dataLayer1 = DataLayer.getInstance();
        DataLayer dataLayer2 = DataLayer.getInstance();
        System.out.println("dataLayer1 == dataLayer2: " + (dataLayer1 == dataLayer2));
        
        dataLayer1.saveQuiz(basicQuiz);
        Quiz retrievedQuiz = dataLayer2.getQuiz("General Knowledge");
        System.out.println("Retrieved Quiz: " + retrievedQuiz.getTitle());
        System.out.println();

        // Part 3: Test Observer Pattern
        System.out.println("--- Part 3: Observer Pattern ---");
        QuizManager quizManager = new QuizManager();
        Logger logger = new Logger();
        NotificationService notificationService = new NotificationService();
        
        quizManager.addObserver(logger);
        quizManager.addObserver(notificationService);
        
        quizManager.startQuiz(basicQuiz);
        quizManager.submitAnswer(0, 1);  // Correct answer for q1
        quizManager.submitAnswer(1, 1);  // Correct answer for q2
        quizManager.completeQuiz();
        System.out.println();

        // Part 4: Test Factory Pattern
        System.out.println("--- Part 4: Factory Pattern ---");
        Quiz timedQuiz = QuizFactory.createQuiz("timed", "Science Quiz");
        Quiz standardQuiz = QuizFactory.createQuiz("standard", "Math Quiz");
        
        System.out.println("Timed Quiz: " + timedQuiz.getTitle());
        System.out.println("Time Limit: " + ((TimedQuiz) timedQuiz).getTimeLimit() + " seconds");
        System.out.println("Standard Quiz: " + standardQuiz.getTitle());
        System.out.println();

        // Part 5: Test with multiple quizzes
        System.out.println("--- Part 5: Multiple Quizzes ---");
        Question q3 = new Question("What is the chemical symbol for Gold?", 
                                   new String[]{"Au", "Ag", "Cu"}, 0);
        timedQuiz.addQuestion(q3);
        
        QuizManager quizManager2 = new QuizManager();
        quizManager2.addObserver(logger);
        quizManager2.startQuiz(timedQuiz);
        quizManager2.submitAnswer(0, 0);  // Correct answer
        quizManager2.completeQuiz();
        System.out.println();
        
        System.out.println("===== Test Complete =====");
    }
}