import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class NumberExtractorTest {

    @org.junit.jupiter.api.Test
    void extractNumbers() {
        NumberExtractor numberExtractor = new NumberExtractor();
        ArrayList<Float> actual = numberExtractor.extractNumbers("-12+56*80+55");

        assertEquals(-12, actual.get(0));
        assertEquals(55, actual.get(actual.size()-1));
    }

    @org.junit.jupiter.api.Test
    void testPopStack() {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('a');
        stack.push('a');
        stack.push('b');

        NumberExtractor numberExtractor = new NumberExtractor();
        String result = new Utility().popStack(stack);

        assertEquals("baaa", result);
    }

    @org.junit.jupiter.api.Test
    void testReverseString() {
        String str = "ahmed";

        NumberExtractor numberExtractor = new NumberExtractor();
        String result = new Utility().reverseString(str);

        assertEquals("demha", result);
    }
}