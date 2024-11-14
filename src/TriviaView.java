/*
 * Created on 2024-11-14
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import javax.swing.*;
import java.awt.event.ActionListener;

// We define a custom View that extends the functionality from JFrame
public class TriviaView extends JFrame {
    // Define UI elements
    private JLabel questionLabel;
    private JRadioButton[] radioButtons;
    private JButton checkAnswerButton;
    private JButton nextButton;
    private ButtonGroup group;
    private JLabel resultLabel;

    public TriviaView(String appName) {
        // Setup the frames
        setTitle(appName);
        // Default operation that will happenwhen the user closes this frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Define the window's size
        // TODO: define useful values here
        setSize(0, 0);

        generateLayout();
    }

    // Getters and setters
    public char getSelectedAnswer() {
        for (int i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].isSelected()) {
                return (char) ('A' + i);
            }
        }
        return ' ';
    }

    public void setQuestion(String question) {
        // TODO: set the question label's text
    }

    public void setOptions(String[] options) {
        // TODO: set the text for the radio buttons to display the answer options
    }

    // Setup the view's layout
    // Adds labels and buttons
    private void generateLayout() {
        // Add question label
        questionLabel = new JLabel();
        questionLabel.setBounds(50, 20, 450, 20);
        add(questionLabel);

        // Add radio buttons for answer options as a button group
        radioButtons = new JRadioButton[3];
        group = new ButtonGroup();
        for (int i = 0; i < 3; i++) {
            radioButtons[i] = new JRadioButton();
            radioButtons[i].setBounds(50, 50 + (i * 30), 450, 20);
            group.add(radioButtons[i]);
            add(radioButtons[i]);
        }

        // Add check answer button
        checkAnswerButton = new JButton("Check answer");
        checkAnswerButton.setBounds(50, 140, 150, 30);
        add(checkAnswerButton);

        // Add submit button
        nextButton = new JButton("Submit");
        nextButton.setBounds(200, 140, 150, 30);
        add(nextButton);

        // Add the result label
        resultLabel = new JLabel("");
        resultLabel.setBounds(60, 170, 300, 20);
        add(resultLabel);
    }

    // Button listeners (no need to change any code here!)
    public void addCheckAnswerListener(ActionListener listenForCheckAnswerButton) {
        checkAnswerButton.addActionListener(listenForCheckAnswerButton);
    }

    public void addNextButtonListener(ActionListener listenForNextButton) {
        nextButton.addActionListener(listenForNextButton);
    }

    public void clearSelection() {
        group.clearSelection();
    }

    public void showResultResult(String result) {
        resultLabel.setText(result);
    }

    public void clearResultText() {
        resultLabel.setText("");
    }
}
