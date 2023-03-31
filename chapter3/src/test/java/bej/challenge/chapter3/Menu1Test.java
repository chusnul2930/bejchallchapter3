package bej.challenge.chapter3;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Menu1Test {
    private final String csvFileName = "C://temp/direktori/data_sekolah.csv";
    private final String txtFileName = "C://temp/direktori/output_mode.txt";

    @Test
    void testReadCsv() throws IOException {
        Menu1 csvProcessor = new Menu1(csvFileName, txtFileName);
        csvProcessor.readCsv();
        List<List<String>> data = csvProcessor.readCsv();
        assertNotNull(data);
        assertEquals(10, data.size());
        assertEquals(Arrays.asList("10", "90", "80", "70", "90"), data.get(0));
        assertEquals(Arrays.asList("20", "70", "90", "80", "60"), data.get(1));
    }

    @Test
    void testCalculateFrequency() throws IOException {
        Menu1 csvProcessor = new Menu1(csvFileName, txtFileName);
        csvProcessor.readCsv();
        Map<String, Integer> frequencyMap = csvProcessor.calculateFrequency();
        assertNotNull(frequencyMap);
        assertEquals(10, frequencyMap.size());
        assertEquals(3, frequencyMap.get("90      "));
        assertEquals(2, frequencyMap.get("70      "));
        assertEquals(1, frequencyMap.get("60      "));
    }

    @Test
    void testSortDataByFrequency() throws IOException {
        Menu1 csvProcessor = new Menu1(csvFileName, txtFileName);
        csvProcessor.readCsv();
        csvProcessor.sortDataByFrequency();
        List<List<String>> sortedData = csvProcessor.readCsv();
        assertNotNull(sortedData);
        assertEquals(10, sortedData.size());
        assertEquals(Arrays.asList("10", "90", "80", "70", "90"), sortedData.get(0));
        assertEquals(Arrays.asList("30", "80", "90", "70", "60"), sortedData.get(1));
        assertEquals(Arrays.asList("40", "70", "90", "80", "60"), sortedData.get(2));
    }

    @Test
    void testCalculateMode() throws IOException {
        Menu1 csvProcessor = new Menu1(csvFileName, txtFileName);
        csvProcessor.readCsv();
        String mode = csvProcessor.calculateMode();
        assertNotNull(mode);
        assertEquals("90", mode);
    }

    @Test
    void testWriteModeToFile() throws IOException {
        Menu1 csvProcessor = new Menu1(csvFileName, txtFileName);
        csvProcessor.readCsv();
        csvProcessor.calculateFrequency();
        csvProcessor.writeModeToFile();
    }

}