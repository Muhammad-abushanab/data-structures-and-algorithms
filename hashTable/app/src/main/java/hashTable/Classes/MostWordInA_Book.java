package hashTable.Classes;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MostWordInA_Book {
    private final String book;

    public MostWordInA_Book(String book) {
        this.book = book;
    }

    public String mostWordInABook() {
        HashMap<String, Integer> table = new HashMap<>();
        String[] words = book.split("\\s+");
        for (String word : words
        ) {
            word = word.toLowerCase();
            word = word.replaceAll("[^a-zA-Z]", "");

            if (!word.isEmpty()) {
                table.put(word, table.getOrDefault(word, 0) + 1);
            }
        }
        return countMostCommonWord(table);
    }

    private String countMostCommonWord(HashMap<String, Integer> table) {
        String mostCommonWord = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : table.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommonWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostCommonWord;
    }
}
