package logic;

import java.util.Map;

/**
 * Luokka toimii Keyboard-oliona, jolla on tiedossa sille asetetut näppäimet ja
 * niihin liittyvät määrät. Lisäksi luokassa voidaan asettaa jokaiselle merkille
 * paikka näppäimistöä kuvaavassa matriisissa.
 */
public class Keyboard {

    /**
     * Map-olio Keyboardiin liittyvien merkkien ja niiden määrän tallentamiseen
     */
    private Map<Character, Integer> mapOfKeys;
    /**
     * String-olio niistä merkeistä, jotka kuuluvat Keyboardiin
     */
    private String keys;
    /**
     * Matriisi, johon voidaan asettaa Keyboardin eri merkit
     */
    private char[][] placementMatrix;
    /**
     * Int muuttuja joka kertoo paljonko merkkejä KeyboardGeneratorin tiedostossa oli yhteensä
     * Käytetään vertailemaan Keyboardin merkkien määriä kokonaismäärään, jotta saadaan prosenttiosuuksia
     * 
     * @see logic.KeyboardGenerator
     */
    private int amountOfKeys;

    /**
     * Konstruktori joka asettaa Keyboardille merkit ja niiden määrät, kaikkien merkkien määrän sekä
     * initialisoi matriisin tyhjäksi
     * 
     * @param mapOfKeys Map, johon on talletettuna merkit ja niihin
     * liittyvät määrät.
     * @param keys HashMapin sisältämät merkit String-muodossa.
     * @param amountOfKeysInFile int muuttuja, joka kertoo paljonko merkkejä tiedostossa oli yhteensä
     */
    public Keyboard(Map<Character, Integer> mapOfKeys, String keys, int amountOfKeysInFile) {
        this.mapOfKeys = mapOfKeys;
        this.keys = keys;
        this.placementMatrix = new char[6][21];
        this.amountOfKeys = amountOfKeysInFile;
        for (int i = 0; i < 6; i++) {
            int k = 0;
            if (i == 1 || i == 2) {
                k = 21;
            } else if (i == 4) {
                k = 18;
            } else if (i == 5) {
                k = 13;
            } else {
                k = 16;
            }
            for (int j = 0; j < k; j++) {
                this.placementMatrix[i][j] = ' ';
            }
        }

    }

    
    public int getAmountOfAllKeys() {        
        return this.amountOfKeys;
    }
    
    /**
     * Metodilla asetetaan tiettyyn merkkiin jokin arvo olion mapOfKeys
     * HashMapissä
     *
     * @param key Merkki, jolle lisätään arvo
     * @param amount Arvo, joka merkille lisätään
     */
    public void setOneKeyAmountUsingChar(char key, int amount) {
        if (this.mapOfKeys.containsKey(key)) {
            this.mapOfKeys.put(key, amount);
        }
    }
    
    public Map<Character, Integer> getMapOfKeys() {
        return this.mapOfKeys;
    }

    public int getAmount(char key) {
        if (!mapOfKeys.containsKey(key)) {
            return 0;
        }
        return mapOfKeys.get(key);
    }

    // palautetaan kaikki merkit ja niiden määrät muodossa:
    // A: 2, B: 4, ... , Z: 5
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < keys.length() - 1; i++) {
            output += keys.charAt(i) + ": " + mapOfKeys.get(keys.charAt(i)) + ", ";
        }
        output += keys.charAt(keys.length() - 1) + ": " + mapOfKeys.get(keys.charAt(keys.length() - 1));
        return output;
    }

    public char[][] getPlacementMatrix() {
        return this.placementMatrix;
    }

    /**
     * Metodissa lisätään olion mapOfKeys HashMapista jokin merkki tietylle
     * paikalle näppäimistö kuvaavaan matriisiin.
     *
     * @param toBePlaced Merkki jota ollaa lisäämässä matriisiin
     * @param n Lisäyspaikan korkeuskoordinaatti matriisissa.
     * @param m Lisäyspaikan leveyskoordinaatti matriisissa.
     */
    public void placeCharacterIntoMatrix(char toBePlaced, int n, int m) {
        placementMatrix[n][m] = toBePlaced;
    }

    /**
     * Metodilla tyhjennetään paikkamatriisista tietty lokero.
     *
     * @param n Lokeron korkeuskoordinaatti matriisissa.
     * @param m Lokeron leveyskoordinaatti matriisissa.
     */
    public void deleteMatrixNode(int n, int m) {
        placementMatrix[n][m] = ' ';
    }

    /**
     * Metodilla poistetaan paikkamatriisista tietty merkki ja korvataan se
     * välilyönnillä.
     *
     * @param toBeDeleted Poistettava merkki
     */
    public void deleteCharacterFromMatrix(char toBeDeleted) {
        for (int n = 0; n < placementMatrix.length; n++) {
            for (int m = 0; m < placementMatrix[n].length; m++) {
                if (placementMatrix[n][m] == toBeDeleted) {
                    placementMatrix[n][m] = ' ';
                    return;
                }
            }
        }
    }
}
