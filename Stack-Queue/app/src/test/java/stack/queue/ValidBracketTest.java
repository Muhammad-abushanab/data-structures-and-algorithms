package stack.queue;

import org.junit.jupiter.api.Test;
import stack.queue.stack.ValidBracket;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidBracketTest {
    @Test
    public void givenEmptyString_Bracket_ShouldReturnTrue(){
        ValidBracket v = new ValidBracket();
        assertTrue(v.validBracket(""));
    }
    @Test
    public void givenString_With_StartingOpenBracket_ShouldReturnFalse(){
        ValidBracket v = new ValidBracket();
        assertFalse(v.validBracket("}(())"));
    }
    @Test
    public void givenStringWith_MixedDataAndCorrectBrackets_ShouldReturnTrue(){
        ValidBracket v = new ValidBracket();
        assertTrue(v.validBracket("{Mohammad(4587)[Asac{temp}]}"));
    }
    @Test
    public void givenStringWith_MissingClosingBracket_ShouldReturnFalse(){
        ValidBracket v =new ValidBracket();
        assertFalse(v.validBracket("{[}"));
    }
}
