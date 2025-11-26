package IO;

import Interfaces.WriteFile;

import java.io.*;

public class WriteFileIMPL implements WriteFile {

    /**
     * This method writes the provided content to a file at the specified file path.
     * If the file does not exist, it will be created. If it exists, the content will be appended.
     *
     * @param filePath The path to the file where the content will be written.
     * @param content  The content to write to the file.
     */
    @Override
    public void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"))) {
            writer.write(content);
//            System.out.println("Data saved to path: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
