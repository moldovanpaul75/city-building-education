package Controller;

import View.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the action listener to the buttons we use to select the current layer we view in the tile map panel.
 */
public class ButtonsPanelListener implements ActionListener {

    private JRadioButton jRadioButton;
    private MainFrame parentFrame;
    private int layerIndex;

    public ButtonsPanelListener(JRadioButton jRadioButton, MainFrame mainFrame, int layerIndex) {
        this.jRadioButton = jRadioButton;
        this.parentFrame = mainFrame;
        this.layerIndex = layerIndex;
    }


    /**
     * If a layer button is selected then we repaint only the tiles from that layer and print into the logger console a message.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jRadioButton.isSelected()) {
            if( this.parentFrame.getTilePanel().getSelectedLayer() != this.layerIndex) {
                this.parentFrame.getTilePanel().setSelectedLayer(this.layerIndex);
                this.parentFrame.getTilePanel().repaintAllTiles();
                this.parentFrame.getLoggerConsole().append("Layer selected: " + jRadioButton.getText() + "\n");
            }
        }
    }
}
