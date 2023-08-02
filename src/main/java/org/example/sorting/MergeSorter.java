package org.example.sorting;

import org.example.utils.Parser;
import org.example.enums.SortMode;
import org.example.enums.DataType;
import org.example.strategies.IntReader;
import org.example.strategies.StringReader;
import org.example.strategies.ReaderStrategy;

//import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException; //
import java.io.FileWriter;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeSorter {

    private SortMode sortMode;
    private DataType dataType;
    private String outputFile;
    private ArrayList<String> inputFiles;

    public MergeSorter(Parser parser) {
        this.sortMode = parser.getSortMode();
        this.dataType = parser.getDataType();
        this.outputFile = parser.getOutputFile();
        this.inputFiles = parser.getInputFiles();
    }

    public void startSort() throws IOException { // FileWriter exception
//        if (Files.exists(Paths.get(outputFile))) {
//            System.out.println("Output file already exists. Specify the name of a file that does not exist.");
//            return; // change on exception ?
//        }
        ArrayList<ReaderStrategy> readersList = createReaderList();
        FileWriter writeFile = new FileWriter(outputFile);
        while (readersList.size() > 0) {
            int minValueIndex = 0;
            for (int i = 1; i < readersList.size(); ++i) {
                if (readersList.get(minValueIndex).compareValues(readersList.get(i))) {
                    minValueIndex = i;
                }
            }
            writeFile.write(readersList.get(minValueIndex).getValue() + "\n");
            if (readersList.get(minValueIndex).shiftValue() == 1) {
                readersList.remove(minValueIndex);
            }
        }
        writeFile.close();
    }

    private ArrayList<ReaderStrategy> createReaderList() {
        ArrayList<ReaderStrategy> readersList = new ArrayList<ReaderStrategy>();
        for (String fileName : this.inputFiles) {
            try {
                if (this.dataType == DataType.INTEGER) {
                    readersList.add(new IntReader(fileName, this.sortMode));
                } else {
                    readersList.add(new StringReader(fileName, this.sortMode));
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage()); // in12.txt (No such file or directory)
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return readersList;
    }

}