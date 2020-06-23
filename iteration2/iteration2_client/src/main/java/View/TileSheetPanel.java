package View;


import Model.TileType;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * This class represents the tile sheet from where we select a tile and we draw it into the tile map.
 */
public class TileSheetPanel extends JPanel {

    private int tileHeight, tileWidth;
    private ArrayList<SheetTile> tileTypes;
    private SpringLayout springLayout;
    private SheetTile selectedTile;
    private int lastSelected;

    public TileSheetPanel(int tileHeight, int tileWidth, int panelCols, int panelRows, List<TileType> tileTypeList) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.tileTypes = new ArrayList<SheetTile>();
        this.lastSelected = -1;

        ImageIcon imageIcon;
        Image image;
        for (int i = 0; i < panelCols * panelRows; i++) {

            imageIcon = new ImageIcon(tileTypeList.get(i).getIconPath());
            image = imageIcon.getImage().getScaledInstance(this.tileWidth, this.tileHeight, Image.SCALE_DEFAULT);
            imageIcon.setImage(image);

            SheetTile tile = new SheetTile(imageIcon, this, i, tileTypeList.get(i).getLayerType().getLayerId(), tileTypeList.get(i).getTileTypeId());
            tileTypes.add(tile);
            this.add(tile);
        }

        this.springLayout = new SpringLayout();
        setLayout(springLayout);
        SpringUtilities.makeGrid(this, panelRows, panelCols, 2, 0, 75, 5);
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
    public void setTileWidth(int tileWidth){
        this.tileWidth = tileWidth;
    }

    /**
     * This method is used to save last selected tile index.
     * @param index tile index
     */
    public void setLastSelected(int index){
        this.lastSelected = index;
    }

    /**
     *
     * @return Returns the index of last selected tile.
     */
    public int getLastSelected(){
        return this.lastSelected;
    }

    /**
     *
     * @param index tile index
     * @return Returns the tile from the tile sheet at the given index
     */
    public SheetTile getTile(int index){
        return this.tileTypes.get(index);
    }

    /**
     * This method sets a new tile to the give index.
     * @param index given index of the tile
     * @param tile the new tile
     */
    public void setTile(int index, SheetTile tile){
        this.tileTypes.set(index, tile);
    }

    /**
     * This method is used to keep track of current selected tile on the tile sheet.
     * @param tile current selected tile
     */
    public void setSelectedTile(SheetTile tile){
        this.selectedTile = tile;
    }

    /**
     *
     * @return Returns the current selected tile from the tile sheet.
     */
    public SheetTile getSelectedTile(){
        return this.selectedTile;
    }
}
