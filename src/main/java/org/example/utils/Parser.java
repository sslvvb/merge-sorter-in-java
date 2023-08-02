package org.example.utils;

import org.example.enums.SortMode;
import org.example.enums.DataType;
import java.util.ArrayList;

// класс отвечает за обработку аргументов командной строки

public class Parser {

    private SortMode sortMode = SortMode.ASCENDING;
    private DataType dataType = null;
    private String outputFile = null;
    private ArrayList<String> inputFiles = new ArrayList<String>();

    public Parser(String[] args) throws IllegalArgumentException {
        boolean sortModeFlag = false;
        boolean dataTypeFlag = false;
        for (String arg : args) {
            if (arg.charAt(0) == '-') {
                if (arg.equals("-a") || arg.equals("-d")) { // CollectFlag
                    if (sortModeFlag) {
                        throw new IllegalArgumentException("Sorting mode argument should be just one.");
                    }
                    sortModeFlag = true;
                    if (arg.equals("-d")) {
                        this.sortMode = SortMode.DESCENDING;
                    }
                } else if (arg.equals("-i") || arg.equals("-s")) {
                    if (dataTypeFlag) {
                        throw new IllegalArgumentException("Data type argument should be just one.");
                    }
                    dataTypeFlag = true;
                    if (arg.equals("-i")) {
                        this.dataType = DataType.INTEGER;
                    } else {
                        this.dataType = DataType.STRING;
                    }
                } else {
                    throw new IllegalArgumentException("Invalid argument: " + arg + ".");
                }
            } else {
                if (outputFile == null) {
                    this.outputFile = arg;
                } else {
                    if (arg == outputFile) {
                        throw new IllegalArgumentException("Input and output file should be different.");
                    }
                    if (inputFiles.contains(arg)) {
                        System.out.println("Input file <" + arg + "> already exists. The argument will be skipped.");
                    } else {
                        this.inputFiles.add(arg);
                    }
                }
            }
        }

        if (dataType == null) {
            throw new IllegalArgumentException("Missed data type argument.");
        } else if (outputFile == null) {
            throw new IllegalArgumentException("Missed output file argument.");
        } else if (inputFiles.isEmpty()) {
            throw new IllegalArgumentException("Missed input file argument.");
        }
    }

    public SortMode getSortMode() {
        return sortMode;
    }

    public DataType getDataType() {
        return dataType;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public ArrayList<String> getInputFiles() {
        return inputFiles;
    }
}