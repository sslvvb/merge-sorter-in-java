package org.example.utils;

public class ErrorsPrinter {

    public void invalidData(String fileName, int stringNumber, String data) {
        System.out.println(fileName + " [" + stringNumber + "] - Invalid data: " + data);
    }

    public void sortingError(String fileName, int stringNumber, String data) {
        System.out.println(fileName + " [" + stringNumber + "] - Sorting error, data will be skipped: " + data);
    }
}