package logic;


import java.util.HashMap;
import java.util.Map;
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

    @Test
    public void matriisinGettausToimii() {
        char[][] matriisi = {{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_',0,0,0,0}};
        assertEquals(matriisi, defaultKeyboard.getPlacementMatrix());
    }

    @Test
    public void matriisiinLisaysToimii() {
        defaultKeyboard.placeCharacterIntoMatrix('A', 0, 0);
        char[][] matriisi = defaultKeyboard.getPlacementMatrix();
        assertEquals('A', matriisi[0][0]);

        defaultKeyboard.placeCharacterIntoMatrix('B', 1, 4);
        matriisi = defaultKeyboard.getPlacementMatrix();
        assertEquals('B', matriisi[1][4]);

        defaultKeyboard.placeCharacterIntoMatrix('C', 2, 7);
        matriisi = defaultKeyboard.getPlacementMatrix();
        assertEquals('C', matriisi[2][7]);

        defaultKeyboard.placeCharacterIntoMatrix('D', 1, 11);
        matriisi = defaultKeyboard.getPlacementMatrix();
        assertEquals('D', matriisi[1][11]);
    }

    @Test
    public void matriisistaPoistoMerkillaToimii() {
        char[][] matriisi = defaultKeyboard.getPlacementMatrix();
        defaultKeyboard.placeCharacterIntoMatrix('A', 0, 0);
        defaultKeyboard.placeCharacterIntoMatrix('B', 1, 4);
        defaultKeyboard.placeCharacterIntoMatrix('D', 2, 7);
        defaultKeyboard.placeCharacterIntoMatrix('C', 1, 11);

        defaultKeyboard.deleteCharacterFromMatrix('A');
        defaultKeyboard.deleteCharacterFromMatrix('B');
        defaultKeyboard.deleteCharacterFromMatrix('C');
        defaultKeyboard.deleteCharacterFromMatrix('D');
        assertEquals('_', matriisi[0][0]);
        assertEquals('_', matriisi[0][4]);
        assertEquals('_', matriisi[1][11]);
        assertEquals('_', matriisi[2][7]);
    }

    @Test
    public void matriisistaPoistoNodellaToiii() {
        char[][] matriisi = defaultKeyboard.getPlacementMatrix();
        defaultKeyboard.placeCharacterIntoMatrix('A', 0, 0);
        defaultKeyboard.placeCharacterIntoMatrix('B', 1, 4);
        defaultKeyboard.placeCharacterIntoMatrix('D', 2, 7);
        defaultKeyboard.placeCharacterIntoMatrix('C', 1, 11);

        defaultKeyboard.deleteMatrixNode(0, 0);
        defaultKeyboard.deleteMatrixNode(1, 4);
        defaultKeyboard.deleteMatrixNode(1, 11);
        defaultKeyboard.deleteMatrixNode(2, 7);

        assertEquals('_', matriisi[0][0]);
        assertEquals('_', matriisi[0][4]);
        assertEquals('_', matriisi[1][11]);
        assertEquals('_', matriisi[2][7]);
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

