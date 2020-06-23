package Model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a district entity
 */
@Entity
@Table(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Expose(serialize = true, deserialize = true)
    private int districtId;

    @Column(name = "name", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private String districtName;

    @Column(name = "xStart", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private int xStart;

    @Column(name = "xEnd", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private int xEnd;

    @Column(name = "yStart", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private int yStart;

    @Column(name = "yEnd", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private int yEnd;

    @ManyToOne
    @JoinColumn(name = "city", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private City city;

    @OneToMany(mappedBy = "district")
    @Expose(serialize = false, deserialize = false)
    private List<Tile> tiles = new ArrayList<Tile>();

    /**
     *
     * @param id the id of the district
     */
    public void setDistrictId(int id) {
        this.districtId = id;
    }

    /**
     *
     * @return Returns the id of the district
     */
    public int getDistrictId() {
        return this.districtId;
    }

    /**
     *
     * @param city the city this district is from
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     *
     * @return Returns the district's city
     */
    public City getCity() {
        return this.city;
    }

    /**
     *
     * @param name the name of the district
     */
    public void setDistrictName(String name) {
        this.districtName = name;
    }

    /**
     *
     * @return Returns the name of the district
     */
    public String getDistrictName() {
        return this.districtName;
    }

    /**
     *
     * @param xStart x coordonate start
     */
    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    /**
     *
     * @return Returns the x coordonate start
     */
    public int getxStart() {
        return this.xStart;
    }

    /**
     *
     * @param xEnd x coordonate end
     */
    public void setxEnd(int xEnd) {
        this.xEnd = xEnd;
    }

    /**
     *
     * @return Returns the x coordonate end
     */
    public int getxEnd() {
        return this.xEnd;
    }

    /**
     *
     * @param yStart y coordonate start
     */
    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    /**
     *
     * @return Returns y coordonate start
     */
    public int getyStart() {
        return this.yStart;
    }

    /**
     *
     * @param yEnd y coordonate end
     */
    public void setyEnd(int yEnd) {
        this.yEnd = yEnd;
    }

    /**
     *
     * @return Returns y coordonate end
     */
    public int getyEnd() {
        return this.yEnd;
    }

    /**
     *
     * @return Returns the list of tiles this district is contains
     */
    public List<Tile> getTiles() {
        return this.tiles;
    }

    /**
     *
     * @param tiles a list of tiles
     */
    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + this.districtId +
                ", name=" + this.districtName +
                " x[" + this.xStart + " ," + this.xEnd + "] y[" + this.yStart + " ," + this.yEnd + "]}";
    }
}
