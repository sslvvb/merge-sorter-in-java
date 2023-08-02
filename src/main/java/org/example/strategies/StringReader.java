package org.example.strategies;

import org.example.enums.SortMode;

import java.io.IOException;

public class StringReader extends AbstractReader {

    private String value;

    public StringReader(String file, SortMode sort) throws IOException, Exception {
        super(file, sort);
    }

    @Override
    protected boolean valueCompare(String first, String second) {
        return (sortMode) ? first.compareTo(second) > 0 : first.compareTo(second) < 0;
    }

    @Override
    protected boolean isValid(String line) {
        if (line.contains(" ")) {
            printer.invalidData(fileName, stringNumber, line);
            ++stringNumber;
            return false;
        }
        return true;
    }

    @Override
    protected void init() throws Exception {
        String line = reader.readLine();
        if (line == null) {
            throw new Exception(fileName + " is empty");
        }

        if (line.contains(" ")) {
            printer.invalidData(fileName, stringNumber, line);
            throw new Exception(fileName + " contains only invalid data.");
        }

        value = line;
        ++stringNumber;
    }
}


//package org.example.strategies;
//
//import org.example.enums.SortMode;
//import org.example.utils.ErrorsPrinter;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.Scanner;
//
//public class StringReader implements ReaderStrategy {
//
//    private final ErrorsPrinter printer = new ErrorsPrinter();
//    private final String fileName;
//    private final boolean sortMode;
//    private final Scanner src;
//    private String value;
//    private int stringNumber = 1;
//
//    public StringReader(String file, SortMode sort) throws FileNotFoundException, Exception {
//        this.fileName = file;
//        this.sortMode = sort == SortMode.ASCENDING;
//        this.src = new Scanner(new FileReader(this.fileName));
//        init();
//    }
//
//    @Override
//    public boolean compareValues(ReaderStrategy other) {
//        return stringCompare(this.value, other.getValue());
//    }
//
//    @Override
//    public String getValue() {
//        return this.value;
//    }
//
//    @Override
//    public int shiftValue() {
//        if (!src.hasNext()) {
//            return 1; // End of file
//        }
//        while (src.hasNextLine()) {
//            String line = src.nextLine();
//            if (line.contains(" ")) { // || result.length() == 0
//                printer.invalidData(this.fileName, this.stringNumber, line);
//                ++this.stringNumber;
//            } else {
//                if (!stringCompare(this.value, line)) { // test my functional
//                    this.value = line;
//                    ++this.stringNumber;
//                    return 0; // Successfully shifted to the next value
//                } else {
//                    printer.sortingError(this.fileName, this.stringNumber, line);
//                    ++this.stringNumber;
//                }
//            }
//        }
//        return 1; // End of file
//    }
//
//    private void init() throws Exception {
//        if (!src.hasNext()) {
//            throw new Exception(fileName + " is empty");
//        }
//        while (src.hasNextLine()) {
//            String line = src.nextLine();
//            if (line.contains(" ")) { // || result.length() == 0
//                printer.invalidData(this.fileName, this.stringNumber, line);
//                ++this.stringNumber;
//            } else {
//                this.value = line;
//                ++this.stringNumber;
//                return; // Successfully init first integer
//            }
//        }
//        throw new Exception(fileName + " contains only invalid data.");
//    }
//
//    private boolean stringCompare(String first, String second) {
//        return (this.sortMode) ? first.compareTo(second) > 0 : first.compareTo(second) < 0;
//    }
//
//}