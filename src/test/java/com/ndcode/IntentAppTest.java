package com.ndcode;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class IntentAppTest {

    @Test
    void testIntentApp() {
        IntentApp intentApp = mock(IntentApp.class);
        doNothing().when(intentApp);
    }
}