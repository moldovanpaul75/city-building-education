package Business;

public class TileType {
    private int tileTypeId;
    private LayerType layerType;
    private String tileName;
    private int rating;
    private String iconPath;

    public TileType(int id, LayerType layerType, String tileName, int rating, String iconPath) {
        this.tileTypeId = id;
        this.layerType = layerType;
        this.tileName = tileName;
        this.rating = rating;
        this.iconPath = iconPath;
    }

    public void setTileTypeId(int id) {
        this.tileTypeId = id;
    }

    public int getTileTypeId() {
        return this.tileTypeId;
    }

    public void setTileName(String name) {
        this.tileName = name;
    }

    public String getTileName() {
        return this.tileName;
    }

    public void setLayerType(LayerType layerType) {
        this.layerType = layerType;
    }

    public LayerType getLayerType() {
        return this.layerType;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

    public void setIconPath(String path) {
        this.iconPath = path;
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public String toString() {
        return "tile type: " + this.tileTypeId + " " + this.tileName + " " + this.rating + " " + this.iconPath + "\n" + this.layerType;
    }
}
