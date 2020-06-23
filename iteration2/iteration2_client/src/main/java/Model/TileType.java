package Model;

import com.google.gson.annotations.Expose;


public class TileType {

    @Expose(serialize = true, deserialize = true)
    private int tileTypeId;

    @Expose(serialize = true, deserialize = true)
    private String tileName;

    @Expose(serialize = true, deserialize = true)
    private int rating;

    @Expose(serialize = true, deserialize = true)
    private String iconPath;

    @Expose(serialize = true, deserialize = true)
    private int pollutionLevel;

    @Expose(serialize = true, deserialize = true)
    private LayerType layerType;

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