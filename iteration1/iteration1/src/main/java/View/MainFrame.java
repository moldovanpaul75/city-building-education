package View;

import Controller.MainFrameController;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the main window of the UI.
 */
public class MainFrame extends JFrame {

    public static final int FRAME_WIDTH = 1600;
    public static final int FRAME_HEIGHT = 900;
    public static final int MINIMUM_WIDTH = 800;
    public static final int MINIMUM_HEIGHT = 600;

    private TilePanel tilePanel;
    private TileSheetPanel tileSheet;
    private LayoutManager layoutManager;
    private LoggerConsole loggerConsole;
    private ButtonsPanel buttonsPanel;

    private MainFrameController controller;

    public MainFrame() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
        setTitle("City Building Education - Iteration1");
        setLayout(new GridBagLayout());
    }

    /**
     *
     * @return returns current layourManager
     */
    public LayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    /**
     *
     * @return returns current tilePanel
     */
    public TilePanel getTilePanel() {
        return this.tilePanel;
    }

    /**
     *
     * @return returns current tileSheet
     */
    public TileSheetPanel getTileSheet() {
        return this.tileSheet;
    }

    /**
     *
     * @return returns current loggerConsole
     */
    public LoggerConsole getLoggerConsole(){
        return this.loggerConsole;
    }

    /**
     *
     * @return returns current buttonsPanel
     */
    public ButtonsPanel getButtonsPanel(){
        return this.buttonsPanel;
    }

    /**
     *
     * @return returns current controller
     */
    public MainFrameController getController(){
        return this.controller;
    }

    /**
     * This method sets the mainframe's layout manager.
     * @param layoutManager
     */
    public void setLayoutManager(LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    /**
     *  This method sets mainframe's tile panel.
     * @param tilePanel
     */
    public void setTilePanel(TilePanel tilePanel) {
        this.tilePanel = tilePanel;
    }

    /**
     * This method sets mainframe's tile sheet.
     * @param tileSheet
     */
    public void setTileSheet(TileSheetPanel tileSheet) {
        this.tileSheet = tileSheet;
    }

    /**
     * This method sets mainframe's logger console.
     * @param loggerConsole
     */
    public void setLoggerConsole(LoggerConsole loggerConsole){
        this.loggerConsole = loggerConsole;
    }

    /**
     * This method sets mainframe's buttons panel.
     * @param buttonsPanel
     */
    public void setButtonsPanel(ButtonsPanel buttonsPanel){
        this.buttonsPanel = buttonsPanel;
    }

    /**
     * This method sets mainframe's controller.
     * @param controller
     */
    public void setController(MainFrameController controller){
        this.controller = controller;
    }
}
