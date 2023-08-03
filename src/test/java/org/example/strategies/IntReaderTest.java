package org.example.strategies;

import org.example.enums.SortMode;
import org.example.strategies.IntReader;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntReaderTest {

    private IntReader ascReader;
    private IntReader descReader;

    @BeforeEach
    public void setUp() {
        File intFile = new File(this.getClass().getResource("/int/test.txt").getFile());
        String testFilePath = intFile.getAbsolutePath();
        try {
            ascReader = new IntReader(testFilePath, SortMode.ASCENDING);
            descReader = new IntReader(testFilePath, SortMode.DESCENDING);
        } catch (IOException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test ascending sorting")
    public void testValueCompareAscending() {
        assertTrue(ascReader.valueCompare("10", "5"));
        assertFalse(ascReader.valueCompare("5", "10"));
        assertFalse(ascReader.valueCompare("10", "10"));
    }

    @Test
    @DisplayName("Test descending sorting")
    public void testValueCompareDescending() {
        assertTrue(descReader.valueCompare("5", "10"));
        assertFalse(descReader.valueCompare("10", "5"));
        assertFalse(descReader.valueCompare("10", "10"));
    }

    @Test
    @DisplayName("Test valid inputs")
    public void testIsValidWithValidInput() {
        assertTrue(ascReader.isValid("123"));
        assertTrue(ascReader.isValid("-456"));
    }

    @Test
    @DisplayName("Test invalid inputs")
    public void testIsValidWithInvalidInput() {
        assertFalse(ascReader.isValid("abc"));
        assertFalse(ascReader.isValid("12a"));
        assertFalse(ascReader.isValid("1 2 3"));
        assertFalse(ascReader.isValid("1.2"));
    }
}
