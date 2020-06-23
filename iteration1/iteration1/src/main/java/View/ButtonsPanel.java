package View;

import Controller.ButtonsPanelListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *  This class represents the button panel
 */
public class ButtonsPanel extends JPanel {

    private MainFrame parentFrame;

    public ButtonsPanel(MainFrame mainFrame){
        this.parentFrame = mainFrame;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JRadioButton jRadioButton1 = new JRadioButton ("Land layer");
        JRadioButton jRadioButton2 = new JRadioButton ("Hydro layer");
        JRadioButton jRadioButton3 = new JRadioButton ("Places layer");
        JRadioButton jRadioButton4 = new JRadioButton("All layers", true);

        ButtonGroup group = new ButtonGroup();
        group.add(jRadioButton1);
        group.add(jRadioButton2);
        group.add(jRadioButton3);
        group.add(jRadioButton4);

        jRadioButton1.addActionListener(new ButtonsPanelListener(jRadioButton1, parentFrame, 1));
        jRadioButton2.addActionListener(new ButtonsPanelListener(jRadioButton2, parentFrame, 2));
        jRadioButton3.addActionListener(new ButtonsPanelListener(jRadioButton3, parentFrame, 3));
        jRadioButton4.addActionListener(new ButtonsPanelListener(jRadioButton4, parentFrame, -1));

        this.add(jRadioButton1);
        this.add(jRadioButton2);
        this.add(jRadioButton3);
        this.add(jRadioButton4);


        JTextArea textArea = new JTextArea(5, 10);
        textArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane);

        JButton addRule = new JButton("Add new rule");
        addRule.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = textArea.getText().trim();
                if(!data.equals("")){
                    parentFrame.getController().getRulesLogger().writeRule(data);
                }
            }
        });
        this.add(addRule);

        JButton getRules = new JButton("View all rules");
        getRules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.getLoggerConsole().append(parentFrame.getController().getRulesLogger().readRules());
            }
        });
        this.add(getRules);
    }
}
