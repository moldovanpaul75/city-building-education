package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LayerType {

    @Expose(serialize = true, deserialize = true)
    private int layerId;

    @Expose(serialize = true, deserialize = true)
    private String layerName;

    @Expose(serialize = true, deserialize = true)
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