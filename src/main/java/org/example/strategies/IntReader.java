//package org.example.strategies;
//
//import org.example.enums.SortMode;
//
//import java.io.IOException;
//
//public class IntReader extends AbstractReader {
//
//    private int value;
//
//    public IntReader(String file, SortMode sort) throws IOException, Exception { // FileNotFoundException, IOException
//        super(file, sort);
//    }
//
//    @Override
//    protected void init() throws Exception {
//        String line = reader.readLine();
//        if (line == null) {
//            throw new Exception(fileName + " is empty");
//        }
//        try {
//            value = Integer.parseInt(line);
//            ++stringNumber;
//        } catch (NumberFormatException e) {
//            printer.invalidData(fileName, stringNumber, line);
//            throw new Exception(fileName + " contains only invalid data.");
//        }
//    }
//
//
//    @Override
//    protected boolean valueCompare(String first, String second) {
//        int firstValue = Integer.parseInt(first);
//        int secondValue = Integer.parseInt(second);
//        return (sortMode) ? firstValue > secondValue : firstValue < secondValue;
//    }
//
//    @Override
//    protected boolean isValid(String line) {
//        try {
//            Integer.parseInt(line);
//            return true;
//        } catch (NumberFormatException e) {
//            printer.invalidData(fileName, stringNumber, line);
//            ++stringNumber;
//            return false;
//        }
//    }
//
//}

package org.example.strategies;

import org.example.enums.SortMode;
import org.example.utils.ErrorsPrinter;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class IntReader implements ReaderStrategy {

    private final ErrorsPrinter printer = new ErrorsPrinter();
    private final String fileName;
    private final boolean sortMode;
    private final Scanner src; // ? new
    private int stringNumber = 1;
    private int value; // or int

    public IntReader(String file, SortMode sort) throws IOException, Exception { // FileNotFoundException, IOException
        this.fileName = file;
        this.sortMode = sort == SortMode.ASCENDING;
        this.src = new Scanner(new FileReader(this.fileName));
        init();
    }

    private void init() throws Exception {
        if (!src.hasNext()) {
            throw new Exception(fileName + " is empty");
        }
        while (src.hasNextLine()) {
            String line = src.nextLine();
            try {
                int tmp = Integer.parseInt(line);
                this.value = tmp;
                ++this.stringNumber;
                return; // Successfully init first integer
            } catch (NumberFormatException e) {
                printer.invalidData(this.fileName, this.stringNumber, line);
                ++this.stringNumber;
            }
        }
        throw new Exception(fileName + " contains only invalid data.");
    }

//    public IntReader(String file, SortMode sort) throws FileNotFoundException, Exception {
//        this.fileName = file;
//        this.sortMode = sort == SortMode.ASCENDING;
//        this.src = new Scanner(new FileReader(this.fileName));
//        init();
//    }

    @Override
    public boolean compareValues(ReaderStrategy other) {
        return intCompare(this.value, Integer.parseInt(other.getValue()));
    }

    @Override
    public String getValue() {
        return Integer.toString(this.value);
    }

    @Override
    public int shiftValue() {
        if (!src.hasNext()) {
            return 1; // End of file
        }
        while (src.hasNextLine()) {
            String line = src.nextLine();
            try {
                int tmp = Integer.parseInt(line);
                if (!intCompare(this.value, tmp)) {
                    this.value = tmp;
                    ++this.stringNumber;
                    return 0; // Successfully shifted to the next value
                } else {
                    printer.sortingError(this.fileName, this.stringNumber, Integer.toString(tmp));
                    ++this.stringNumber;
                }
            } catch (NumberFormatException e) {
                printer.invalidData(this.fileName, stringNumber, line);
                ++this.stringNumber;
            }
        }
        return 1; // End of file
    }

    private boolean intCompare(int first, int second) {
        return (this.sortMode) ? first > second : first < second;
        // Integer.compare(first, second) > 0
    }

}