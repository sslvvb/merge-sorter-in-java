package org.example.strategies;

import org.example.enums.SortMode;
import org.example.utils.ErrorsPrinter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractValueReader implements ReaderStrategy {

    protected final ErrorsPrinter printer = new ErrorsPrinter();
    protected final String fileName;
    protected final boolean sortMode;
    protected final BufferedReader reader;
    protected int lineNumber = 1;
    protected String value;

    public AbstractValueReader(String file, SortMode sort) throws IOException {
        this.fileName = file;
        this.sortMode = sort == SortMode.ASCENDING;
        this.reader = new BufferedReader(new FileReader(this.fileName));
        init();
    }

    @Override
    public boolean compareValues(ReaderStrategy other) {
        return valueCompare(this.value, other.getValue());
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public int shiftValue() {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!isValid(line)) {
                    continue;
                }
                if (!valueCompare(value, line)) {
                    value = line;
                    ++lineNumber;
                    return 0; // Successfully shifted to the next value
                } else {
                    printer.sortingError(fileName, lineNumber, line);
                    ++lineNumber;
                }
            }
            return 1; // End of file
        } catch (IOException e) {
            return -1;
        }
    }

    protected abstract boolean valueCompare(String first, String second);

    protected abstract boolean isValid(String line);

    private void init() throws IOException {
        String line = reader.readLine();
        if (line == null) {
            throw new IOException(fileName + " is empty.");
        }
        while (line != null) {
            if (isValid(line)) {
                value = line;
                ++lineNumber;
                return; // Successfully init first value
            }
            line = reader.readLine();
        }
        throw new IOException(fileName + " contains only invalid data.");
    }
}
