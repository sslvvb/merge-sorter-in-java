package org.example.sorting;

import org.example.utils.Parser;
import org.example.enums.SortMode;
import org.example.enums.DataType;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSorterTest {

    String outFilePath;

    @BeforeEach
    public void setUp() {
        outFilePath = getResourceFilePath("/output.txt");
        outFilePath = getResourceFilePath("/output.txt");
    }

    @Test
    @DisplayName("Test sorting with integer data")
    public void testStartSortWithIntegerData() throws IOException {
        String in1Path = getResourceFilePath("/int/input1.txt");
        String in2Path = getResourceFilePath("/int/input2.txt");

        Parser mockParser = prepareMockParser(SortMode.ASCENDING, DataType.INTEGER, outFilePath, in1Path, in2Path);

        MergeSorter mergeSorter = new MergeSorter(mockParser);
        mergeSorter.startSort();

        assertOutputMatchesResult(outFilePath, getResourceFilePath("/result/result1.txt"));
    }

    @Test
    @DisplayName("Test sorting with string data")
    public void testStartSortWithStringData() throws IOException {
        String in1Path = getResourceFilePath("/string/input1.txt");
        String in2Path = getResourceFilePath("/string/input2.txt");

        Parser mockParser = prepareMockParser(SortMode.ASCENDING, DataType.STRING, outFilePath, in1Path, in2Path);

        MergeSorter mergeSorter = new MergeSorter(mockParser);
        mergeSorter.startSort();

        assertOutputMatchesResult(outFilePath, getResourceFilePath("/result/result2.txt"));
    }

    @Test
    @DisplayName("Test sorting with empty input files")
    public void testStartSortWithEmptyInputFiles() throws IOException {
        String emptyFilePath = getResourceFilePath("/int/empty.txt");

        Parser mockParser = prepareMockParser(SortMode.ASCENDING, DataType.INTEGER, outFilePath, emptyFilePath);

        MergeSorter mergeSorter = new MergeSorter(mockParser);
        mergeSorter.startSort();

        try (BufferedReader reader = new BufferedReader(new FileReader(outFilePath))) {
            assertNull(reader.readLine(), "Output should be empty.");
        }
    }

    private Parser prepareMockParser(SortMode sortMode, DataType dataType, String outputFile, String... inputFiles) {
        Parser mockParser = mock(Parser.class);
        when(mockParser.getSortMode()).thenReturn(sortMode);
        when(mockParser.getDataType()).thenReturn(dataType);
        when(mockParser.getOutputFile()).thenReturn(outputFile);
        ArrayList<String> mockedList = new ArrayList<>(List.of(inputFiles));
        when(mockParser.getInputFiles()).thenReturn(mockedList);
        return mockParser;
    }

    private void assertOutputMatchesResult(String outputFilePath, String expectedResultPath) throws IOException {
        try (BufferedReader readerOutput = new BufferedReader(new FileReader(outputFilePath));
             BufferedReader readerResult = new BufferedReader(new FileReader(expectedResultPath))) {
            String outputLine;
            String resultLine;
            while ((resultLine = readerResult.readLine()) != null) {
                outputLine = readerOutput.readLine();
                assertEquals(resultLine, outputLine, "Output does not match expected result.");
            }
        }
    }

    private String getResourceFilePath(String resourcePath) {
        return new File(this.getClass().getResource(resourcePath).getFile()).getAbsolutePath();
    }
}
