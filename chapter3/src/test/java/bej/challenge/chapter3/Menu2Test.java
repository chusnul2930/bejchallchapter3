package bej.challenge.chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu2Test {
    private static final String CSV_FILE_NAME = "src/test/resources/test_data.csv";
    private static final String TXT_FILE_NAME = "src/test/resources/test_result.txt";

    private Menu2 menu2;

    @BeforeEach
    public void setUp() {
        menu2 = new Menu2(CSV_FILE_NAME, TXT_FILE_NAME);
    }

    @Test
    public void testReadCsv() throws IOException {
        menu2.readCsv();

        List<List<String>> expectedData = new ArrayList<>();
        expectedData.add(Arrays.asList("1", "2", "3"));
        expectedData.add(Arrays.asList("4", "5", "6"));

        Assertions.assertEquals(expectedData, menu2.getData());
    }

    @Test
    public void testCalculateMode() {
        List<List<String>> testData = new ArrayList<>();
        testData.add(Arrays.asList("1", "2", "2"));
        testData.add(Arrays.asList("3", "4", "5"));

        menu2.setData(testData);

        Assertions.assertEquals("2", menu2.calculateMode());
    }

    @Test
    public void testCalculateAverage() {
        List<List<String>> testData = new ArrayList<>();
        testData.add(Arrays.asList("1", "2", "3"));
        testData.add(Arrays.asList("4", "5", "6"));

        menu2.setData(testData);

        Assertions.assertEquals(3.5, menu2.calculateAverage(), 0.001);
    }

    @Test
    public void testCalculateMedian() {
        List<List<String>> testData = new ArrayList<>();
        testData.add(Arrays.asList("1", "2", "3"));
        testData.add(Arrays.asList("4", "5", "6"));

        menu2.setData(testData);

        Assertions.assertEquals(3.5, menu2.calculateMedian(), 0.001);
    }

    @Test
    public void testWriteResultToFile() throws IOException {
        List<List<String>> testData = new ArrayList<>();
        testData.add(Arrays.asList("1", "2", "2"));
        testData.add(Arrays.asList("3", "4", "5"));

        menu2.setData(testData);
        menu2.writeResultToFile();

        // You can add assertions to check the content of the generated file
        // using BufferedReader or any other relevant method.
    }

    @Test
    public void testCall() throws IOException {
        boolean result = menu2.call();

        Assertions.assertTrue(result);

        // You can add assertions to check the content of the generated file
        // using BufferedReader or any other relevant method.
    }

}