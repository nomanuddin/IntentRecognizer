package com.ndcode.intentrecognizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class AppointmentIntentTest {

    String question = "Am I free at 13:00 PM tomorrow?";

    @Test
    void testCheckAppointment() {
        AppointmentIntent appointmentIntent = mock(AppointmentIntent.class);
        doNothing().when(appointmentIntent).checkAppointment(question);
    }

    @Test
    public void testGetSlotFromQuestion() {
        AppointmentIntent appointmentIntent = new AppointmentIntent();
        var slotFromQuestion = appointmentIntent.getSlotFromQuestion(question);
        assertEquals(slotFromQuestion, "timeSlot");
    }

    @Test
    void testGetDayFromQuestion() {
        AppointmentIntent appointmentIntent = new AppointmentIntent();
        String slotFromQuestion = appointmentIntent.getDayFromQuestion("Am I free at 13:00 PM tomorrow?");
        assertEquals(slotFromQuestion, "day");
    }
}