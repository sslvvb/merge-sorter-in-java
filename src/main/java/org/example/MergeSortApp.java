package org.example;

import org.example.sorting.MergeSorter;
import org.example.utils.Parser;

import java.io.IOException;

public class MergeSortApp {
    public static void main(String[] args) throws IOException {
        try {
            MergeSorter sorter = new MergeSorter(new Parser(args));
            sorter.startSort();
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Arguments are expected: [<sort_mode>] <data_type> <output_file> <input_file> [<input_file>]");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }
}