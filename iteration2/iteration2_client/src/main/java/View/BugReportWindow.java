package View;

import Controller.BugReportListener;

import javax.swing.*;
import java.awt.*;

public class BugReportWindow extends JFrame{

    private MainFrame parentFrame;

    private JTextField bugNameTextField;
    private JTextField bugTypeTextField;
    private JTextField clientEmailTextField;
    private JTextArea bugDescriptionTextArea;

    public BugReportWindow(MainFrame mainFrame){
        this.parentFrame = mainFrame;
        this.setTitle("BugReport");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new SpringLayout());

        JButton reportButton = new JButton("Submit bug");
        JLabel bugName = new JLabel("Bug name:");
        JLabel bugType = new JLabel("Bug type:");
        JLabel bugDesc = new JLabel("Bug description:");
        JLabel clientEmail = new JLabel("Client email:");

        this.bugNameTextField = new JTextField(10);
        this.bugTypeTextField = new JTextField(10);
        this.clientEmailTextField = new JTextField(10);
        this.bugDescriptionTextArea = new JTextArea(5, 10);
        JScrollPane bugDescScrollPane = new JScrollPane(bugDescriptionTextArea);

        jPanel.add(bugName);
        bugName.setLabelFor(bugNameTextField);
        jPanel.add(bugNameTextField);

        jPanel.add(bugType);
        bugType.setLabelFor(bugTypeTextField);
        jPanel.add(bugTypeTextField);

        jPanel.add(bugDesc);
        bugDesc.setLabelFor(bugDescScrollPane);
        jPanel.add(bugDescScrollPane);

        jPanel.add(clientEmail);
        clientEmail.setLabelFor(clientEmailTextField);
        jPanel.add(clientEmailTextField);

        reportButton.addActionListener(new BugReportListener(this));
        jPanel.add(reportButton);

        SpringUtilities.makeCompactGrid(jPanel, 4, 2, 6, 6, 6, 6);


        this.setContentPane(jPanel);
        this.pack();
        this.setVisible(true);
    }

    public MainFrame getParentFrame(){
        return this.parentFrame;
    }

    public String getBugName(){
        return this.bugNameTextField.getText();
    }

    public String getBugType(){
        return this.bugTypeTextField.getText();
    }

    public String getBugDescription(){
        return this.bugDescriptionTextArea.getText();
    }

    public String getClientEmail(){
        return this.clientEmailTextField.getText();
    }
}
