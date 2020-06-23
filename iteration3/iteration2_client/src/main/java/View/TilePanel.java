package View;

import Model.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the tile map as a compact grid of labels where each tile is JLabel.
 */
public class TilePanel extends JPanel {

    private MainFrame parentFrame;
    private TileSheetPanel tileSheet;

    private int tileHeight, tileWidth;
    private SpringLayout springLayout;
    private ArrayList<MapTile> tiles;
    private int lastHovered;
    private int selectedLayer;

    public TilePanel(MainFrame mainFrame, int tileHeight, int tileWidth, int panelCols, int panelRows, List<Tile> tileList) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.lastHovered = -1;
        this.selectedLayer = -1;
        this.tiles = new ArrayList<MapTile>();
        this.parentFrame = mainFrame;

        tileList.forEach(t -> {
            ImageIcon imageIcon;
            Image image;
            imageIcon = new ImageIcon(t.getTileType().getIconPath());
            image = imageIcon.getImage().getScaledInstance(this.tileWidth, this.tileHeight, Image.SCALE_DEFAULT);
            imageIcon.setImage(image);
            MapTile tile = new MapTile(imageIcon, this, t.getTileId() - 1, t.getTileType().getLayerType().getLayerId(), t.getTileType().getTileTypeId(), t.getxCoord(), t.getyCoord());
            this.tiles.add(tile);
            this.add(tile);
        });

        //using springloyout to force the layout to become a compact label grid
        this.springLayout = new SpringLayout();
        setLayout(springLayout);
        SpringUtilities.makeGrid(this, panelRows, panelCols, 0, 0, 0, 0);
    }

    public void updateTile(Tile tile){
        ImageIcon imageIcon;
        Image image;
        imageIcon = new ImageIcon(tile.getTileType().getIconPath());
        image = imageIcon.getImage().getScaledInstance(this.tileWidth, this.tileHeight, Image.SCALE_DEFAULT);
        imageIcon.setImage(image);

        int index = tile.getTileId()-1;
        tiles.get(index).setImage(imageIcon.getImage());
        tiles.get(index).setLayerId(tile.getTileType().getLayerType().getLayerId());
        tiles.get(index).setTileTypeId(tile.getTileType().getTileTypeId());
        tiles.get(index).repaint();
    }

    /**
     *
     * @return Returns the height of a single tile.
     */
    public int getTileHeight() {
        return this.tileHeight;
    }

    /**
     *
     * @return Returns the width of a single tile.
     */
    public int getTileWidth() {
        return this.tileWidth;
    }

    /**
     * This method sets the height of a single tile.
     * @param tileHeight tile height
     */
    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    /**
     * This method sets the width of a single tile.
     * @param tileWidth tile width
     */
    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    /**
     *
     * @param index given index of the tile
     * @return Returns the tile at the given index.
     */
    public MapTile getTile(int index) {
        return tiles.get(index);
    }

    /**
     * This method sets a new tile to the give index.
     * @param index given index of the tile
     * @param tile the new tile
     */
    public void setTile(int index, MapTile tile) {
        tiles.set(index, tile);
    }

    /**
     * This method is used to save last hovered tile index.
     * @param index tile index
     */
    public void setLastHovered(int index) {
        this.lastHovered = index;
    }

    /**
     *
     * @return Returns the index of last hovered tile.
     */
    public int getLastHovered() {
        return this.lastHovered;
    }

    /**
     * This method repaints all the tiles from the tile list.
     */
    public void repaintAllTiles() {
        tiles.forEach(t->{
            t.repaint();
        });
    }

    /**
     *
     * @return Returns the selected tile layer.
     */
    public int getSelectedLayer() {
        return this.selectedLayer;
    }

    /**
     * This method sets the current selected layer id and repaints all the tiles.
     * @param layer selected layer id
     */
    public void setSelectedLayer(int layer) {
        if(this.selectedLayer != layer) {
            this.selectedLayer = layer;
            this.repaintAllTiles();
        }
    }

    /**
     * This methos sets the tile sheet associated with this tile map.
     * @param tileSheet the tile sheet panel
     */
    public void setTileSheet(TileSheetPanel tileSheet){
        this.tileSheet = tileSheet;
    }

    /**
     *
     * @return Returns the tile sheet of this tile map.
     */
    public TileSheetPanel getTileSheet(){
        return this.tileSheet;
    }

    /**
     * This method sets the parent window of this tile map panel.
     * @param mainFrame main window
     */
    public void setParentFrame(MainFrame mainFrame){
        this.parentFrame = mainFrame;
    }

    /**
     *
     * @return Returns the parent window of the tile map panel.
     */
    public MainFrame getParentFrame(){
        return this.parentFrame;
    }
}