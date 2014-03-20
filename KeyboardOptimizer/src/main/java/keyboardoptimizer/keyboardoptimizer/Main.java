package keyboardoptimizer.keyboardoptimizer;


public class Main {

    public static void main(String[] args) {
        
        Keyboard keyboard = new Keyboard();
        
        keyboard.setOneKeyAmountUsingIndex(0, 10);
        keyboard.setOneKeyAmountUsingIndex(2, 5);
        keyboard.setOneKeyAmountUsingIndex(3, 1);
        
        System.out.println(keyboard);
        
    }
}
