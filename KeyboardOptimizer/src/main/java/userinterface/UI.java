/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author Hanskat
 */
public class UI implements Runnable {

    private JFrame frame;

    public UI() {
    }

    // luo tällähetkellä 1000x700 käyttöliittymän, jolla ei toiminnallisuutta
    // miten toteutetaan Keyboardin lukeminen ja muokkaaminen käyttöliittymään?
    @Override
    public void run() {
        frame = new JFrame("KeyboardOptimizer");
        frame.setPreferredSize(new Dimension(1000, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }
    //tarvitaan moneta eri containeria sisäkkäin
    public void createComponents(Container container) {
        // BorderLayout pitää korvata käytettävällä layoutilla.
        container.setLayout(new BorderLayout());
        container.add(new InputAndChoiceField(container), BorderLayout.EAST);

    }

    public JFrame getFrame() {
        return frame;
    }
    
}
