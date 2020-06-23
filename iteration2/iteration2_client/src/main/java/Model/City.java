package Model;

import com.google.gson.annotations.Expose;


public class City {

    @Expose(serialize = true, deserialize = true)
    private int cityId;

    @Expose(serialize = true, deserialize = true)
    private String cityName;

    @Expose(serialize = true, deserialize = true)
    private float latitude;

    @Expose(serialize = true, deserialize = true)
    private float longitude;

    /**
     *
     * @param id the id of the city
     */
    public void setCityId(int id) {
        this.cityId = id;
    }

    /**
     *
     * @return Returns the id of the city
     */
    public int getCityId() {
        return this.cityId;
    }

    /**
     *
     * @param name the name of the city
     */
    public void setCityName(String name) {
        this.cityName = name;
    }

    /**
     *
     * @return Returns the name of the city
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     *
     * @param latitude city's latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @param longitude city's longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return Returns the latitude of the city
     */
    public float getLatitude() {
        return this.latitude;
    }

    /**
     *
     * @return Return the longitude of the city
     */
    public float getLongitude() {
        return this.longitude;
    }


    @Override
    public String toString() {
        return "City{" +
                "id=" + this.cityId +
                ", name=" + this.cityName +
                ", latitude=" + this.latitude +
                ", longitude=" + this.longitude + "}";
    }
}

