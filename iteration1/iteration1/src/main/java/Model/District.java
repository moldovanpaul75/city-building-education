package Model;

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
    private int districtId;

    @Column(name = "name", nullable = false)
    private String districtName;

    @Column(name = "xStart", nullable = false)
    private int xStart;

    @Column(name = "xEnd", nullable = false)
    private int xEnd;

    @Column(name = "yStart", nullable = false)
    private int yStart;

    @Column(name = "yEnd", nullable = false)
    private int yEnd;

    @ManyToOne
    @JoinColumn(name = "city", nullable = false)
    private City city;

    @OneToMany(mappedBy = "district")
    private List<Tile> tiles = new ArrayList<Tile>();

    /**
     *
     * @param id
     */
    public void setDistrictId(int id) {
        this.districtId = id;
    }

    /**
     *
     * @return
     */
    public int getDistrictId() {
        return this.districtId;
    }

    /**
     *
     * @param city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public City getCity() {
        return this.city;
    }

    /**
     *
     * @param name
     */
    public void setDistrictName(String name) {
        this.districtName = name;
    }

    /**
     *
     * @return
     */
    public String getDistrictName() {
        return this.districtName;
    }

    /**
     *
     * @param xStart
     */
    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    /**
     *
     * @return
     */
    public int getxStart() {
        return this.xStart;
    }

    /**
     *
     * @param xEnd
     */
    public void setxEnd(int xEnd) {
        this.xEnd = xEnd;
    }

    /**
     *
     * @return
     */
    public int getxEnd() {
        return this.xEnd;
    }

    /**
     *
     * @param yStart
     */
    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    /**
     *
     * @return
     */
    public int getyStart() {
        return this.yStart;
    }

    /**
     *
     * @param yEnd
     */
    public void setyEnd(int yEnd) {
        this.yEnd = yEnd;
    }

    /**
     *
     * @return
     */
    public int getyEnd() {
        return this.yEnd;
    }

    /**
     *
     * @return
     */
    public List<Tile> getTiles() {
        return this.tiles;
    }

    /**
     *
     * @param tiles
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
