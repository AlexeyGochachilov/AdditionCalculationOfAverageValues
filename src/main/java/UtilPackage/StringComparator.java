package UtilPackage;

import java.util.*;

public class StringComparator {

    public static String findCommonWords(String str1, String str2) {
        // Разбиваем строки на слова
        String[] words1 = str1.split("\\s+");
        String[] words2 = str2.split("\\s+");

        // Создаем HashSet для быстрого поиска слов из второй строки
        Set<String> wordSet = new HashSet<>(Arrays.asList(words2));

        // Используем LinkedHashSet для сохранения порядка и уникальности
        Set<String> commonWords = new LinkedHashSet<>();

        // Проверяем слова из первой строки
        for (String word : words1) {
            if (wordSet.contains(word)) {
                commonWords.add(word);
            }
        }

        // Собираем результат в строку
        return String.join(" ", commonWords);
    }

    public static String findCommonWords(String str1, String str2, String str3) {
        // Разбиваем строки на слова
        String[] words1 = str1.split("\\s+");
        String[] words2 = str2.split("\\s+");
        String[] words3 = str3.split("\\s+");

        // Создаем HashSet для быстрого поиска слов из второй строки
        Set<String> wordSet1 = new HashSet<>(Arrays.asList(words2));

        // Создаем HashSet для быстрого поиска слов из второй строки
        Set<String> wordSet2 = new HashSet<>(Arrays.asList(words3));

        // Используем LinkedHashSet для сохранения порядка и уникальности
        Set<String> commonWords = new LinkedHashSet<>();

        // Проверяем слова из первой строки
        for (String word : words1) {
            if (wordSet1.contains(word) || wordSet2.contains(word)) {
                commonWords.add(word);
            }
        }

        // Собираем результат в строку
        return String.join(" ", commonWords);
    }
}
