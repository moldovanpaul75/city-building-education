package Model;

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
    private int cityId;

    @Column(name = "name", nullable = false)
    private String cityName;

    @Column(name = "latitude", nullable = false)
    private float latitude;

    @Column(name = "longitude", nullable = false)
    private float longitude;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<District> districts = new ArrayList<District>();

    /**
     *
     * @param id
     */
    public void setCityId(int id) {
        this.cityId = id;
    }

    /**
     *
     * @return
     */
    public int getCityId() {
        return this.cityId;
    }

    /**
     *
     * @param name
     */
    public void setCityName(String name) {
        this.cityName = name;
    }

    /**
     *
     * @return
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     *
     * @param latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @param longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     */
    public float getLatitude() {
        return this.latitude;
    }

    /**
     *
     * @return
     */
    public float getLongitude() {
        return this.longitude;
    }

    /**
     *
     * @return
     */
    public List<District> getDistricts() {
        return this.districts;
    }

    /**
     *
     * @param districts
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
