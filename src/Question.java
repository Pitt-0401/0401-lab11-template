/*
 * Created on 2024-11-14
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

// No need to change this file!
interface Question {
    int score(String answer);

    void display(TriviaView view);

    void showResult(String answer, TriviaView view);

    void clearResultText(TriviaView view);
}
