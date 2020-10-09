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
            if (question.isEmpty()) {
                System.out.println("You did not enter a question!");
            } else if (question.contains("weather")) {
                //getWeather(String question)
            } else if (question.contains("free")) {
                //checkCalendarForFreeSlot(String question)
            } else if (question.contains("fact")) {
                //getInterestingFact(String question)
            } else {
                System.out.println("Your question is: " + question);

                System.out.println("Your desired intent cannot be recognize please try again.");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

