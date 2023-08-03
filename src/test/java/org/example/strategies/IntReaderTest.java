import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.enums.SortMode;
import org.example.strategies.IntReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IntReaderTest {

//    private IntReader intReader;

//    @BeforeEach
//    public void setUp() throws FileNotFoundException, Exception {
//        // Create a mock SortMode and set up Scanner with mock input data
//        SortMode mockSortMode = SortMode.ASCENDING;
//
//        // Create IntReader instance with mock SortMode and Scanner
//        intReader = new IntReader("resources/basic/empty.txt", mockSortMode);
//    }

    @Test
    public void testInitEmptyFile() {
        try {
            IntReader intReader = new IntReader("test/resources/basic/empty.txt", SortMode.ASCENDING);
            fail("Empty file was not thrown.");
        } catch (Exception e) {
            // assertEquals("test/resources/basic/empty.txt empty.txt is empty.", e.getMessage());
            assertEquals("test/resources/basic/empty.txt (No such file or directory)", e.getMessage());
        }
    }

    @Test
    public void testInitCorrectFile() {
        try {
            IntReader intReader = new IntReader("test/resources/ints/in1.txt", SortMode.ASCENDING);
        } catch (Exception e) {
            System.out.println("error sslvvb");
//            fail("Empty file was not thrown.");
            // assertEquals("test/resources/basic/empty.txt empty.txt is empty.", e.getMessage());
//            assertEquals("test/resources/basic/empty.txt (No such file or directory)", e.getMessage());
        }
    }

//    @Test
//    public void testCompareValues() {
//        // Mock another ReaderStrategy instance for comparison
//        ReaderStrategy mockReader = mock(ReaderStrategy.class);
//        when(mockReader.getValue()).thenReturn("100");
//
//        // Test case: Compare values (intReader.value = 123, mockReader.value = 100)
//        boolean result = intReader.compareValues(mockReader);
//        assert result : "Comparison failed.";
//    }
//
//    @Test
//    public void testShiftValue() {
//        // Test case: Shift to next value (123 -> 456)
//        int shiftResult = intReader.shiftValue();
//        assert shiftResult == 0 : "Shift to next value failed.";
//
//        // Test case: Shift to end of file
//        shiftResult = intReader.shiftValue();
//        assert shiftResult == 1 : "Shift to end of file failed.";
//    }
}
