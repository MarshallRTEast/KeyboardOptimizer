package keyboardoptimizer.keyboardoptimizer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KeyboardGenerator {

    private File file;
    private HashMap<Character, Integer> mapOfKeys;

    // saa parametrikseen tekstitiedoston, josta lukee kirjaimet ja luo niiden perusteella Keyboard-olion
    // Suoraan File parametrina vaiko String-tyyppinen polku tiedostoon?
    public KeyboardGenerator(String filePath) {
        this.file = new File(filePath);
        this.mapOfKeys = new HashMap<Character, Integer>();
        String keys = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ";
        for (int i = 0; i < keys.length(); i++) {
            mapOfKeys.put(keys.charAt(i), 0);
        }
    }

    // konstruktori jos halutaan käyttää custom-merkkejä näppäimistön luomiseen
    public KeyboardGenerator(String filePath, String keys) {
        this.file = new File(filePath);
        this.mapOfKeys = new HashMap<Character, Integer>();
        for (int i = 0; i < keys.length(); i++) {
            if (!mapOfKeys.containsKey(keys.charAt(i))) {
                mapOfKeys.put(keys.charAt(i), 0);
            }
        }
    }

    public Keyboard createKeyboard() {
        Keyboard keyboard = new Keyboard(mapOfKeys);
        return keyboard;
    }
    
    // WIP
    public HashMap<Character, Integer> defaultCountInstancesOfKeys() throws Exception{
        Scanner scanner = new Scanner(this.file);
        
        return null;
    }
    
    public Keyboard countInstancedOfKeysAndCreateKeyboard() throws Exception {
        Scanner scanner = new Scanner(this.file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (mapOfKeys.containsKey(line.charAt(i))) {
                    mapOfKeys.put(line.charAt(i), mapOfKeys.get(line.charAt(i) + 1));
                }
            }
        }
        scanner.close();
        Keyboard keyboard = new Keyboard(this.mapOfKeys);
        return keyboard;
    }
}

// tarvitseeko erillisia konstruktoreita vai riittääkö, että on eri metodit näppäimistön luontiin perus ja custom merkeillä?
