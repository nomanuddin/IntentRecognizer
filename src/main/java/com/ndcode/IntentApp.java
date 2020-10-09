package com.ndcode;

import com.ndcode.intentrecognizer.AppointmentIntent;
import com.ndcode.intentrecognizer.FactIntent;
import com.ndcode.intentrecognizer.WeatherIntent;

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
            } else if (question.contains("weather")
            ) {
                WeatherIntent weatherIntent = new WeatherIntent();
                weatherIntent.getWeather(question);
            } else if (question.contains("free")
                    || question.contains(":")
                    || question.contains("appointment")
            ) {
                AppointmentIntent appointmentIntent = new AppointmentIntent();
                appointmentIntent.checkCalendarForFreeSlot(question);
            } else if (question.contains("fact")) {
                FactIntent factIntent = new FactIntent();
                factIntent.getInterestingFact();
            } else System.out.println("Intent is not recognized please try again!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

