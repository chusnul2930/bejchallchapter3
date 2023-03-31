package bej.challenge.chapter3;

import java.io.*;
import java.util.*;

public class Menu1 {
    // field with final and private modifier, part of implementing Encapsulation.
    private final List<List<String>> data;
    private final String csvFileName;
    private final String txtFileName;

    /**
     * Constructor
     * @param csvFileName to collect the csv file
     * @param txtFileName to collect the txt file
     */
    public Menu1(String csvFileName, String txtFileName) {
        this.csvFileName = csvFileName;
        this.txtFileName = txtFileName;
        this.data = new ArrayList<>();
    }

    /**
     * Method to read csv
     *
     * @return
     * @throws IOException for error handling
     */
    public List<List<String>> readCsv() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFileName));
        String line = reader.readLine();
        while (line != null) {
            String[] values = line.split(",");
            List<String> row = new ArrayList<>(Arrays.asList(values));
            data.add(row);
            line = reader.readLine();
        }
        reader.close();
        return null;
    }

    public Map<String, Integer> calculateFrequency() {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (List<String> row : data) {
            for (String value : row) {
                if (frequencyMap.containsKey(value)) {
                    frequencyMap.put(value + "  ", frequencyMap.get("   " + value + "\n") + 1);
                } else {
                    frequencyMap.put(value + "      ", 1);
                }
            }
        }
        return frequencyMap;
    }


    /**
     * Method to sort csv by frequency
     */
    public void sortDataByFrequency() {
        Map<String, Integer> freqMap = new HashMap<>();
        for (List<String> row : data) {
            for (String value : row) {
                if (freqMap.containsKey(value)) {
                    freqMap.put(value, freqMap.get(value) + 1);
                } else {
                    freqMap.put(value, 1);
                }
            }
        }

        /**
         * Implement method compare from interface Comparator
         *
         */
        Collections.sort(data, new Comparator<List<String>>() {
            public int compare(List<String> list1, List<String> list2) {
                int freq1 = 0;
                int freq2 = 0;
                for (String value : list1) {
                    freq1 += freqMap.get(value);
                }
                for (String value : list2) {
                    freq2 += freqMap.get(value);
                }
                return Integer.compare(freq2, freq1);
            }
        });
    }

    /**
     * Method to calculate mode
     * @return mode
     */
    public String calculateMode() {
        Map<String, Integer> freqMap = new HashMap<>();
        for (List<String> row : data) {
            for (String value : row) {
                if (freqMap.containsKey(value)) {
                    freqMap.put(value, freqMap.get(value) + 1);
                } else {
                    freqMap.put(value, 1);
                }
            }
        }
        String mode = null;
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                mode = entry.getKey();
                maxFreq = entry.getValue();
            }
        }
        return mode;
    }

    /**
     * Method to write the result to destination file
     * @throws IOException for error handling
     */
    public void writeModeToFile() throws IOException {
        String mode = calculateMode();
        String freq = String.valueOf(calculateFrequency());
        BufferedWriter writer = new BufferedWriter(new FileWriter(txtFileName));
        writer.write("Berikut hasil pengolahan nilai :");
        writer.newLine();
        writer.newLine();
        writer.write("Nilai     | Frekuensi");
        writer.newLine();
        writer.write(freq);
        writer.newLine();
        writer.newLine();
        writer.write("Modus : " + mode);
        writer.close();
    }

    /**
     * Create object from this class, call the created method and fill it's arguments/params
     *
     * @return
     * @throws IOException for error handling
     */
    public boolean call() throws IOException {
        // Alocation Path File
        String pathCsv = "C://temp/direktori/data_sekolah.csv";
        String pathMenu1 = "C://temp/direktori/output_mode.txt";

        Menu1 csvProcessor = new Menu1(pathCsv, pathMenu1);
        csvProcessor.readCsv();
        csvProcessor.calculateFrequency();
        csvProcessor.writeModeToFile();

        return true;
    }

//    public List<List<String>> getData() {
//        return getData();
//    }
}