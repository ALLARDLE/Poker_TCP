package Cards_tests;


import Cards.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class Card_test {
    @Test
    public void testEquals() throws ColorException, ValueException {
        PokerCard c1 = new PokerCard(new PokerColor(PokerColor.Colors.HEART), new PokerValue(PokerValue.Values.ACE));
        PokerCard c2 = new PokerCard(new PokerColor(PokerColor.Colors.HEART), new PokerValue(PokerValue.Values.ACE));
        PokerCard c3 = new PokerCard(new PokerColor(PokerColor.Colors.HEART), new PokerValue(PokerValue.Values.THREE));
        PokerCard c4 = new PokerCard(new PokerColor(PokerColor.Colors.CLUB), new PokerValue(PokerValue.Values.THREE));
        assertEquals(c1, c2);
        assertNotEquals(c1, c3);
        assertNotEquals(c2, c3);
        assertNotEquals(c2, c4);
    }

    @Test
    public void testIsUpperTo() throws Exception {
        PokerCard c1 = new PokerCard(new PokerColor(PokerColor.Colors.HEART), new PokerValue(PokerValue.Values.TWO));
        PokerCard c2 = new PokerCard(new PokerColor(PokerColor.Colors.HEART), new PokerValue(PokerValue.Values.THREE));
        PokerCard c3 = new PokerCard(new PokerColor(PokerColor.Colors.DIAMOND), new PokerValue(PokerValue.Values.FOUR));

        assertEquals(-1, c1.isUpperTo(c2));
        assertEquals(0, c2.isUpperTo(c2));
        assertEquals(2, c3.isUpperTo(c1));
    }

    @Test
    public void testToString() throws ValueException, ColorException {
        PokerCard c1 = new PokerCard(new PokerColor(PokerColor.Colors.HEART), new PokerValue(PokerValue.Values.ACE));
        assertEquals("PokerCard{PokerColor=HEART, Value=ACE}", c1.toString());
    }
}
