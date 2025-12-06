package Interfaces;

import Security.Stock;

import java.util.List;

public interface ReadFile {

    /**
     * This method reads stock data from a file and creates a list of Stock objects.
     * Each line in the file should contain stock information in the format: "name nowValue 52WHigh 52WLow".
     * If the line does not conform to this format, it will be skipped with an error message.
     *
     * @param filePath The path to the file containing stock data.
     * @return A list of Stock objects created from the file data.
     */
    List<Stock> creatingListFromFile(String filePath);
}
