package org.example.utils;

import org.example.enums.SortMode;
import org.example.enums.DataType;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    @DisplayName("Valid arguments with int")
    public void parserTest_ValidArguments_Success_1() {
        String[] args = {"-d", "-i", "output.txt", "input1.txt", "input2.txt"};
        try {
            Parser parser = new Parser(args);
            assertEquals(SortMode.DESCENDING, parser.getSortMode());
            assertEquals(DataType.INTEGER, parser.getDataType());
            assertEquals("output.txt", parser.getOutputFile());
            assertEquals(2, parser.getInputFiles().size());
            assertEquals("input1.txt", parser.getInputFiles().get(0));
            assertEquals("input2.txt", parser.getInputFiles().get(1));
        } catch (IllegalArgumentException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Valid arguments with string")
    public void parserTest_ValidArguments_Success_2() {
        String[] args = {"-s", "output.txt", "input1.txt", "input2.txt", "input3.txt"};
        try {
            Parser parser = new Parser(args);
            assertEquals(SortMode.ASCENDING, parser.getSortMode());
            assertEquals(DataType.STRING, parser.getDataType());
            assertEquals("output.txt", parser.getOutputFile());
            assertEquals(3, parser.getInputFiles().size());
        } catch (IllegalArgumentException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Invalid argument - Exception")
    public void parserTest_InvalidArgument_Exception() {
        String[] args = {"-m", "-s", "output.txt", "input1.txt", "input2.txt"};
        try {
            Parser parser = new Parser(args);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid argument: -m.", e.getMessage());
        }
    }

    @Test
    @DisplayName("One sorting mode - Exception")
    public void parserTest_OneSortMode_Exception() {
        String[] args = {"-a", "-d", "output.txt", "input1.txt", "input2.txt"};
        try {
            Parser parser = new Parser(args);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Sorting mode argument should be just one.", e.getMessage());
        }
    }

    @Test
    @DisplayName("One data type - Exception")
    public void parserTest_OneDataType_Exception() {
        String[] args = {"-i", "-s", "output.txt", "input1.txt", "input2.txt"};
        try {
            Parser parser = new Parser(args);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Data type argument should be just one.", e.getMessage());
        }
    }

    @Test
    @DisplayName("Missed data type - Exception")
    public void parserTest_MissedDataType_Exception() {
        String[] args = {"-a", "output.txt", "input1.txt", "input2.txt"};
        try {
            Parser parser = new Parser(args);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Missed data type argument.", e.getMessage());
        }
    }

    @Test
    @DisplayName("Missed output file - Exception")
    public void parserTest_MissedOutputFile_Exception() {
        String[] args = {"-a", "-s"};
        try {
            Parser parser = new Parser(args);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Missed output file argument.", e.getMessage());
        }
    }

    @Test
    @DisplayName("Missed input file - Exception")
    public void parserTest_MissedInputFile_Exception() {
        String[] args = {"-a", "-s", "output.txt"};
        try {
            Parser parser = new Parser(args);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Missed input file argument.", e.getMessage());
        }
    }

    @Test
    @DisplayName("Same input and output file - Exception")
    public void parserTest_SameInputOutputFile_Exception() {
        String[] args = {"-a", "-s", "output.txt", "output.txt"};
        try {
            Parser parser = new Parser(args);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Input and output file should be different.", e.getMessage());
        }
    }

    @Test
    @DisplayName("Same input files - Exception")
    public void parserTest_SameInputFiles_Exception() {
        String[] args = {"-s", "output.txt", "input.txt", "input.txt"};
        Parser parser = new Parser(args);
        assertEquals(1, parser.getInputFiles().size());
        assertEquals("input.txt", parser.getInputFiles().get(0));
    }
}
