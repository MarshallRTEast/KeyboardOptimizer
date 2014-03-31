/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardoptimizer.keyboardoptimizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Keyboard {

    private Map<Character, Integer> mapOfKeys;
    private String keys;
    private char[][] placementMatrix;

    // tällähetkellä luo placementMatrixin pelkästään kirjaimille, pitää miettiä miten toteuttaa laajentamisen suhteen:
    // parametrina vaiko vain joku riittävän iso matriisi?
    public Keyboard(HashMap<Character, Integer> mapOfKeys, String keys) {
        this.mapOfKeys = mapOfKeys;
        this.keys = keys;
        this.placementMatrix = new char[3][12];
        for (int i = 0; i < 12; i++) {
            placementMatrix[0][i] = '_';
            placementMatrix[1][i] = '_';
            if (i < 8) {
                placementMatrix[2][i] = '_';
            }
        }
    }

    public void setOneKeyAmountUsingChar(char key, int amount) {
        if (this.mapOfKeys.containsKey(key)) {
            this.mapOfKeys.put(key, amount);
        }
    }

    // palautetaan merkkiin liittyvä määrä
    public int getAmount(char key) {
        if (!mapOfKeys.containsKey(key)) {
            return 0;
        }
        return mapOfKeys.get(key);
    }

    // palautetaan kaikki merkit ja niiden määrät muodossa:
    // A: 2, B: 4, ... , Ä: 15, Ö: 8
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < keys.length() - 1; i++) {
            output += keys.charAt(i) + ": " + mapOfKeys.get(keys.charAt(i)) + ", ";
        }
        output += keys.charAt(keys.length() - 1) + ": " + mapOfKeys.get(keys.charAt(keys.length() - 1));
        return output;
    }

    // ei koodin kannalta välttämättä tarpeellinen, lähinnä itselle selvennykseksi
//    public void printPlacementMatrix() {
//        for (int n = 0; n < placementMatrix.length; n++) {
//            for (int m = 0; m < placementMatrix[n].length; m++) {
//                if (!(n == 2 && m > 8)) {
//                    System.out.print("|" + placementMatrix[n][m]);
//                }
//            }
//            System.out.println("|");
//        }
//    }
    
    public char[][] getPlacementMatrix() {
        return this.placementMatrix;
    }

    public void placeCharacterIntoMatrix(char toBePlaced, int n, int m) {
        placementMatrix[n][m] = toBePlaced;
    }

    public void deleteMatrixNode(int n, int m) {
        placementMatrix[n][m] = '_';
    }

    public void deleteCharacterFromMatrix(char toBeDeleted) {
        for (int n = 0; n < placementMatrix.length; n++) {
            for (int m = 0; m < placementMatrix[n].length; m++) {
                if (placementMatrix[n][m] == toBeDeleted) {
                    placementMatrix[n][m] = '_';
                    return;
                }
            }
        }
    }
    // voidaan asettaa tietty arvo tietylle merkille pelkästään indeksin avulla
    // lienee tarpeeton metodi, varsinkin ku muutin konstruktoreita
//    public void setOneKeyAmountUsingIndex(int indexOfKey, int amount) {
//        if (indexOfKey > -1 && indexOfKey < keys.length()) {
//            this.mapOfKeys.put(keys.charAt(indexOfKey), amount);
//        }
//    }
    // voidaan asettaa tietty arvo tietylle merkille
}
