package Common;

import Business.*;
import DataAccess.*;
import Presentation.MainFrame;
import Presentation.TilePanel;
import Presentation.TileSheet;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Tile[][] tiles = new TileDataMapper().getAllTiles(20, 20);
        ArrayList<TileType> tileTypes = new TileTypeDataMapper().getAllTileTypes();

        MainFrame frame = new MainFrame();
        TilePanel panel = new TilePanel(tiles, 20, 20, 25);
        TileSheet sheet = new TileSheet(tileTypes);

        frame.add(panel);
        frame.add(sheet);
        frame.setVisible(true);
    }
}
