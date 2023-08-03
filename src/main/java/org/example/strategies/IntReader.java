package org.example.strategies;

import org.example.enums.SortMode;

import java.io.IOException;

public class IntReader extends AbstractValueReader {

    public IntReader(String file, SortMode sort) throws IOException {
        super(file, sort);
    }

    @Override
    protected boolean valueCompare(String first, String second) {
        int firstValue = Integer.parseInt(first);
        int secondValue = Integer.parseInt(second);
        return (sortMode) ? firstValue > secondValue : firstValue < secondValue;
    }

    @Override
    protected boolean isValid(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e) {
            printer.invalidData(fileName, lineNumber, line);
            ++lineNumber;
            return false;
        }
    }
}
