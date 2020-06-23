package Controller;

import Model.Tile;
import View.MainFrame;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchBarListener implements ActionListener {

    private MainFrame parentFrame;
    private JTextField searchBar;


    public SearchBarListener(MainFrame mainFrame, JTextField searchBar) {
        this.parentFrame = mainFrame;
        this.searchBar = searchBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String toSearch = searchBar.getText().trim();
        if (!toSearch.equals("")) {
            if (toSearch.startsWith("/search")) {
                List<Tile> tileList = parentFrame.getController().getTileList();
                boolean found = false;
                toSearch = toSearch.substring(7).trim();
                for (Tile t : tileList) {
                    if (t.getTileType().getTileName().equals(toSearch)) {
                        found = true;
                        parentFrame.getLoggerConsole().append("Place found on: " + t.toString() + " in district " + t.getDistrict().getDistrictName() + " from city " + t.getDistrict().getCity().getCityName() + ".\n");
                    }
                }
                if (!found) {
                    parentFrame.getLoggerConsole().append("Place: " + toSearch + " could not be found.\n");
                }
            } else {
                if (toSearch.startsWith("/weather")) {
                    toSearch = toSearch.substring(8).trim();
                    Map<String, Object> map = parentFrame.getController().getClient().getOpenWeatherMap().getWeather(toSearch);

                    if (map != null) {
                        Gson gson = new Gson();
                        Map<String, Object> mainMap = gson.fromJson(map.get("main").toString(), new TypeToken<HashMap<String, Object>>() {}.getType());
                        Map<String, Object> cloudsMap = gson.fromJson(map.get("clouds").toString(), new TypeToken<HashMap<String, Object>>() {}.getType());

                        parentFrame.getLoggerConsole().append(
                                "Weather for: " + map.get("name") + "\n" +
                                        "Temperature: " + mainMap.get("temp_min") + " to " + mainMap.get("temp_max") + " °С\n" +
                                        "Pressure: " + mainMap.get("pressure") + "\n" +
                                        "Humidity: " + mainMap.get("humidity") + "\n" +
                                        "Clouds: " + cloudsMap.get("all") + "%\n");
                    } else {
                        parentFrame.getLoggerConsole().append("Location not found.\n");
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Use:\n/weather <location> for current weather\n/search <place> to search a place", "Bad input", JOptionPane.WARNING_MESSAGE);
                }
            }
            searchBar.setText("");
        }
    }
}
