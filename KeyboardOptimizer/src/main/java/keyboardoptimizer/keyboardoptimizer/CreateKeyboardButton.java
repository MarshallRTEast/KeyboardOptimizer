/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardoptimizer.keyboardoptimizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 *
 * @author Hanskat
 */
// täytyy ehkä nimetä uudelleen tarvittaessa, pitää selvittää ensin mitä kaikkea toiminnallisuutta tänne tulee
public class CreateKeyboardButton implements ActionListener {

    private KeyboardGenerator keyboardGenerator;
    // tarpeellisia nämä kaksi?
    private JTextArea filePath;
    private JTextArea keysToBeRead;

    // saa tekstikentästä filepathin parametrikseen, pitäisi hakea KeyboardGeneratoria ja tuottaa muutokset UI:hin
    // miten saa Stringin irti JTextAreasta?
    // pitää muistaa kattoa Exceptionit!
    public CreateKeyboardButton() throws Exception {
    }

    public CreateKeyboardButton(JTextArea filePath) throws Exception {
        this.keyboardGenerator = new KeyboardGenerator(filePath.getText());
    }

    public CreateKeyboardButton(JTextArea filePath, JTextArea keysToBeRead) throws Exception {
        this.keyboardGenerator = new KeyboardGenerator(filePath.getText(), keysToBeRead.getText());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("LEL =D");;
    }
}
