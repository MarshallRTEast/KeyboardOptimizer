/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import keyboardoptimizer.keyboardoptimizer.Keyboard;
import keyboardoptimizer.keyboardoptimizer.KeyboardGenerator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hanskat
 */
public class KeyboardGeneratorTest {

    Keyboard defaultKeyboard;
    HashMap<Character, Integer> mapOfKeys;

    public KeyboardGeneratorTest() {
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
    public void createEmptyKeyboardToimii() throws Exception{
        KeyboardGenerator KBGen = new KeyboardGenerator("..\\Dokumentaatio\\Testitiedostot\\Testifilu1.txt");
        Keyboard testKeyboard = KBGen.createEmptyKeyboard();
        assertEquals("A: 0, B: 0, C: 0, D: 0, E: 0, F: 0, G: 0, H: 0, I: 0, J: 0, K: 0, L: 0, M: 0, N: 0, O: 0, P: 0, Q: 0, R: 0, S: 0, T: 0, U: 0, V: 0, W: 0, X: 0, Y: 0, Z: 0, Å: 0, Ä: 0, Ö: 0", testKeyboard.toString());
    }

    @Test
    public void defaultKonstruktoriLasketullaKeyboardillaToimii() throws Exception {
        KeyboardGenerator KBGen = new KeyboardGenerator("..\\Dokumentaatio\\Testitiedostot\\Testifilu1.txt");
        Keyboard testKeyboard = KBGen.countInstancesOfKeysAndCreateKeyboard();
        assertEquals("A: 5, B: 7, C: 9, D: 11, E: 13, F: 15, G: 0, H: 0, I: 0, J: 0, K: 0, L: 0, M: 0, N: 0, O: 0, P: 0, Q: 0, R: 0, S: 0, T: 0, U: 0, V: 0, W: 0, X: 0, Y: 0, Z: 0, Å: 0, Ä: 0, Ö: 0", testKeyboard.toString());
    }

    @Test
    public void customKonstruktoriLasketullaKeyboardillaToimii() throws Exception {
        KeyboardGenerator KBGen = new KeyboardGenerator("..\\Dokumentaatio\\Testitiedostot\\Testifilu1.txt", "ABCDEF");
        Keyboard testKeyboard = KBGen.countInstancesOfKeysAndCreateKeyboard();
        assertEquals(defaultKeyboard.toString(), testKeyboard.toString());
    }
    
    @Test
    public void customKonstruktoriLasketullaKeyboardillaTiedostossaEiOikeitaMerkkeja() throws Exception {
        KeyboardGenerator KBGen = new KeyboardGenerator("..\\Dokumentaatio\\Testitiedostot\\Testifilu1.txt", "GHI");
        Keyboard testKeyboard = KBGen.countInstancesOfKeysAndCreateKeyboard();
        assertEquals("G: 0, H: 0, I: 0", testKeyboard.toString());
    }
}
