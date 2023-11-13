package hashTable.Classes;

import java.util.HashMap;

public class LeftJoin {
    public static HashMap<String, String[]> leftJoin(HashMap<String, String> synonyms, HashMap<String, String> antonyms) {
        HashMap<String, String[]> result = new HashMap<>();
        for (String key : synonyms.keySet()) {
            String synonym = synonyms.get(key);
            result.put(key, new String[]{synonym, null});
        }
        for (String key : antonyms.keySet()) {
            String antonym = antonyms.get(key);
            if (result.containsKey(key)) {
                result.get(key)[1] = antonym;
            }
        }
        return result;
    }
}
