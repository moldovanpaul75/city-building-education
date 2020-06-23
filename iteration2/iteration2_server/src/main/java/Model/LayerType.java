package Model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a layer type entity
 */
@Entity
@Table(name = "layerType")
public class LayerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Expose(serialize = true, deserialize = true)
    private int layerId;

    @Column(name = "name", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private String layerName;

    @OneToMany(mappedBy = "layerType", cascade = CascadeType.ALL)
    @Expose(serialize = false, deserialize = false)
    private List<TileType> tileTypes = new ArrayList<TileType>();

    /**
     *
     * @return Returns the id of the layer
     */
    public int getLayerId() {
        return this.layerId;
    }

    /**
     *
     * @param layerId the id of the layer
     */
    public void setLayerId(int layerId) {
        this.layerId = layerId;
    }

    /**
     *
     * @return Returns the name of the layer
     */
    public String getLayerName() {
        return this.layerName;
    }

    /**
     *
     * @param layerName the layer's name
     */
    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    /**
     *
     * @return Returns a list of tile types from this layer
     */
    public List<TileType> getTileTypes() {
        return this.tileTypes;
    }

    /**
     *
     * @param tileTypes a list of tile types
     */
    public void setTileTypes(List<TileType> tileTypes) {
        this.tileTypes = tileTypes;
    }

    @Override
    public String toString() {
        return "LayerType{" +
                "id=" + this.layerId +
                ", name=" + this.layerName + "}";
    }
}
