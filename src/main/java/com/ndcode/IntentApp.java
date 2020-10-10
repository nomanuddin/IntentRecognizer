package com.ndcode;

import com.ndcode.intentrecognizer.AppointmentIntent;
import com.ndcode.intentrecognizer.FactIntent;
import com.ndcode.intentrecognizer.WeatherIntent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class IntentApp {
    /**
     * Application entry point.
     */
    static Logger logger = Logger.getLogger(IntentApp.class.getName());

    public static void main(String[] args) {

        while (true) {
            // defining reader for command line
            BufferedReader questionReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your desired question: ");

            // getting user question and parsing it
            try {
                //reading question from terminal
                var question = questionReader.readLine();

                //TODO: Following if conditions can be extended to switch statements
                //TODO: For using switch statements better option would be to
                //TODO: develop a standard parsing/regex library which can optimize the logic further
                if (question.isEmpty()) {
                    System.out.println("You did not enter a question!");
                }
                //if question contain weather keyword then respective class is called
                //for further processing
                else if (question.contains("weather")
                ) {
                    WeatherIntent weatherIntent = new WeatherIntent();
                    weatherIntent.getWeather(question);
                }
                //if question contain free or appointment keywords then respective class is called
                //for further processing
                else if (question.contains("free")
                        || question.contains("appointment")
                ) {
                    AppointmentIntent appointmentIntent = new AppointmentIntent();
                    appointmentIntent.checkAppointment(question);
                }//if question contain fact keyword then respective class is called
                //for further processing
                else if (question.contains("fact")) {
                    FactIntent factIntent = new FactIntent();
                    factIntent.getInterestingFact();
                } else System.out.println("Intent is not recognized please try again!");

            } catch (IOException e) {
                logger.info("Error: Please contact administrator" + e.getMessage());
            }
            System.out.println("");
        }
    }
}

