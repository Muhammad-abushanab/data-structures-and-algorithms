package hashTable;

import hashTable.Classes.LeftJoin;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeftJoinTest {

    @Test
    public void noMatchingWordsIn_A_LeftJoinShouldReturnOnlyTheLeftHashMap() {
        HashMap<String,String> hs1 = new HashMap<>();
        hs1.put("place","jordan");
        hs1.put("animal","cat");
        hs1.put("shape","square");
        HashMap<String,String> hs2 = new HashMap<>();
        hs2.put("type",".mp4");
        hs2.put("language","english");
        hs2.put("nationality","syrian");

        HashMap<String,String[]> result = LeftJoin.leftJoin(hs1,hs2);
        assertEquals(hs1.size(),result.size());
        for (String key: result.keySet()
             ) {
            assertEquals(result.containsKey(key),hs1.containsKey(key));
        }
        result.clear();
        result = LeftJoin.leftJoin(hs2,hs1);
        assertEquals(hs2.size(),result.size());
        for (String key: result.keySet()
        ) {
            assertEquals(result.containsKey(key),hs2.containsKey(key));
        }
    }

    @Test
    public void matchingWordsShould_ReturnTheLeftHashMap_InAdditionTo_TheMatchedWords_InTheRightHashmap(){
        HashMap<String,String> hs1 = new HashMap<>();
        hs1.put("place","jordan");
        hs1.put("language","Arabic");
        hs1.put("shape","square");
        HashMap<String,String> hs2 = new HashMap<>();
        hs2.put("place","Saudi");
        hs2.put("language","english");
        hs2.put("nationality","syrian");

        HashMap<String,String[]> result = LeftJoin.leftJoin(hs1,hs2);
        assertEquals(hs1.size(),result.size());
        for (String key: result.keySet()
        ) {
            assertEquals(result.containsKey(key),hs1.containsKey(key));
        }
    }
}
