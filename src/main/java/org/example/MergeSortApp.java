package org.example;

import org.example.sorting.MergeSorter;
import org.example.utils.Parser;

import java.io.IOException;

public class MergeSortApp {
    public static void main(String[] args) {
        try {
            MergeSorter sorter = new MergeSorter(new Parser(args));
            sorter.startSort();
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Arguments are expected: [<sort_mode>] <data_type> <output_file> <input_file> [<input_file>]");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
//        } catch (FileNotFoundException e) {
//            System.err.println("Error: The specified output file does not exist or cannot be created.");
//        } catch (Exception e) {
//            System.err.println("An unexpected error occurred: " + e.getMessage());
//        }
    }
}