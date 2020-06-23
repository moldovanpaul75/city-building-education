package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a tile type entity
 */
@Entity
@Table(name = "tileType")
public class TileType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int tileTypeId;

    @Column(name = "name", nullable = false)
    private String tileName;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "iconPath", nullable = false)
    private String iconPath;

    @Column(name = "pollutionLevel", nullable = false)
    private int pollutionLevel;

    @ManyToOne
    @JoinColumn(name = "layer", nullable = false)
    private LayerType layerType;

    @OneToMany(mappedBy = "tileType", cascade = CascadeType.ALL)
    private List<Tile> tiles = new ArrayList<Tile>();

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

    /**
     *
     * @param id
     */
    public void setTileTypeId(int id) {
        this.tileTypeId = id;
    }

    /**
     *
     * @return
     */
    public int getTileTypeId() {
        return this.tileTypeId;
    }

    /**
     *
     * @param name
     */
    public void setTileName(String name) {
        this.tileName = name;
    }

    /**
     *
     * @return
     */
    public String getTileName() {
        return this.tileName;
    }

    /**
     *
     * @param layerType
     */
    public void setLayerType(LayerType layerType) {
        this.layerType = layerType;
    }

    /**
     *
     * @return
     */
    public LayerType getLayerType() {
        return this.layerType;
    }

    /**
     *
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    public int getRating() {
        return this.rating;
    }

    /**
     *
     * @param path
     */
    public void setIconPath(String path) {
        this.iconPath = path;
    }

    /**
     *
     *
     * @return
     */
    public String getIconPath() {
        return this.iconPath;
    }

    /**
     *
     * @return
     */
    public int getPollutionLevel() {
        return this.pollutionLevel;
    }

    /**
     *
     * @param pollutionLevel
     */
    public void setPollutionLevel(int pollutionLevel) {
        this.pollutionLevel = pollutionLevel;
    }

    @Override
    public String toString() {
        return "TileType{" +
                "id=" + this.tileTypeId +
                ", name=" + this.tileName +
                ", rating=" + this.rating +
                ", pollutionLevel=" + this.pollutionLevel +
                ", iconPath=" + this.iconPath + "}";
    }
}