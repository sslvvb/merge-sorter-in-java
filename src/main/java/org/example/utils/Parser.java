package org.example.utils;

import org.example.enums.SortMode;
import org.example.enums.DataType;

import java.util.ArrayList;
import java.util.HashSet; // обеспечивает их уникальность и ускоряет поиск
import java.util.List;
import java.util.Set;

public class Parser {

    private SortMode sortMode = SortMode.ASCENDING;
    private DataType dataType = null;
    private String outputFile = null;
    private final Set<String> inputFiles = new HashSet<>(); // hashset

    public Parser(String[] args) {
        parseArguments(args);
        validateArguments();
    }

    private void parseArguments(String[] args) {
        boolean sortModeFlag = false;
        boolean dataTypeFlag = false;

        for (String arg : args) {
            if (arg.startsWith("-")) {
                if (arg.equals("-a")) {
                    handleSortModeArgument(SortMode.ASCENDING, sortModeFlag);
                    sortModeFlag = true;
                } else if (arg.equals("-d")) {
                    handleSortModeArgument(SortMode.DESCENDING, sortModeFlag);
                    sortModeFlag = true;
                } else if (arg.equals("-i") || arg.equals("-s")) {
                    handleDataTypeArgument(arg, dataTypeFlag);
                    dataTypeFlag = true; // переворачивать флаги внутри функций ?
                } else {
                    throw new IllegalArgumentException("Invalid argument: " + arg + ".");
                }
            } else {
                processInputOrOutputFile(arg);
            }
        }
    }

    private void handleSortModeArgument(SortMode mode, boolean flag) {
        if (flag) {
            throw new IllegalArgumentException("Sorting mode argument should be just one.");
        }
        this.sortMode = mode;
    }

    private void handleDataTypeArgument(String arg, boolean flag) {
        if (flag) {
            throw new IllegalArgumentException("Data type argument should be just one.");
        }
        this.dataType = (arg.equals("-i")) ? DataType.INTEGER : DataType.STRING;
    }

    private void processInputOrOutputFile(String arg) {
        if (outputFile == null) {
            outputFile = arg;
        } else {
            if (arg.equals(outputFile)) {
                throw new IllegalArgumentException("Input and output file should be different.");
            }
            if (!inputFiles.contains(arg)) {
                inputFiles.add(arg);
            } else {
                System.out.println("Input file <" + arg + "> already exists. The argument will be skipped.");
            }
        }
    }

    private void validateArguments() {
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
        return new ArrayList<>(inputFiles);
    }
}