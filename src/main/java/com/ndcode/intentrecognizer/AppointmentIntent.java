package com.ndcode.intentrecognizer;

import java.util.Random;

public class AppointmentIntent {

    //checkAppointments using sub-methods of claas find the time
    //and day from given query and check display random output
    public void checkAppointment(String question) {
        System.out.println("Intent: Check calendar");

        // parsing question for time slot and day
        var timeSlotRequested = getSlotFromQuestion(question);
        var dayRequested = getDayFromQuestion(question);

        // checking calendar
        var checkIfFree = checkCalendarForTimeAndDay(timeSlotRequested, dayRequested);

        System.out.println("Free: " + (checkIfFree ? "Yes" : "No"));
    }

    // getting time from question
    private String getSlotFromQuestion(String question) {
        //TODO: Logic for getting time from question
        return "timeSlot";
    }

    // getting day from question
    private String getDayFromQuestion(String question) {
        //TODO: Logic for getting day from question
        return "day";
    }

    // checking calendar for time and day provided
    private Boolean checkCalendarForTimeAndDay(String time, String day) {
        //TODO: Check using calendar api the requested time and day

        //Return random true/false value for a prototype implementation
        Random random = new Random();
        return random.nextBoolean();
    }
}