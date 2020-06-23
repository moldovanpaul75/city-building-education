package Controller;

import View.MapTile;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class represents a mouse listener that we assign to a tile from the tile panel map.
 */
public class MapTileListener implements MouseListener{

    private MapTile parentTile;

    public MapTileListener(MapTile parentTile){
        this.parentTile = parentTile;
    }

    /**
     * This method repaints the tile with a new tile from tile sheet panel(if one is selected) if we double-click on it.
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            if (parentTile.getParentTilePanel().getTileSheet().getLastSelected() != -1) {
                parentTile.drawTile();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * This method managed the hoverover system. If the mouse is in the tile map panel it sets the hovered over status of the tile it is on,
     * prints the coordonates of the tile into the logger console.
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getModifiers() != 16) {
            parentTile.hoverTile(true);
            parentTile.getParentTilePanel().getParentFrame().getLoggerConsole().append("x= " + parentTile.getxCoord() + ", y=" + parentTile.getyCoord() + "\n");
        }
    }

    /**
     * This method tells the tiles that the mouse left the tile panel window.
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        parentTile.hoverTile(false);
    }

}
