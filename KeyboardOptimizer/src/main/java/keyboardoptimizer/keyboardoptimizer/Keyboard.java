/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardoptimizer.keyboardoptimizer;

import java.util.HashMap;
import java.util.Map;


public class Keyboard {

    private Map<Character, Integer> mapOfKeys;
    private String keys;

    
    public Keyboard(HashMap<Character, Integer> mapOfKeys) {
        this.mapOfKeys = mapOfKeys;
    }


    // voidaan asettaa tietty arvo tietylle merkille pelkästään indeksin avulla
    // lienee tarpeeton metodi, varsinkin ku muutin konstruktoreita
//    public void setOneKeyAmountUsingIndex(int indexOfKey, int amount) {
//        if (indexOfKey > -1 && indexOfKey < keys.length()) {
//            this.mapOfKeys.put(keys.charAt(indexOfKey), amount);
//        }
//    }

    // voidaan asettaa tietty arvo tietylle merkille
    public void setOneKeyAmountUsingChar(char key, int amount) {
        this.mapOfKeys.put(key, amount);
    }
    
    

    // palautetaan merkkiin liittyvä määrä
    public int getAmount(char key) {
        return mapOfKeys.get(key);
    }

    // palautetaan kaikki merkit ja niiden määrät muodossa:
    // A: 2, B: 4, ... , Ä: 15, Ö: 8
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < keys.length() - 1; i++) {
            output += keys.charAt(i) + ": " + mapOfKeys.get(i) + ", ";
        }
        output += keys.charAt(keys.length() - 1) + ": " + mapOfKeys.get(keys.length() - 1);
        return output;
    }
}
