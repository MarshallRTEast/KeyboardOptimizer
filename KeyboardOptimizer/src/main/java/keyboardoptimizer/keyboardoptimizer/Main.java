package keyboardoptimizer.keyboardoptimizer;

import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        
//        System.out.println("Toimi jo saatana");
//        System.out.println("Hölömörkö");
//        System.out.println("There has been an outlawed Boogaloo in my nest, that is to say, in my BUTT.");
//        
        HashMap<Character, Integer> mapOfKeys = new HashMap<Character, Integer>();
        String keys = "ABCDEF";
        for (int i = 0; i < keys.length(); i++) {
            mapOfKeys.put(keys.charAt(i), 5 + 2 * i);
        }
        
        Keyboard defaultKeyboard = new Keyboard(mapOfKeys, keys);
//        System.out.println(defaultKeyboard);
//        defaultKeyboard.printPlacementMatrix();
        defaultKeyboard.placeCharacterIntoMatrix('A', 1, 7);
        defaultKeyboard.printPlacementMatrix();
//        
//        Keyboard keyboard = new Keyboard();
//        
//        keyboard.setOneKeyAmountUsingIndex(0, 10);
//        keyboard.setOneKeyAmountUsingIndex(2, 5);
//        keyboard.setOneKeyAmountUsingIndex(3, 1);
//        
//        System.out.println(keyboard);
//        
    }
}
