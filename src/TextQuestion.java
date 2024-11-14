/*
 * Created on 2024-11-14
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public class TextQuestion implements Question {
    private String question;
    private String[] options;
    private char correctAnswer;

    // Constructor & getters
    public TextQuestion(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    // Implement the interface methods
    @Override
    public int score(String answer) {
        // TODO: implement the score method
        // Should return 1 if the answer is correct, otherwise return 0
        
        // Hint: You can use answer.charAt(0) to get the first character 
        // of the answer string
        return 0;
    }

    @Override
    public void display(TriviaView view) {
        // TODO: Add the question and answer options to the view
        // Hint: Take a look at the methods in TriviaView!
    }

    @Override
    public void showResult(String answer, TriviaView view) {
        // TODO: Add an appropriate output for the result
        // Hint: You can get the answer's first character using: answer.charAt(0)
        String resultText = "";
        view.showResultResult(resultText);
    }

    @Override
    public void clearResultText(TriviaView view) {
        view.clearResultText();
    }
}
