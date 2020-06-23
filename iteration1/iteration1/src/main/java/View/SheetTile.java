package View;

import Controller.SheetTileListener;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents a single tile on the tile sheet as a JLabel.
 */
public class SheetTile extends JLabel {

    private TileSheetPanel parentTileSheetPanel;
    private Image image;
    private int index;
    private boolean selected;
    private int tileLayerId;

    public SheetTile(ImageIcon image, TileSheetPanel tileSheetPanel, int index, int layerId){
        super(image);
        this.image = image.getImage();
        this.index = index;
        this.parentTileSheetPanel = tileSheetPanel;
        this.selected = false;
        this.tileLayerId = layerId;

        this.addMouseListener(new SheetTileListener(this));
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        if (selected) {
            g2.setStroke(new BasicStroke(5));
            g2.setColor(Color.RED);
            g2.drawRect(0, 0, this.parentTileSheetPanel.getTileWidth(), this.parentTileSheetPanel.getTileHeight());
        }
        g2.dispose();
    }

    /**
     * This method sets this tile as selected and deselected of last one.
     * @param sel boolean variable that is true of selected and false if not
     */
    public void selectTile(boolean sel){
        int last = parentTileSheetPanel.getLastSelected();

        if(last != -1){
            parentTileSheetPanel.getTile(last).setSelected(false);
            parentTileSheetPanel.getTile(last).repaint();
        }
        if(sel){
            parentTileSheetPanel.setLastSelected(this.index);
            parentTileSheetPanel.getTile(this.index).setSelected(true);
            parentTileSheetPanel.getTile(this.index).repaint();
        }else{
            parentTileSheetPanel.setLastSelected(-1);
        }
        parentTileSheetPanel.setSelectedTile(this);
    }

    /**
     *
     * @return Returns the selected status of this tile.
     */
    public boolean getSelected(){
        return this.selected;
    }

    /**
     * This method sets the selected status of this tile.
     * @param select boolean variable that is true if selected and false if not
     */
    public void setSelected(boolean select){
        this.selected = select;
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
     * This method sets the layer id of this tile.
     * @param layerId the layer id
     */
    public void setLayerId(int layerId) {
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
     * This method sets the index of this tile.
     * @param index the index
     */
    public void setIndex(int index){
        this.index = index;
    }

    /**
     *
     * @return Returns the index of this tile.
     */
    public int getIndex(){
        return this.index;
    }
}
