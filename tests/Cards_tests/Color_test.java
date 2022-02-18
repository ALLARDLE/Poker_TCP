package Cards_tests;


import Cards.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class Color_test {
    @Test
    public void testEqual() throws ColorException {
        PokerColor c1 = new PokerColor(PokerColor.Colors.HEART);
        PokerColor c2 = new PokerColor(PokerColor.Colors.HEART);
        PokerColor c3 = new PokerColor(PokerColor.Colors.DIAMOND);
        PokerColor c4 = new PokerColor(PokerColor.Colors.CLUB);
        assertEquals(c1, c2);
        assertNotEquals(c1, c3);
        assertNotEquals(c2, c3);
        assertNotEquals(c2, c4);
    }
}