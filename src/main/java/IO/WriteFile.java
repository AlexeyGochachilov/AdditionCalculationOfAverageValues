package IO;

import java.io.*;

public class WriteFile {

    public void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"))) {
            writer.write(content);
            System.out.println("Data saved to path: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
