package Controller;

import Client.Client;
import Model.Tile;
import Model.TileType;
import View.MapTile;
import View.TileInfoPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

/**
 * This class represents a mouse listener that we assign to a tile from the tile panel map.
 */
public class MapTileListener extends Observable implements MouseListener{

    private MapTile parentTile;

    public MapTileListener(MapTile parentTile){
        this.parentTile = parentTile;
        this.addObserver(this.parentTile.getParentTilePanel().getParentFrame().getController().getClient());
    }

    /**
     * This method repaints the tile with a new tile from tile sheet panel(if one is selected) if we double-click on it.
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            if (this.parentTile.getParentTilePanel().getTileSheet().getLastSelected() != -1) {
                this.parentTile.drawTile();

                //get selected tiletype
                int index = this.parentTile.getParentTilePanel().getTileSheet().getSelectedTile().getIndex();
                TileType newTileType = this.parentTile.getParentTilePanel().getParentFrame().getController().getTileTypeList().get(index);
                //create new tile and send it to client
                int tileIndex = this.parentTile.getIndex();
                Tile newTile = this.parentTile.getParentTilePanel().getParentFrame().getController().getTileById(tileIndex);
                newTile.setTileType(newTileType);
                //this.parentTile.getParentTilePanel().getParentFrame().getController().setTileById(tileIndex, newTile);

                setChanged();
                notifyObservers(newTile);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            int tileIndex = this.parentTile.getIndex();
            Tile tile = this.parentTile.getParentTilePanel().getParentFrame().getController().getTileById(tileIndex);
            TileInfoPanel tileInfoPanel = this.parentTile.getParentTilePanel().getParentFrame().getTileInfoPanel();

            tileInfoPanel.setSelectedTileIndex(tileIndex);
            tileInfoPanel.setRating(String.valueOf(tile.getTileType().getRating()));
            tileInfoPanel.setPollutionLevel(String.valueOf(tile.getTileType().getPollutionLevel()));
            if (tile.getDistrict() != null) {
                if (tile.getDistrict().getCity() != null)
                    tileInfoPanel.setCity(tile.getDistrict().getCity().getCityName());
                tileInfoPanel.setDistrict(tile.getDistrict().getDistrictName());
            } else {
                tileInfoPanel.setCity("");
                tileInfoPanel.setDistrict("");
            }
            if (tile.getTileInfo() != null) {
                tileInfoPanel.setCapacity(String.valueOf(tile.getTileInfo().getCapacity()));
                tileInfoPanel.setAvailability(String.valueOf(tile.getTileInfo().getAvailability()));
                if (tile.getTileInfo().getAddress() != null) {
                    tileInfoPanel.setAddress(tile.getTileInfo().getAddress().getAddress());
                    tileInfoPanel.setZipCode(tile.getTileInfo().getAddress().getZipcode());
                }
                if (tile.getTileInfo().getContact() != null) {
                    tileInfoPanel.setPhone(tile.getTileInfo().getContact().getTelephoneNb());
                    tileInfoPanel.setEmail(tile.getTileInfo().getContact().getEmail());
                    if (tile.getTileInfo().getContact().getWebsite() != null) {
                        tileInfoPanel.setWebsite(tile.getTileInfo().getContact().getWebsite());
                    }
                }
            }else{
                tileInfoPanel.setAddress("");
                tileInfoPanel.setZipCode("");
                tileInfoPanel.setPhone("");
                tileInfoPanel.setEmail("");
                tileInfoPanel.setWebsite("");
                tileInfoPanel.setCapacity("");
                tileInfoPanel.setAvailability("");
            }
            this.parentTile.getParentTilePanel().getParentFrame().getLoggerConsole().append(tile.toString()+"\n");

        }
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
            this.parentTile.hoverTile(true);
            //parentTile.getParentTilePanel().getParentFrame().getLoggerConsole().append("x= " + parentTile.getxCoord() + ", y=" + parentTile.getyCoord() + ", tileLayerId= "+ parentTile.getLayerId() + "\n");
        }
    }

    /**
     * This method tells the tiles that the mouse left the tile panel window.
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        this.parentTile.hoverTile(false);
    }

}
