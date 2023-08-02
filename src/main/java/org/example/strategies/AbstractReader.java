//package org.example.strategies;
//
//import org.example.enums.SortMode;
//import org.example.utils.ErrorsPrinter;
//
//import java.io.BufferedReader; //
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException; //
//import java.util.Scanner;
//import java.lang.Exception; //
//
///**
// * Абстрактный класс расширяет классы стратегий. Содержит общую функциональность.
// */
//public abstract class AbstractReader implements ReaderStrategy {
//
//    protected final ErrorsPrinter printer = new ErrorsPrinter();
//    protected final String fileName;
//    protected final boolean sortMode;
//    protected final BufferedReader reader; // ? new
//    protected int stringNumber = 1;
//    protected String value; // or int
//
//    public AbstractReader(String file, SortMode sort) throws FileNotFoundException, IOException, Exception {
//        this.fileName = file;
//        this.sortMode = sort == SortMode.ASCENDING;
//        this.reader = new BufferedReader(new FileReader(this.fileName));
//        init();
//    }
//
//    @Override
//    public boolean compareValues(ReaderStrategy other) {
//        return valueCompare(this.value, other.getValue());
//    }
//
//    @Override
//    public String getValue() {
//        return value;
//    }
//
//
//    @Override
//    public int shiftValue() {
//        try {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                if (!isValid(line)) {
//                    continue;
//                }
//
//                if (!valueCompare(this.value, line)) {
//                    this.value = line;
//                    ++stringNumber;
//                    return 0; // Successfully shifted to the next value
//                } else {
//                    printer.sortingError(fileName, stringNumber, line);
//                    ++stringNumber;
//                }
//            }
//            return 1; // End of file
//        } catch (IOException e) {
//            // Handle IOException appropriately
//            return -1;
//        }
//    }
//
//    protected abstract boolean valueCompare(String first, String second);
//    protected abstract boolean isValid(String line);
//    protected abstract void init() throws Exception;
//
//    protected void closeReader() {
//        try {
//            if (reader != null) {
//                reader.close();
//            }
//        } catch (IOException e) {
//            System.err.println("Error closing file: " + fileName);
//        }
//    }
//}
