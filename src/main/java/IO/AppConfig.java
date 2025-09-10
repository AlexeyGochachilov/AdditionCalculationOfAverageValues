package IO;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class AppConfig {

    private static final Properties properties = new Properties();
    private static final String CONFIG_FILE = "outPutFilePath.properties";

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input != null) {
                properties.load(input);
            } else {
                // Установка значений по умолчанию, если файл не найден
                setDefaultProperties();
            }
        } catch (IOException e) {
            setDefaultProperties();
        }
    }

    private static void setDefaultProperties() {
        properties.setProperty("output.base.path", System.getProperty("user.home") + "/market_info");
        properties.setProperty("output.file.template", "info_%s.txt");
    }

    public static String getBasePath() {
        return properties.getProperty("output.base.path");
    }

    public static String getFileTemplate() {
        return properties.getProperty("output.file.template");
    }

    public static Path getOutputPath(String dateString) {
        String basePath = getBasePath();
        String fileName = String.format(getFileTemplate(), dateString);

        Path outputDir = Paths.get(basePath);
        try {
            if (!Files.exists(outputDir)) {
                Files.createDirectories(outputDir);
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось создать директорию: " + outputDir, e);
        }

        return outputDir.resolve(fileName);
    }
}
