package Cards_tests;


import Cards.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class Value_test {
    @Test
    public void testValue() throws ValueException {
        PokerValue c1 = new PokerValue(PokerValue.Values.ACE);
        PokerValue c2 = new PokerValue(PokerValue.Values.ACE);
        PokerValue c3 = new PokerValue(PokerValue.Values.THREE);
        PokerValue c4 = new PokerValue(PokerValue.Values.THREE);
        assertEquals(c1, c2);
        assertEquals(c3, c4);
        assertNotEquals(c1, c3);
        assertNotEquals(c2, c3);
        assertNotEquals(c2, c4);
    }

    @Test
    public void testToString() throws ValueException {
        PokerValue c1 = new PokerValue(PokerValue.Values.THREE);
        assertEquals("Value=THREE", c1.toString());
    }
}
