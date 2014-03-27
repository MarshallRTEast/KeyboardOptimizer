package keyboardoptimizer.keyboardoptimizer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// saa parametrikseen tekstitiedoston, josta lukee kirjaimet ja luo niiden perusteella Keyboard-olion
// Suoraan File parametrina vaiko String-tyyppinen polku tiedostoon?
public class KeyboardGenerator {

    private File file;
    private HashMap<Character, Integer> mapOfKeys;
    private String keys;

// defaultKonstruktori, luo Keyboard-olion pelkästään kirjain-näppäimille
    public KeyboardGenerator(String filePath) throws Exception{
        this.file = new File(filePath);
        this.mapOfKeys = new HashMap<Character, Integer>();
        this.keys = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ";
        for (int i = 0; i < keys.length(); i++) {
            mapOfKeys.put(keys.charAt(i), 0);
        }
    }

    // konstruktori jos halutaan käyttää custom-merkkejä näppäimistön luomiseen
    public KeyboardGenerator(String filePath, String keys) throws Exception {
        this.keys = keys;
        this.file = new File(filePath);
        this.mapOfKeys = new HashMap<Character, Integer>();
        for (int i = 0; i < keys.length(); i++) {
            if (!mapOfKeys.containsKey(keys.charAt(i))) {
                mapOfKeys.put(keys.charAt(i), 0);
            }
        }
    }

    public Keyboard createEmptyKeyboard() {
        Keyboard keyboard = new Keyboard(mapOfKeys, keys);
        return keyboard;
    }


    public Keyboard countInstancesOfKeysAndCreateKeyboard() throws Exception {
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

