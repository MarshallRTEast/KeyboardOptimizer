package logic;

import java.util.HashMap;
import javax.swing.SwingUtilities;
import userinterface.UserInterface;

public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }
}
