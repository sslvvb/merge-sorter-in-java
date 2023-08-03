//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
////
//import org.example.enums.DataType;
//import org.example.enums.SortMode;
//import org.example.sorting.MergeSorter;
//import org.example.strategies.IntReader;
//import org.example.strategies.ReaderStrategy;
//import org.example.utils.Parser;
////
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
////
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MergeSorterTest {
//
//    private MergeSorter mergeSorter;
//
//    @BeforeEach
//    public void setUp() {
//        // Create a mock parser and set it up with necessary values
//        Parser mockParser = mock(Parser.class);
//        when(mockParser.getSortMode()).thenReturn(SortMode.ASCENDING);
//        when(mockParser.getDataType()).thenReturn(DataType.INTEGER);
//        when(mockParser.getOutputFile()).thenReturn("output.txt");
//        when(mockParser.getInputFiles()).thenReturn(new ArrayList<>(Arrays.asList("input1.txt", "input2.txt")));
//
//
//        // Create MergeSorter instance with the mock parser
//        mergeSorter = new MergeSorter(mockParser);
//    }
//
//    @Test
//    public void testStartSort() throws IOException {
//        // Mock ReaderStrategy instances
//        IntReader intReader1 = mock(IntReader.class);
//        IntReader intReader2 = mock(IntReader.class);
//
//        // Mock FileWriter
//        FileWriter mockFileWriter = mock(FileWriter.class);
//        whenNew(FileWriter.class).withArguments("output.txt").thenReturn(mockFileWriter);
//
////        // Set up mock behavior for ReaderStrategy instances
////        when(intReader1.compareValues(Mockito.any())).thenReturn(true, false);
////        when(intReader1.getValue()).thenReturn("123");
////        when(intReader1.shiftValue()).thenReturn(0, 1); // Indicates end of file
////        when(intReader2.compareValues(Mockito.any())).thenReturn(false);
////        when(intReader2.getValue()).thenReturn("456");
////        when(intReader2.shiftValue()).thenReturn(1); // Indicates end of file
////
////        ArrayList<ReaderStrategy> readerList = new ArrayList<>(Arrays.asList(intReader1, intReader2));
////        when(mergeSorter.createReaderList()).thenReturn(readerList);
////
////        // Call the method under test
////        mergeSorter.startSort();
////
////        // Verify interactions
////        verify(mockFileWriter).write("123\n");
////        verify(mockFileWriter).write("456\n");
////        verify(mockFileWriter).close();
//    }
//
////    @Test
////    public void testStartSort() throws IOException {
////        // Mock FileWriter and other dependencies
////        FileWriter mockFileWriter = mock(FileWriter.class);
////        whenNew(FileWriter.class).withArguments("output.txt").thenReturn(mockFileWriter);
////
////        // Mock ReaderStrategy instances and set up their behavior
////
////        ArrayList<ReaderStrategy> readerList = new ArrayList<>(Arrays.asList(intReader1, intReader2));
////
////        // Since createReaderList() is private, we cannot directly mock it
////        // Instead, we can mock its behavior indirectly by using the method that calls it
////        MergeSorter spyMergeSorter = spy(mergeSorter);
////        doReturn(readerList).when(spyMergeSorter).createReaderList();
////
////        // Call the method under test
////        spyMergeSorter.startSort();
////
////        // Verify interactions
////        verify(mockFileWriter).write("123\n");
////        verify(mockFileWriter).write("456\n");
////        verify(mockFileWriter).close();
////    }
//}
//
//
//
//
//
