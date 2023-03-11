package com.lreyes.junitdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    private DemoUtils demoUtils;

    @BeforeEach
    void init() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Add two values")
    void add() {
        var result = demoUtils.add(2, 4);
        var expected = 6;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Verify null and not null")
    void checkNull() {
        var nullResult = demoUtils.checkNull(null);
        var notNullResult = demoUtils.checkNull("Empty");

        assertNull(nullResult);
        assertNotNull(notNullResult);
    }

    @Test
    @DisplayName("Same and not same")
    void sameAndNotSame() {
        var str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate());
        assertNotSame(str, demoUtils.getAcademy());
    }

    @Test
    @DisplayName("Should be greater")
    void isGreater() {
        var response = demoUtils.isGreater(4, 1);

        assertTrue(response);
    }

    @Test
    @DisplayName("Should be lower")
    void isLower() {
        var response = demoUtils.isGreater(1, 4);

        assertFalse(response);
    }

    @Test
    @DisplayName("Array equals")
    void arrayEquals() {
        String[] expected = {"A", "B", "C"};

        var response = demoUtils.getFirstThreeLettersOfAlphabet();

        assertArrayEquals(expected, response);
    }

    @Test
    @DisplayName("List equals")
    void listEquals() {
        var expected = List.of("luv", "2", "code");

        var response = demoUtils.getAcademyInList();

        assertIterableEquals(expected, response);
    }

    @Test
    @DisplayName("Throw an exception")
    void throwException() {
        assertThrows(Exception.class, () -> demoUtils.throwException(-1));
    }

    @Test
    @DisplayName("Test does not throw and exception")
    void doesNothrowException() {
        assertDoesNotThrow(() -> demoUtils.throwException(1));
    }

    @Test
    @DisplayName("Test checkTimeout")
    void checkTimeout() {
        assertTimeoutPreemptively(Duration.ofMillis(10000L), () -> demoUtils.checkTimeout());
    }
}
