package keyboardoptimizer.keyboardoptimizer;


public class Main {

    public static void main(String[] args) {
        
        Keyboard keyboard = new Keyboard();
        keyboard.setOneKeyAmountUsingIndex(0, 10);
        keyboard.setOneKeyAmountUsingIndex(2, 15);
        System.out.println("lol");
        System.out.println(keyboard.getAmount('A'));
        System.out.println(keyboard);
        System.out.println("end");
        
    }
}
