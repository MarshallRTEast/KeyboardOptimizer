

import keyboardoptimizer.keyboardoptimizer.Keyboard;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KeyboardTest {

    Keyboard keyboard;

    public KeyboardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
//        Keyboard keyboard = new Keyboard();
    }

    @After
    public void tearDown() {
    }

    // !!HUOM!!
    // ANTAA JOTAIN HÄMÄRÄÄ ERRORIA JOTA EN YMMÄRRÄ, EN VOI TESTATA TESTIEN TOIMIVUUTTA!
    // Failure executing javac, but could not parse the error: javac: invalid target release: 1.7
    
    
    @Test
    public void defaultKonstruktorijaToStringToimii() {

        assertEquals("A: 0, B: 0, C: 0, D: 0, E: 0, F: 0, G: 0, H: 0, I: 0, J: 0, K: 0, L: 0, M: 0, N: 0, O: 0, P: 0, Q: 0, R: 0, S: 0, T: 0, U: 0, V: 0, W: 0, X: 0, Y: 0, Z: 0, Å: 0, Ä: 0, Ö: 0", keyboard.toString());
    }

    @Test
    public void defaultKonstruktoriSetIndeksillaJaToStringToimii() {

        keyboard.setOneKeyAmountUsingIndex(0, 10);
        keyboard.setOneKeyAmountUsingIndex(2, 5);
        keyboard.setOneKeyAmountUsingIndex(3, 1);

        assertEquals("A: 10, B: 5, C: 1, D: 0, E: 0, F: 0, G: 0, H: 0, I: 0, J: 0, K: 0, L: 0, M: 0, N: 0, O: 0, P: 0, Q: 0, R: 0, S: 0, T: 0, U: 0, V: 0, W: 0, X: 0, Y: 0, Z: 0, Å: 0, Ä: 0, Ö: 0", keyboard.toString());
    }

    @Test
    public void defaultKonstruktoriSetCharillaJaToStringToimii() {

        keyboard.setOneKeyAmountUsingChar('A', 10);
        keyboard.setOneKeyAmountUsingChar('B', 5);
        keyboard.setOneKeyAmountUsingChar('C', 1);

        assertEquals("A: 10, B: 5, C: 1, D: 0, E: 0, F: 0, G: 0, H: 0, I: 0, J: 0, K: 0, L: 0, M: 0, N: 0, O: 0, P: 0, Q: 0, R: 0, S: 0, T: 0, U: 0, V: 0, W: 0, X: 0, Y: 0, Z: 0, Å: 0, Ä: 0, Ö: 0", keyboard.toString());
    }

    @Test
    public void getteriToimiiOikeinSetIndeksilla() {

        keyboard.setOneKeyAmountUsingIndex(4, 10);

        assertEquals(10, keyboard.getAmount('D'));
    }

    @Test
    public void getteriToimiiOikeinSetCharilla() {

        keyboard.setOneKeyAmountUsingChar('Z', 5);
        assertEquals(5, keyboard.getAmount('Z'));
    }

    @Test
    public void setIndexMuuttaaArvoa() {

        keyboard.setOneKeyAmountUsingIndex(4, 10);
        assertEquals(10, keyboard.getAmount('D'));

        keyboard.setOneKeyAmountUsingIndex(4, 5);
        assertEquals(5, keyboard.getAmount('D'));
    }

    @Test
    public void setCharMuuttaaArvoa() {

        keyboard.setOneKeyAmountUsingChar('Z', 5);
        assertEquals(5, keyboard.getAmount('Z'));

        keyboard.setOneKeyAmountUsingChar('Z', 20);
        assertEquals(20, keyboard.getAmount('Z'));
    }

//    @Test
//    public void parametrillinenKonstruktoriToimii() {
//
//        Keyboard nappaimisto = new Keyboard("ABC");
//        assertEquals("A: 0, B: 0, C: 0", nappaimisto.toString());
//    }
//
//    @Test
//    public void parametrillinenKonstruktoriEiLueDuplikaatteja() {
//
//        Keyboard nappaimisto = new Keyboard("ABCAA");
//        assertEquals("A: 0, B: 0, C: 0", nappaimisto.toString());
//    }
//
//    @Test
//    public void parametrillinenKonstruktoriToimiiMuillakinKuinKirjaimilla() {
//
//        Keyboard nappaimisto = new Keyboard(",.-");
//        assertEquals(",: 0, .: 0, -: 0", nappaimisto.toString());
//    }
}
