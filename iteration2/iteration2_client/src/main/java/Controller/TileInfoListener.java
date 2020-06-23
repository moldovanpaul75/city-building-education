package Controller;

import Model.*;
import View.TileInfoPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;

public class TileInfoListener extends Observable implements ActionListener {

    private TileInfoPanel tileInfoPanel;

    public TileInfoListener(TileInfoPanel tileInfoPanel){
        this.tileInfoPanel = tileInfoPanel;
        this.addObserver(tileInfoPanel.getParentFrame().getController().getClient());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = tileInfoPanel.getSelectedTileIndex();
        if (index != -1) {
            TileInfo tileInfo = new TileInfo();
            Tile tile = tileInfoPanel.getParentFrame().getController().getTileById(index);

            String district = tileInfoPanel.getDistrict().trim();
            if(!district.equals("")) {
                if (tile.getDistrict() == null || !tile.getDistrict().getDistrictName().equals(district)) {
                    List<District> districtList = tileInfoPanel.getParentFrame().getController().getDistrictList();
                    District district1 = null;
                    for (District d : districtList) {
                        if (d.getDistrictName().equals(district)) district1 = d;
                    }
                    if (district1 != null) {
                        int x = tile.getxCoord();
                        int y = tile.getyCoord();
                        if (x >= district1.getxStart() && x <= district1.getxEnd() && y >= district1.getyStart() && y <= district1.getyEnd()) {
                            tile.setDistrict(district1);
                            this.tileInfoPanel.getParentFrame().getLoggerConsole().append("Updated district for tile: " + tile.toString() + "   to  " + tile.getDistrict().toString() + "\n");
                            this.setChanged();
                            this.notifyObservers(tile);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Place is not in this district.", "Bad input", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "District does not exists.", "Bad input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }

            String addressInfo = tileInfoPanel.getAddress().trim();
            if (!addressInfo.equals("")) {
                Address address = new Address();
                address.setAddress(addressInfo);

                String zipCode = tileInfoPanel.getZipCode().trim();
                if (!zipCode.equals("")) {
                    address.setZipcode(zipCode);

                    tileInfo.setAddress(address);
                }
            }

            String email = tileInfoPanel.getEmail().trim();
            if (!email.equals("")) {
                Contact contact = new Contact();
                contact.setEmail(email);

                String phone = tileInfoPanel.getPhone().trim();
                if (!phone.equals("")) {
                    contact.setTelephoneNb(phone);

                    String website = tileInfoPanel.getWebsite().trim();
                    contact.setWebsite(website);

                    tileInfo.setContact(contact);
                }
            }


            String capacity = tileInfoPanel.getCapacity().trim();
            if(!capacity.equals("")){
                tileInfo.setCapacity(Integer.parseInt(capacity));

                String availability = tileInfoPanel.getAvailability().trim();
                if(!availability.equals("")){
                    tileInfo.setAvailability(Integer.parseInt(availability));

                    tile.setTileInfo(tileInfo);
                    this.tileInfoPanel.getParentFrame().getLoggerConsole().append("Updated tile info for tile: " + tile.toString() + "  to  " + tile.getTileInfo().toString() + "\n");
                    this.setChanged();
                    this.notifyObservers(tile);
                }
            }
        }
    }
}
