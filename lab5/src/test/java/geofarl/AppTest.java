package geofarl;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class AppTest {

    private App app;

    @Before
    public void setUp() {
        app = new App();
    }

    @Test
    public void testFindLineWithMaxWords_MultipleLines() {
        String simulatedFileContent = "This is a short line.\n" +
                "This is a line with more words than the previous one.\n" +
                "Short again.";
        BufferedReader reader = new BufferedReader(new StringReader(simulatedFileContent));

        String result = app.findLineWithMaxWords(reader);

        assertEquals("This is a line with more words than the previous one.", result);
    }

    @Test
    public void testFindLineWithMaxWords_SingleLine() {
        String simulatedFileContent = "Only one line with some words.";
        BufferedReader reader = new BufferedReader(new StringReader(simulatedFileContent));

        String result = app.findLineWithMaxWords(reader);

        assertEquals("Only one line with some words.", result);
    }

    @Test
    public void testFindLineWithMaxWords_EmptyFile() {
        String simulatedFileContent = "";
        BufferedReader reader = new BufferedReader(new StringReader(simulatedFileContent));

        String result = app.findLineWithMaxWords(reader);

        assertEquals("", result);
    }

    @Test
    public void testFindLineWithMaxWords_EqualWordCount() {
        String simulatedFileContent = "Line one here.\n" +
                "Line two here.";
        BufferedReader reader = new BufferedReader(new StringReader(simulatedFileContent));

        String result = app.findLineWithMaxWords(reader);

        assertEquals("Line one here.", result);
    }
}
