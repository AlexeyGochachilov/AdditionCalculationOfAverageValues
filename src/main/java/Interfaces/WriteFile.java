package Interfaces;

public interface WriteFile {

    /**
     * This method writes the provided content to a file at the specified file path.
     * If the file does not exist, it will be created. If it exists, the content will be appended.
     *
     * @param filePath The path to the file where the content will be written.
     * @param content  The content to write to the file.
     */
    void writeToFile(String filePath, String content);
}
