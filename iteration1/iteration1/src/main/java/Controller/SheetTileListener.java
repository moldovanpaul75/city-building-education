package Controller;

import View.SheetTile;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class represents a mouse listener that we assign to a tile from the tile sheet.
 */
public class SheetTileListener implements MouseListener {

    private SheetTile parentSheetTile;

    public SheetTileListener(SheetTile sheetTile){
        this.parentSheetTile = sheetTile;
    }

    /**
     * This method selects the tile this listener is assigned to if the tile is clicked on.
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 1){
            parentSheetTile.selectTile(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
