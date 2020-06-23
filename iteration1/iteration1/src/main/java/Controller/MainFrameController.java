package Controller;

import Model.Repository;
import Model.RulesLogger;
import Model.Tile;
import Model.TileType;
import View.*;

import java.util.List;

/**
 * This class is the controller that initializez the tile map panel and tile sheet panel with the tiles from the database.
 */
public class MainFrameController {

    private MainFrame mainFrame;
    private Repository repository;
    private RulesLogger rulesLogger;

    private List<TileType> tileTypeList;
    private List<Tile> tileList;


    /**
     * This method initializes the current window's console logger, tile map panel, tile sheet panel and layout manager.
     */
    public void initializeMainFrame() {
        //set mainframe controller
        this.mainFrame.setController(this);

        //initialize loggerconsole and buttonspanel
        LoggerConsole loggerConsole = new LoggerConsole();
        this.rulesLogger.addObserver(loggerConsole);
        ButtonsPanel buttonsPanel = new ButtonsPanel(this.mainFrame);
        this.mainFrame.setLoggerConsole(loggerConsole);
        this.mainFrame.setButtonsPanel(buttonsPanel);

        //get tiles and tiletypes from db
        this.tileTypeList = this.repository.findAll(TileType.class);
        this.tileList = this.repository.findAll(Tile.class);
        int cols = tileList.get(tileList.size() - 1).getxCoord() + 1;
        int rows = tileList.get(tileList.size() - 1).getyCoord() + 1;

        //initialize tilesheet and tilemap
        TileSheetPanel tileSheet = new TileSheetPanel(32, 32, 2, tileTypeList.size() / 2, tileTypeList);
        TilePanel tilePanel = new TilePanel(32, 32, cols, rows, tileList);
        tilePanel.setTileSheet(tileSheet);
        tilePanel.setParentFrame(this.mainFrame);
        this.mainFrame.setTileSheet(tileSheet);
        this.mainFrame.setTilePanel(tilePanel);

        //initialize layoutmanager
        LayoutManager manager = new LayoutManager(mainFrame);
        manager.initializeLayout();
        mainFrame.setLayoutManager(manager);
    }

    /**
     *
     * @return Returns the repository.
     */
    public Repository getRepository() {
        return this.repository;
    }

    /**
     *
     * @return Returns the main window.
     */
    public MainFrame getMainFrame() {
        return this.mainFrame;
    }

    /**
     *
     * @return Returns the logger console.
     */
    public RulesLogger getRulesLogger(){
        return this.rulesLogger;
    }

    /**
     * This method sets the current Repository.
     * @param repository
     */
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    /**
     * This method sets the current main window.
     * @param mainFrame
     */
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * This method sets the current rule logger.
     * @param rulesLogger
     */
    public void setRulesLogger(RulesLogger rulesLogger){ this.rulesLogger = rulesLogger; }
}
