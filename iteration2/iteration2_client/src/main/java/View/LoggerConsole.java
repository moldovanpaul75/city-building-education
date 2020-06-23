package View;


import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 *  This class represents the text console, extends JTextArea and implements Observer receive new building rules and print them.
 */
public class LoggerConsole extends JTextArea implements Observer {

    public LoggerConsole(){
        this.setEditable(false);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.append((String) arg + "\n");
    }
}
