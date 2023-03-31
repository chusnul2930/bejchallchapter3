package bej.challenge.chapter3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainTest {
    private Scanner scanner;
    private String pathCsv;
    private String pathMenu1;
    private String pathMenu2;
    private File csvFile;
    private File menu1File;
    private File menu2File;

    @Before
    public void setUp() throws Exception {
        scanner = mock(Scanner.class);
        pathCsv = "src/test/resources/data_sekolah.csv";
        pathMenu1 = "src/test/resources/output_mode.txt";
        pathMenu2 = "src/test/resources/Average_Median.txt";
        csvFile = new File(pathCsv);
        menu1File = new File(pathMenu1);
        menu2File = new File(pathMenu2);
    }

    @After
    public void tearDown() throws Exception {
        csvFile.delete();
        menu1File.delete();
        menu2File.delete();
    }

    @Test
    public void testMenu1() throws IOException {
        when(scanner.nextInt()).thenReturn(1, 0);
        Main.main(new String[] {});
        assertTrue(menu1File.exists());
        assertFalse(menu2File.exists());
    }

    @Test
    public void testMenu2() throws IOException {
        when(scanner.nextInt()).thenReturn(2, 0);
        Main.main(new String[] {});
        assertFalse(menu1File.exists());
        assertTrue(menu2File.exists());
    }

    @Test
    public void testMenu3() throws IOException {
        when(scanner.nextInt()).thenReturn(3, 0);
        Main.main(new String[] {});
        assertTrue(menu1File.exists());
        assertTrue(menu2File.exists());
    }

    @Test
    public void testMenu0() throws IOException {
        when(scanner.nextInt()).thenReturn(0);
        Main.main(new String[] {});
    }

    @Test
    public void testInvalidInput() throws IOException {
        when(scanner.nextInt()).thenReturn(4, 1, 0);
        Main.main(new String[] {});
    }

    @Test
    public void testFileNotFound() throws IOException {
        when(scanner.nextInt()).thenReturn(1, 0);
        Main.main(new String[] {});
        assertFalse(menu1File.exists());
        assertFalse(menu2File.exists());
    }

}