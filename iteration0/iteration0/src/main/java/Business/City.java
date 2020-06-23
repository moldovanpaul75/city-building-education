package Business;

public class City {
    private int cityId;
    private String cityName;
    private float cityLat;
    private float cityLon;

    public City(int id, String name, float lat, float lon) {
        this.cityId = id;
        this.cityName = name;
        this.cityLat = lat;
        this.cityLon = lon;
    }

    public City(String name, float lat, float lon) {
        this.cityName = name;
        this.cityLat = lat;
        this.cityLon = lon;
    }

    public void setCityId(int id) {
        this.cityId = id;
    }

    public int getCityId() {
        return this.cityId;
    }

    public void setCityName(String name) {
        this.cityName = name;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityLat(float lat) {
        this.cityLat = lat;
    }

    public void setCityLon(float lon) {
        this.cityLon = lon;
    }

    public float getCityLat() {
        return this.cityLat;
    }

    public float getCityLon() {
        return this.cityLon;
    }

    public String toString() {
        return "city: " + this.cityId + " " + this.cityName + " " + this.cityLat + " " + this.cityLon;
    }
}
