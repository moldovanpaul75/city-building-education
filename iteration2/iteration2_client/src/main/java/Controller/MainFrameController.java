package Controller;

import Client.Client;
import Model.District;
import Model.Tile;
import Model.TileType;
import View.*;

import java.util.List;

/**
 * This class is the controller that initializez the tile map panel and tile sheet panel with the tiles from the database.
 */
public class MainFrameController{

    private MainFrame mainFrame;
    private Client client;

    private List<TileType> tileTypeList;
    private List<Tile> tileList;
    private List<District> districtList;

    /**
     * This method initializes the current window's console logger, tile map panel, tile sheet panel and layout manager.
     */
    public void initializeMainFrame() {
        //set mainframe controller
        this.mainFrame.setController(this);

        //initialize loggerconsole and buttonspanel
        LoggerConsole loggerConsole = new LoggerConsole();
        ButtonsPanel buttonsPanel = new ButtonsPanel(this.mainFrame);
        this.mainFrame.setLoggerConsole(loggerConsole);
        this.mainFrame.setButtonsPanel(buttonsPanel);

        //get number of tile columns and rows
        int cols = tileList.get(tileList.size() - 1).getxCoord() + 1;
        int rows = tileList.get(tileList.size() - 1).getyCoord() + 1;

        //initialize tilesheet and tilemap
        TileSheetPanel tileSheet = new TileSheetPanel(32, 32, 2, this.tileTypeList.size() / 2, this.tileTypeList);
        TilePanel tilePanel = new TilePanel(this.mainFrame, 32, 32, cols, rows, this.tileList);
        tilePanel.setTileSheet(tileSheet);
        this.mainFrame.setTileSheet(tileSheet);
        this.mainFrame.setTilePanel(tilePanel);

        //create and set TileInfoPanel
        TileInfoPanel tileInfoPanel = new TileInfoPanel(this.mainFrame);
        this.mainFrame.setTileInfoPanel(tileInfoPanel);

        //initialize layoutmanager
        LayoutManager manager = new LayoutManager(mainFrame);
        manager.initializeLayout();
        this.mainFrame.setLayoutManager(manager);
    }

    /**
     *
     * @return Returns the main window.
     */
    public MainFrame getMainFrame() {
        return this.mainFrame;
    }

    /**
     * This method sets the current main window.
     * @param mainFrame
     */
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setTileTypeList(List<TileType> tileTypeList){
        this.tileTypeList = tileTypeList;
    }

    public void setTileList(List<Tile> tileList){
        this.tileList = tileList;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public Client getClient(){
        return this.client;
    }

    public List<TileType> getTileTypeList(){
        return this.tileTypeList;
    }

    public List<Tile> getTileList(){
        return this.tileList;
    }

    public Tile getTileById(int id){
        return this.tileList.get(id);
    }

    public void setTileById(int id, Tile newTile){
        this.tileList.set(id, newTile);
    }

    public void setDistrictList(List<District> districtList){
        this.districtList = districtList;
    }

    public List<District> getDistrictList(){
        return this.districtList;
    }
//    /**
//     * This method sets the current rule logger.
//     * @param rulesLogger
//     */
//    public void setRulesLogger(RulesLogger rulesLogger){ this.rulesLogger = rulesLogger; }

    //    /**
//     *
//     * @return Returns the logger console.
//     */
//    public RulesLogger getRulesLogger(){
//        return this.rulesLogger;
//    }
}
