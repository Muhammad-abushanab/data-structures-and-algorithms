package hashTable.Classes;

import java.util.HashMap;
import java.util.Map;

public class RepeatedWordFinder {
    public static String findFirstRepeatedWord(String input) {
        String[] words = input.split("\\s+");
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            String normalizeWord = wordNormalizer(word);
            if (normalizeWord.isEmpty()) {
                continue;
            }
            if (wordFrequency.containsKey(normalizeWord)) {
                return normalizeWord;
            } else {
                wordFrequency.put(normalizeWord, 1);
            }
        }
        return null;
    }

    public static String wordNormalizer(String word) {
        return word.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

}
