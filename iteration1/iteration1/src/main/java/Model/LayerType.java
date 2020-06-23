package Model;

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
    private int layerId;

    @Column(name = "name", nullable = false)
    private String layerName;

    @OneToMany(mappedBy = "layerType", cascade = CascadeType.ALL)
    private List<TileType> tileTypes = new ArrayList<TileType>();

    /**
     *
     * @return
     */
    public int getLayerId() {
        return this.layerId;
    }

    /**
     *
     * @param layerId
     */
    public void setLayerId(int layerId) {
        this.layerId = layerId;
    }

    /**
     *
     * @return
     */
    public String getLayerName() {
        return this.layerName;
    }

    /**
     *
     * @param layerName
     */
    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    /**
     *
     * @return
     */
    public List<TileType> getTileTypes() {
        return this.tileTypes;
    }

    /**
     *
     * @param tileTypes
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
