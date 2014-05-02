package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Luokka saa parametrikseen tiedoston ja luo sen pohjalta Keyboard-olion, johon
 * on laskettu tiedostosta löytyvät merkkien määrät. Käytettävät merkit voi
 * valita joko itse tai käyttää isoja aakkosia.
 */
public class KeyboardGenerator {

    /**
     * Tiedosto, josta luetaan haluttuja merkkejä
     */
    private File file;
    /**
     * Map-olio luotavan Keyboardiin liittyvien merkkien ja niiden määrän tallentamiseen
     * 
     * @see logic.Keyboard#mapOfKeys
     */
    private Map<Character, Integer> mapOfKeys;
    /**
     * String-olio niistä merkeistä, jotka kuuluvat luotavaan Keyboardiin
     * 
     * @see logic.Keyboard#keys
     */
    private String keys;

    /**
     * Konstruktori, joka asettaa KeyboardGeneratorille valitun tiedoston ja
     * esivalitut merkit luettavaksi
     *
     * @param filePath Tiedostopolku luettavalle tiedostolle
     * @throws java.io.FileNotFoundException
     */
    public KeyboardGenerator(String filePath) throws FileNotFoundException {
        this.file = new File(filePath);
        this.mapOfKeys = new TreeMap<Character, Integer>() {};
        this.keys = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < keys.length(); i++) {
            mapOfKeys.put(keys.charAt(i), 0);
        }
    }

    /**
     * Konstruktori, joka asettaa KeyboardGeneratorille valitun tiedoston ja
     * käyttäjän valitsemat merkit luettavaksi
     *
     * @param filePath Tiedostopolku luettavalle tiedostolle
     * @param keys String muuttuja, joka sisältää merkit joita luetaan tiedostosta
     * @throws java.io.FileNotFoundException
     */
    public KeyboardGenerator(String filePath, String keys) throws FileNotFoundException {
        this.keys = keys;
        this.file = new File(filePath);
        this.mapOfKeys = new TreeMap<Character, Integer>();
        for (int i = 0; i < keys.length(); i++) {
            if (!mapOfKeys.containsKey(keys.charAt(i))) {
                mapOfKeys.put(keys.charAt(i), 0);
            }
        }
    }

    /**
     *Metodi luo Keyboard-olion, jonka jokaiseen merkkiin liittyvä määrä on 0.
     * 
     * @see logic.Keyboard
     * @return  Tyhjä Keyboard-olio.
     */
    public Keyboard createEmptyKeyboard() {
        Keyboard keyboard = new Keyboard(mapOfKeys, keys, 0);
        return keyboard;
    }

    /**
     * Metodi laskee tiedostosta kirjaimet ja luo uuden Keyboard-olion käyttäen näitä merkkejä ja niihin liittyviä määriä.
     * 
     * @see logic.Keyboard
     * @return  Uusi Keyboard-olio, johon on laskettu merkkeihin liittyvät määrät.
     * @throws java.io.FileNotFoundException 
     */
    public Keyboard countInstancesOfKeysAndCreateKeyboard() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file, "UTF-8");
        int amountOfKeysInFile = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                amountOfKeysInFile++;
                if (this.mapOfKeys.containsKey(line.charAt(i))) {
                    this.mapOfKeys.put(line.charAt(i), this.mapOfKeys.get(line.charAt(i)) + 1);
                }
            }
        }
        scanner.close();
        Keyboard keyboard = new Keyboard(this.mapOfKeys, keys, amountOfKeysInFile);
        return keyboard;
    }
}
