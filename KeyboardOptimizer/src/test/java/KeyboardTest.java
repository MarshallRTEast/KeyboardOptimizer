
import java.util.HashMap;
import java.util.Map;
import keyboardoptimizer.keyboardoptimizer.Keyboard;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KeyboardTest {

    Keyboard defaultKeyboard;
    HashMap<Character, Integer> mapOfKeys;

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
        String keys = "ABCDEF";
        mapOfKeys = new HashMap<Character, Integer>();
        for (int i = 0; i < keys.length(); i++) {
            mapOfKeys.put(keys.charAt(i), 5 + 2 * i);
        }
        defaultKeyboard = new Keyboard(mapOfKeys, keys);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void KonstruktoriJaToStringToimii() {
        assertEquals("A: 5, B: 7, C: 9, D: 11, E: 13, F: 15", defaultKeyboard.toString());
    }

    @Test
    public void defaultKonstruktoriSetCharillaJaToStringToimii() {

        defaultKeyboard.setOneKeyAmountUsingChar('A', 10);
        defaultKeyboard.setOneKeyAmountUsingChar('B', 5);
        defaultKeyboard.setOneKeyAmountUsingChar('C', 1);
        defaultKeyboard.setOneKeyAmountUsingChar('Z', 1);

        assertEquals("A: 10, B: 5, C: 1, D: 11, E: 13, F: 15", defaultKeyboard.toString());
    }

    @Test
    public void getteriToimiiOikeinSetCharilla() {

        defaultKeyboard.setOneKeyAmountUsingChar('B', 5);
        assertEquals(5, defaultKeyboard.getAmount('B'));
        defaultKeyboard.setOneKeyAmountUsingChar('A', 5);
        assertEquals(5, defaultKeyboard.getAmount('A'));
        defaultKeyboard.setOneKeyAmountUsingChar('T', 5);
        assertEquals(0, defaultKeyboard.getAmount('T'));
    }

    @Test
    public void setCharMuuttaaArvoa() {

        defaultKeyboard.setOneKeyAmountUsingChar('A', 5);
        assertEquals(5, defaultKeyboard.getAmount('A'));

        defaultKeyboard.setOneKeyAmountUsingChar('A', 20);
        assertEquals(20, defaultKeyboard.getAmount('A'));
    }
    
   

}










    // turha testi, jos metodi poistetaan
//    @Test
//    public void defaultKonstruktoriSetIndeksillaJaToStringToimii() {
//
//        keyboard.setOneKeyAmountUsingIndex(0, 10);
//        keyboard.setOneKeyAmountUsingIndex(2, 5);
//        keyboard.setOneKeyAmountUsingIndex(3, 1);
//
//        assertEquals("A: 10, B: 5, C: 1, D: 0, E: 0, F: 0, G: 0, H: 0, I: 0, J: 0, K: 0, L: 0, M: 0, N: 0, O: 0, P: 0, Q: 0, R: 0, S: 0, T: 0, U: 0, V: 0, W: 0, X: 0, Y: 0, Z: 0, Å: 0, Ä: 0, Ö: 0", keyboard.toString());
//    }
    //
    // turha testi, jos Set indeksillä poistetaan
//    @Test
//    public void getteriToimiiOikeinSetIndeksilla() {
//
//        keyboard.setOneKeyAmountUsingIndex(4, 10);
//
//        assertEquals(10, keyboard.getAmount('D'));
//    }
    //
    // turha testi, jos set Indeksillä poistetaan
//    @Test
//    public void setIndexMuuttaaArvoa() {
//
//        keyboard.setOneKeyAmountUsingIndex(4, 10);
//        assertEquals(10, keyboard.getAmount('D'));
//
//        keyboard.setOneKeyAmountUsingIndex(4, 5);
//        assertEquals(5, keyboard.getAmount('D'));
//    }
    //
    // toisen konstruktorin poiston jälkeen turha
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

