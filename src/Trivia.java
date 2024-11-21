/*
 * Created on 2024-11-14
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Trivia {
    private static final String appName = "Trivia!";

    // Define an index to identify which question is currently displayed
    private static int currentQuestionIndex = 0;
    // Initialize the score
    private static int score = 0;

    // TODO: Add one more question about your favorite/least favorite Java topic

    public static void main(String[] args) {
        // TODO: Read the questions from the provided csv file
        // Note: The actual functionality is already implemented!
        List<TextQuestion> questions = ?;

        // TODO: initialize a new view

        // TODO: load the current question into the view

        // TODO: uncomment
        // addButtonListeners(questions, view);
    }

    private static void updateViewWithQuestion(TriviaView view, TextQuestion question) {
        // TODO: implement this method
        // Hint: The question and answer options need to be set
    }

    // Button listeners for checking an answer and displaying the next question
    // NO NEED TO TOUCH THIS METHOD - unless you expand it
    private static void addButtonListeners(List<TextQuestion> questions, TriviaView view) {
        view.addCheckAnswerListener(_ -> {
            // Check if an answer has been selected
            char selectedAnswerChar = view.getSelectedAnswer();
            if (selectedAnswerChar == ' ') {
                JOptionPane.showMessageDialog(view, "Please select an answer.");
                return;
            }

            // Get the score
            String selectedAnswer = String.valueOf(view.getSelectedAnswer());

            // Display result
            questions.get(currentQuestionIndex).showResult(selectedAnswer, view);
        });

        view.addNextButtonListener(_ -> {
             // Get the score
             String selectedAnswer = String.valueOf(view.getSelectedAnswer());
             score += questions.get(currentQuestionIndex).score(selectedAnswer);

             // Clear result text
             questions.get(currentQuestionIndex).clearResultText(view);

            // Move to the next question
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.size()) {
                updateViewWithQuestion(view, questions.get(currentQuestionIndex));
                view.clearSelection();
            } else {
                JOptionPane.showMessageDialog(view, "Trivia finished! Your score: " + score);
                view.dispose();
            }
        });
    }

    // Read the questions from a csv file
    // NO NEED TO TOUCH THIS METHOD!
    public static List<TextQuestion> readQuestionsFromCSV(String filename) {
        List<TextQuestion> questions = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] cells = line.split(",");
                // CSV fields are: Question, Option A, Option B, Option C, Correct Answer
                if (cells.length >= 5) {
                    String question = cells[0];
                    String[] options = { cells[1], cells[2], cells[3] };
                    char correctAnswer = cells[4].trim().charAt(0);

                    questions.add(new TextQuestion(question, options, correctAnswer));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
