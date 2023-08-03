package org.example.strategies;

import org.example.enums.SortMode;
import org.example.strategies.StringReader;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringReaderTest {

    private StringReader ascReader;
    private StringReader descReader;

    @BeforeEach
    public void setUp() {
        File inputXmlFile = new File(this.getClass().getResource("/string/test.txt").getFile());
        String testFilePath = inputXmlFile.getAbsolutePath();
        try {
            ascReader = new StringReader(testFilePath, SortMode.ASCENDING);
            descReader = new StringReader(testFilePath, SortMode.DESCENDING);
        } catch (IOException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test ascending sorting")
    public void testValueCompareAscending() {
        assertFalse(ascReader.valueCompare("apple", "banana"));
        assertTrue(ascReader.valueCompare("banana", "apple"));
        assertFalse(ascReader.valueCompare("apple", "apple"));
    }

    @Test
    @DisplayName("Test descending sorting")
    public void testValueCompareDescending() {
        assertFalse(descReader.valueCompare("banana", "apple"));
        assertTrue(descReader.valueCompare("apple", "banana"));
        assertFalse(descReader.valueCompare("apple", "apple"));
    }

    @Test
    @DisplayName("Test valid inputs")
    public void testIsValidWithValidInput() {
        assertTrue(ascReader.isValid("apple"));
        assertTrue(ascReader.isValid("banana"));
    }

    @Test
    @DisplayName("Test invalid inputs")
    public void testIsValidWithInvalidInput() {
        assertFalse(ascReader.isValid(""));
        assertFalse(ascReader.isValid("apple banana"));
        assertFalse(ascReader.isValid("  spaces  "));
    }
}
