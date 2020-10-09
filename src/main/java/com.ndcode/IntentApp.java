package com.ndcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntentApp {
    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        BufferedReader questionReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your desired question: ");

        try {
            var question = questionReader.readLine();
            var userIntent = "is not found";
            if (question.isEmpty()) {
                System.out.println("You did not enter a question!");
            } else if (question.contains("weather")) {
                IntentRecognizer intentRecognizer = new IntentRecognizer();
                userIntent = intentRecognizer.getWeather(question);
            } else if (question.contains("free")) {
                IntentRecognizer intentRecognizer = new IntentRecognizer();
                userIntent = intentRecognizer.checkCalendarForFreeSlot(question);
            } else if (question.contains("fact")) {
                IntentRecognizer intentRecognizer = new IntentRecognizer();
                userIntent = intentRecognizer.getInterestingFact(question);
            }
            System.out.println("Your question is: " + question);
            System.out.println("Your desired intent: " + userIntent);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

