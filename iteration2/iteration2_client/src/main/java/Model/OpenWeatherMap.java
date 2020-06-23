package Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class OpenWeatherMap {

    private final String API_KEY = "af5110ea6a440345571bce2b4333b23e";

    public Map<String, Object> getWeather(String location) {
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&APPID=" + API_KEY + "&units=metric";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
            br.close();

            Map<String, Object> respMap = new Gson().fromJson(stringBuilder.toString(), new TypeToken<HashMap<String, Object>>() {}.getType());
            return respMap;
        } catch (IOException e) {
            return null;
        }
    }
}
