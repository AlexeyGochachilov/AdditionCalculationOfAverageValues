package IO;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;

public class OpenFile {

    /**
     * This method opens a file using the system's default application for that file type.
     * It checks if the Desktop API is supported and if the action to open files is available.
     *
     * @param filePath The path to the file to be opened.
     */
    public static void openFile(Path filePath) {
        try {
            // Проверяем поддержку Desktop API
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop API не поддерживается");
                return;
            }

            Desktop desktop = Desktop.getDesktop();

            // Проверяем, поддерживается ли открытие файлов
            if (!desktop.isSupported(Desktop.Action.OPEN)) {
                System.out.println("Открытие файлов не поддерживается");
                return;
            }

            // Открываем файл
            desktop.open(filePath.toFile());
            System.out.println("Файл открыт в системном приложении");

        } catch (IOException e) {
            System.err.println("Ошибка при открытии файла: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Файл не существует: " + e.getMessage());
        }
    }
}
