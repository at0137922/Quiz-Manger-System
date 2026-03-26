public class Question {
    private String prompt;           // The question text
    private String[] options;        // Possible answers
    private int correctAnswerIndex;  // Index of the correct answer

    public Question(String prompt, String[] options, int correctAnswerIndex) {
        this.prompt = prompt;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
1
    public String getPrompt() {
        return prompt;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}