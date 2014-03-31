/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardoptimizer.keyboardoptimizer;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author Hanskat
 */
// luokka käyttöliittymän alueelle, johon asetetaan haluttu tiedosto ja keyset, sekä suoritusnappui
public class InputAndChoiceField extends JPanel {

    public InputAndChoiceField(Container container) {
//        super(new BoxLayout(container, HEIGHT));
        super(new GridLayout(6,1));
        createComponents();
    }
    
    
    private void createComponents() {
        JButton createKeyboard = new JButton("Create");
        JTextArea filePath = new JTextArea();
        JTextArea keysToBeReadFromFile = new JTextArea();
        JRadioButton useCustomKeysButton = new JRadioButton("Use custom keys");
        
        try {
        createKeyboard.addActionListener(new CreateKeyboardButton());
        } catch (Exception e) {
            
        }
        
        add(new JLabel("File:"));
        add(filePath);
        add(new JLabel("Keyset:"));
        add(useCustomKeysButton);
        add(keysToBeReadFromFile);
        add(createKeyboard);
    }
}
