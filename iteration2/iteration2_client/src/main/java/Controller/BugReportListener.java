package Controller;

import Model.Bug;
import View.BugReportWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BugReportListener implements ActionListener {

    private BugReportWindow bugReportWindow;

    public BugReportListener(BugReportWindow bugReportWindow){
        this.bugReportWindow = bugReportWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeString = format.format(new Date());
        Bug bug = new Bug();


        String bugName = this.bugReportWindow.getBugName().trim();
        if(!bugName.equals("")){
            bug.setBugName(bugName);

            String bugType = this.bugReportWindow.getBugType().trim();
            if(!bugType.equals("")){
                bug.setBugType(bugType);

                String bugDescription = this.bugReportWindow.getBugDescription().trim();
                if(!bugDescription.equals("")){
                    bug.setBugDescription(bugDescription);

                    String clientEmail = this.bugReportWindow.getClientEmail().trim();
                    if(!clientEmail.equals("")){
                        bug.setClientEmail(clientEmail);

                        bug.setReportTime(timeString);
                        this.bugReportWindow.getParentFrame().getController().getClient().reportBug(bug);
                        this.bugReportWindow.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "Email field cannot de empty.", "Bad input", JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Bug description field cannot de empty.", "Bad input", JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,
                        "Bug type field cannot de empty.", "Bad input", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,
                    "Bug name field cannot de empty.", "Bad input", JOptionPane.WARNING_MESSAGE);
        }
    }
}
