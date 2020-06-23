package View;

import Controller.SearchBarListener;

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
    private JScrollPane tileInfoScrollPane;

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
        tileSheetScrollPane.setMinimumSize(new Dimension((int) (parentFrame.getWidth() * TILE_SHEET_PANEL_RATIO), (int) (parentFrame.getHeight() / 3.6)));
        tileSheetScrollPane.setBorder(BorderFactory.createTitledBorder("TileSheet"));

        loggerConsoleScrollPane = new JScrollPane(parentFrame.getLoggerConsole());
        //loggerConsoleScrollPane.setBorder(BorderFactory.createTitledBorder("LoggerConsole"));

        tileInfoScrollPane = new JScrollPane(parentFrame.getTileInfoPanel());
        tileInfoScrollPane.setBorder(BorderFactory.createTitledBorder("TileInfo"));

        JPanel consolePanel = new JPanel();
        consolePanel.setBorder(BorderFactory.createTitledBorder("LoggerConsole"));
        consolePanel.setLayout(new GridBagLayout());
        JTextField searchBar = new JTextField();
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchBarListener(parentFrame, searchBar));
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.fill = GridBagConstraints.BOTH;
        c1.gridx=0;
        c1.gridy=0;
        c1.weightx = 1;
        c1.weighty = 1;
        consolePanel.add(loggerConsoleScrollPane, c1);

        c1.gridx=0;
        c1.gridy=1;
        c1.weightx = 0;
        c1.weighty = 0;
        c1.gridwidth = 1;
        c1.ipadx = 20;
        consolePanel.add(searchButton, c1);

        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridx=1;
        c1.gridy=1;
        c1.weightx = 1;
        c1.weighty = 0;
        c1.ipady = 10;
        c1.ipadx = 0;
        consolePanel.add(searchBar, c1);


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
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 0;
        //add tilesheet panel
        parentFrame.add(tileSheetScrollPane, c);
        parentFrame.validate();

        //constraints for tileinfo panel
        c.weightx = 0;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        c.ipady = 180;
        parentFrame.add(tileInfoScrollPane, c);
        parentFrame.validate();

        //constraints for console logger
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 0;
        c.ipady = 0;
        //add console logger panel
        parentFrame.add(consolePanel, c);
        parentFrame.validate();

        //constraints for buttons panel
        c.weightx = 0;
        c.weighty = 1;
        c.gridheight = 2;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 0;
        c.ipadx = 20;
        c.ipady = 0;
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
