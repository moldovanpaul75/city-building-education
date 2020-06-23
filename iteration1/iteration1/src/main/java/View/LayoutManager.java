package View;

import javax.swing.*;
import java.awt.*;

/**
 *  This class manages the main window layout.
 */
public class LayoutManager {

    private final float TILE_SHEET_PANEL_RATIO = 0.15f;

    private MainFrame parentFrame;
    private JScrollPane tilePanelScrollPane;
    private JScrollPane tileSheetScrollPane;
    private JScrollPane loggerConsoleScrollPane;


    public LayoutManager(MainFrame mainFrame) {
        this.parentFrame = mainFrame;
    }

    /**
     * This method initializes the layout.
     */
    public void initializeLayout() {
        tilePanelScrollPane = new JScrollPane(parentFrame.getTilePanel());
        tilePanelScrollPane.setBorder(BorderFactory.createTitledBorder("TileMap"));

        tileSheetScrollPane = new JScrollPane(parentFrame.getTileSheet());
        tileSheetScrollPane.setMinimumSize(new Dimension((int)(parentFrame.getWidth() * TILE_SHEET_PANEL_RATIO), parentFrame.getHeight() / 2));
        tileSheetScrollPane.setBorder(BorderFactory.createTitledBorder("TileSheet"));

        loggerConsoleScrollPane = new JScrollPane(parentFrame.getLoggerConsole());
        loggerConsoleScrollPane.setBorder(BorderFactory.createTitledBorder("LoggerConsole"));

        //GridBagLayout constraints
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1; //request any extra vertical space
        c.gridheight = 2;
        c.gridwidth = 1; //1 columns wide
        c.gridx = 0;  //first column
        c.gridy = 0;  //first row
        c.fill = GridBagConstraints.BOTH;

        //add tilemap panel
        parentFrame.add(tilePanelScrollPane, c);
        parentFrame.validate();

        //constraints for tilesheet panel
        c.weightx = 0;
        c.weighty = 1;
        c.gridheight = 2;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 0;
        //add tilesheet panel
        parentFrame.add(tileSheetScrollPane, c);
        parentFrame.validate();

        //constraints for console logger
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 2;
        //add console logger panel
        parentFrame.add(loggerConsoleScrollPane, c);
        parentFrame.validate();

        //constraints for buttons panel
        c.weightx = 0;
        c.weighty = 1;
        c.gridheight = 2;
        c.gridwidth = 0;
        c.gridx = 2;
        c.gridy = 0;
        c.ipadx = 20;
        //add buttons panel
        parentFrame.add(parentFrame.getButtonsPanel(), c);
        parentFrame.validate();

        parentFrame.repaint();
        parentFrame.setVisible(true);
    }

    /**
     * This method clears the layout.
     */
    public void clearLayout() {
        tilePanelScrollPane.removeAll();
        tileSheetScrollPane.removeAll();
        loggerConsoleScrollPane.removeAll();
        parentFrame.remove(loggerConsoleScrollPane);
        parentFrame.remove(tileSheetScrollPane);
        parentFrame.remove(tilePanelScrollPane);
    }
}
