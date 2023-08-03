package org.example.strategies;

import org.example.enums.SortMode;

import java.io.IOException;

public class StringReader extends AbstractValueReader {

    public StringReader(String file, SortMode sort) throws IOException {
        super(file, sort);
    }

    @Override
    protected boolean valueCompare(String first, String second) {
        return (sortMode) ? first.compareTo(second) > 0 : first.compareTo(second) < 0;
    }

    @Override
    protected boolean isValid(String line) {
        if (line.contains(" ") || line.length() == 0) {
            printer.invalidData(fileName, lineNumber, line);
            ++lineNumber;
            return false;
        }
        return true;
    }

}
