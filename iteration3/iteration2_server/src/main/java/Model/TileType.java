package Model;

import com.google.gson.annotations.Expose;

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
    @Expose(serialize = true, deserialize = true)
    private int tileTypeId;

    @Column(name = "name", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private String tileName;

    @Column(name = "rating", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private int rating;

    @Column(name = "iconPath", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private String iconPath;

    @Column(name = "pollutionLevel", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private int pollutionLevel;

    @ManyToOne
    @JoinColumn(name = "layer", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private LayerType layerType;

    @OneToMany(mappedBy = "tileType", cascade = CascadeType.ALL)
    @Expose(serialize = false, deserialize = false)
    private List<Tile> tiles = new ArrayList<Tile>();

    /**
     *
     * @return Returns a list of tiles of this type
     */
    public List<Tile> getTiles() {
        return this.tiles;
    }

    /**
     *
     * @param tiles a list of tiles of this type
     */
    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    /**
     *
     * @param id the id of the tile type
     */
    public void setTileTypeId(int id) {
        this.tileTypeId = id;
    }

    /**
     *
     * @return Returns the id of the tile type
     */
    public int getTileTypeId() {
        return this.tileTypeId;
    }

    /**
     *
     * @param name the name of the tile type
     */
    public void setTileName(String name) {
        this.tileName = name;
    }

    /**
     *
     * @return Returns the name of the tile type
     */
    public String getTileName() {
        return this.tileName;
    }

    /**
     *
     * @param layerType layer type
     */
    public void setLayerType(LayerType layerType) {
        this.layerType = layerType;
    }

    /**
     *
     * @return Returns the layer type
     */
    public LayerType getLayerType() {
        return this.layerType;
    }

    /**
     *
     * @param rating this type's raiting
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     *
     * @return Returns this type's raiting
     */
    public int getRating() {
        return this.rating;
    }

    /**
     *
     * @param path iconpath
     */
    public void setIconPath(String path) {
        this.iconPath = path;
    }

    /**
     *
     *
     * @return Returns the iconpath
     */
    public String getIconPath() {
        return this.iconPath;
    }

    /**
     *
     * @return Returns the pollution level
     */
    public int getPollutionLevel() {
        return this.pollutionLevel;
    }

    /**
     *
     * @param pollutionLevel the pollution level
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