package org.example.sorting;

import org.example.utils.Parser;
import org.example.enums.SortMode;
import org.example.enums.DataType;
import org.example.strategies.IntReader;
import org.example.strategies.StringReader;
import org.example.strategies.ReaderStrategy;

import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeSorter {

    private final SortMode sortMode;
    private final DataType dataType;
    private final String outputFile;
    private final ArrayList<String> inputFiles;

    public MergeSorter(Parser parser) {
        this.sortMode = parser.getSortMode();
        this.dataType = parser.getDataType();
        this.outputFile = parser.getOutputFile();
        this.inputFiles = parser.getInputFiles();
    }

    public void startSort() throws IOException {
        if (Files.exists(Paths.get(outputFile))) {
            throw new IOException("Output file already exists. Specify the name of a file that does not exist.");
        }

        ArrayList<ReaderStrategy> readersList = createReaderList();

        FileWriter writeFile = new FileWriter(outputFile);
        while (!readersList.isEmpty()) {
            int minValueIndex = findMinValueIndex(readersList);
            ReaderStrategy minValueReader = readersList.get(minValueIndex);
            writeFile.write(minValueReader.getValue() + "\n");
            if (minValueReader.shiftValue() != 0) {
                readersList.remove(minValueIndex);
            }
        }
        writeFile.close();
    }

    private int findMinValueIndex(ArrayList<ReaderStrategy> readersList) {
        int minValueIndex = 0;
        for (int i = 1; i < readersList.size(); ++i) {
            if (readersList.get(minValueIndex).compareValues(readersList.get(i))) {
                minValueIndex = i;
            }
        }
        return minValueIndex;
    }

    private ArrayList<ReaderStrategy> createReaderList() {
        ArrayList<ReaderStrategy> readersList = new ArrayList<>();
        for (String fileName : this.inputFiles) {
            try {
                if (this.dataType == DataType.INTEGER) {
                    readersList.add(new IntReader(fileName, this.sortMode));
                } else {
                    readersList.add(new StringReader(fileName, this.sortMode));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return readersList;
    }
}