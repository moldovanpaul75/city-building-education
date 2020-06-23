package Model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a city entity
 */
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Expose(serialize = true, deserialize = true)
    private int cityId;

    @Column(name = "name", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private String cityName;

    @Column(name = "latitude", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private float latitude;

    @Column(name = "longitude", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private float longitude;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    @Expose(serialize = false, deserialize = false)
    private List<District> districts = new ArrayList<District>();

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

    /**
     *
     * @return Returns the list of district in the city
     */
    public List<District> getDistricts() {
        return this.districts;
    }

    /**
     *
     * @param districts a list of districts
     */
    public void setDistricts(List<District> districts) {
        this.districts = districts;
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
