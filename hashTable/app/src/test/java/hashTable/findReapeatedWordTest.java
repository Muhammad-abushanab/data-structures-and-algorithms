package hashTable;

import hashTable.Classes.RepeatedWordFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class findReapeatedWordTest {
    @Test
    public void firstRepeatedWordInEmptyString() {
        String input = "";
        String result = RepeatedWordFinder.findFirstRepeatedWord(input);
        assertNull(result);
    }

    @Test
    public void firstRepeatedWordInUniqueWords() {
        String input = "Good Afternoon gentlemen.";
        String result = RepeatedWordFinder.findFirstRepeatedWord(input);
        assertNull(result);
    }

    @Test
    public void firstRepeatedWordInMultipleSentences() {
        String input = "Mohammad went to the shop. Mohammad is now in the garden";
        String result = RepeatedWordFinder.findFirstRepeatedWord(input);
        assertEquals("mohammad", result);
    }

    @Test
    public void firstRepeatedWordWithPunctuation() {
        String input = "play! What do you want to play.";
        String result = RepeatedWordFinder.findFirstRepeatedWord(input);
        assertEquals("play", result);
    }

}
