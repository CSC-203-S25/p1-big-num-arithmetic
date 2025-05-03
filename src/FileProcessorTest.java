import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FileProcessorTest {

    // Test valid inputs
    @Test
    void processFile() {
        String input = "SampleInput.txt";
        FileProcessor.processFile(input);
    }
    @Test
    void processFileBad() {
        String input = "me.txt";
        FileProcessor.processFile(input);
    }
}