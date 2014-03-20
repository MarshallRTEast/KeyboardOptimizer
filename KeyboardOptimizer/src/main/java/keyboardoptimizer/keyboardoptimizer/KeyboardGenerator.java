
package keyboardoptimizer.keyboardoptimizer;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class KeyboardGenerator {
    
    private File file;
    // Pitäisköhän tää antaa suoraan parametrina Keyboardiin
    private HashMap<Character, Integer> mapOfKeys;
    
    // saa parametrikseen tekstitiedoston, josta lukee kirjaimet ja luo niiden perusteella Keyboard-olion
    // Suoraan File parametrina vaiko String-tyyppinen polku tiedostoon?
    public KeyboardGenerator(String filePath) {
        this.file = new File(filePath);
        
    }
    
    // WIP
    // konstruktori jos halutaan käyttää custom-merkkejä näppäimistön luomiseen
    public KeyboardGenerator(String filePath, String keys) {
        this.file = new File(filePath);
        // tänne jotain keysin suhteen?
    }
    
    // WIP
    public HashMap<Character, Integer> defaultCountInstancesOfKeys() {
        return null;
    }
    
}

// tarvitseeko erillisia konstruktoreita vai riittääkö, että on eri metodit näppäimistön luontiin perus ja custom merkeillä?
