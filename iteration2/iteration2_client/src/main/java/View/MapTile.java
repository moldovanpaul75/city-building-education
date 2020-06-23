package View;

import Controller.MapTileListener;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents a single tile on the tile map as a JLabel.
 */
public class MapTile extends JLabel {

    private TilePanel parentTilePanel;
    private Image image;
    private Image blankTile;
    private int index;
    private int tileLayerId;
    private int tileTypeId;
    private boolean hovered;
    private int xCoord, yCoord;


    public MapTile(ImageIcon image, TilePanel tilePanel, int index, int tileLayerId, int tileTypeId, int xCoord, int yCoord) {
        super(image);
        this.image = image.getImage();
        this.tileLayerId = tileLayerId;
        this.index = index;
        this.hovered = false;
        this.parentTilePanel = tilePanel;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.tileTypeId = tileTypeId;

        int tileHeight = parentTilePanel.getTileHeight();
        int tileWidth = parentTilePanel.getTileWidth();

        ImageIcon imageIcon = new ImageIcon("img/blankTile.png");
        this.blankTile = imageIcon.getImage().getScaledInstance(tileWidth, tileHeight, Image.SCALE_DEFAULT);
        imageIcon.setImage(blankTile);
        this.setIcon(imageIcon);
        
        this.addMouseListener(new MapTileListener(this));
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (parentTilePanel.getSelectedLayer() != -1) {
            if (parentTilePanel.getSelectedLayer() == this.tileLayerId){
                g.drawImage(this.image, 0, 0, this);
            }
            else {
                g.drawImage(this.blankTile, 0, 0, this);
            }
        } else {
            g.drawImage(this.image, 0, 0, this);
        }
        if (hovered) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
    }

    /**
     * This method colors this tile red if the mouse hovers over it and recolors the last hovered tile back to transparent.
     * @param hover a boolean variable that is true if the mouse hovered over the tile and false if not.
     */
    public void hoverTile(boolean hover) {
        int last = parentTilePanel.getLastHovered();

        if (last != -1) {
            parentTilePanel.getTile(last).setHovered(false);
            parentTilePanel.getTile(last).repaint();
        }
        if (hover) {
            parentTilePanel.setLastHovered(this.index);
            parentTilePanel.getTile(this.index).setHovered(true);
            parentTilePanel.getTile(this.index).repaint();
        } else {
            parentTilePanel.setLastHovered(-1);
        }
    }

    /**
     * This method sets this tile to hovered or not.
     * @param hovered a boolean varibale that is true if mouse hovered over the tile and false if not.
     */
    public void setHovered(boolean hovered) {
        this.hovered = hovered;
    }

    /**
     *
     * @return Returns the hover status of this tile, true if mouse is on it or false if not.
     */
    public boolean getHovered() {
        return this.hovered;
    }

    /**
     * This method sets the layer id of this tile.
     * @param tileLayerId the layer id
     */
    public void setLayerId(int tileLayerId) {
        this.tileLayerId = tileLayerId;
    }

    /**
     *
     * @return Returns the layer id of this tile.
     */
    public int getLayerId() {
        return this.tileLayerId;
    }

    /**
     *  This method draws a tilesheet into the tile map.
     */
    public void drawTile(){
        this.image = parentTilePanel.getTileSheet().getSelectedTile().getImage();
        this.tileLayerId = parentTilePanel.getTileSheet().getSelectedTile().getLayerId();
        this.tileTypeId = parentTilePanel.getTileSheet().getSelectedTile().getTileTypeId();
        this.repaint();
    }

    /**
     * This method sets this tile's image.
     * @param image an Image
     */
    public void setImage(Image image){
        this.image = image;
    }

    /**
     *
     * @return Returns the image of this tile.
     */
    public Image getImage(){
        return this.image;
    }

    /**
     *
     * @return Returns the parent tile map of this tile.
     */
    public TilePanel getParentTilePanel(){
        return this.parentTilePanel;
    }

    /**
     * This method sets this tile's parent panel.
     * @param tilePanel the parent tile map
     */
    public void setParentTilePanel(TilePanel tilePanel){
        this.parentTilePanel = tilePanel;
    }

    /**
     *
     * @return Returns the x coordonate of this tile.
     */
    public int getxCoord(){
        return this.xCoord;
    }

    /**
     *
     * @return Returns the y coordonate of this tile.
     */
    public int getyCoord(){
        return this.yCoord;
    }

    /**
     *
     * @return Returns the index of this tile.
     */
    public int getIndex() { return  this.index; }

    public void setTileTypeId(int tileTypeId){
        this.tileTypeId = tileTypeId;
    }

    public int getTileTypeId(){
        return this.tileTypeId;
    }
}