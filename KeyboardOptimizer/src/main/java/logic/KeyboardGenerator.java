package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Luokka saa parametrikseen tiedoston ja luo sen pohjalta Keyboard-olion, johon
 * on laskettu tiedostosta löytyvät merkkien määrät. Käytettävät merkit voi
 * valita joko itse tai käyttää suomalaisia isoja aakkosia.
 */
public class KeyboardGenerator {

    private File file;
    private HashMap<Character, Integer> mapOfKeys;
    private String keys;

    /**
     * Konstruktori, joka luo Keyboard-olion käyttäen suomalaisia isoja
     * kirjaimia.
     *
     * @param filePath
     * @throws java.io.FileNotFoundException
     */
    public KeyboardGenerator(String filePath) throws FileNotFoundException {
        this.file = new File(filePath);
        this.mapOfKeys = new HashMap<Character, Integer>();
        this.keys = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ";
        for (int i = 0; i < keys.length(); i++) {
            mapOfKeys.put(keys.charAt(i), 0);
        }
    }

    /**
     * Konstruktori, joka luo Keyboard-olion käyttäen valittuja merkkejä.
     *
     * @param filePath
     * @param keys
     * @throws java.io.FileNotFoundException
     */
    public KeyboardGenerator(String filePath, String keys) throws FileNotFoundException {
        this.keys = keys;
        this.file = new File(filePath);
        this.mapOfKeys = new HashMap<Character, Integer>();
        for (int i = 0; i < keys.length(); i++) {
            if (!mapOfKeys.containsKey(keys.charAt(i))) {
                mapOfKeys.put(keys.charAt(i), 0);
            }
        }
    }

    /**
     *Metodi luo Keyboard-olion, jonka jokaiseen merkkiin liittyvä määrä on 0.
     * @return  Tyhjä Keyboard-olio.
     */
    public Keyboard createEmptyKeyboard() {
        Keyboard keyboard = new Keyboard(mapOfKeys, keys);
        return keyboard;
    }

    /**
     * Metodi laskee tiedostosta kirjaimet ja luo uuden Keyboard-olion käyttäen näitä merkkejä ja niihin liittyviä määriä.
     * 
     * @return  Uusi Keyboard-olio, johon on laskettu merkkeihin liittyvät määrät.
     * @throws java.io.FileNotFoundException 
     */
    public Keyboard countInstancesOfKeysAndCreateKeyboard() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (this.mapOfKeys.containsKey(line.charAt(i))) {
                    this.mapOfKeys.put(line.charAt(i), this.mapOfKeys.get(line.charAt(i)) + 1);
                }
            }
        }
        scanner.close();
        Keyboard keyboard = new Keyboard(this.mapOfKeys, keys);
        return keyboard;
    }
}
