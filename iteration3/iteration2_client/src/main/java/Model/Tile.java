package Model;

import com.google.gson.annotations.Expose;

public class Tile {

    @Expose(serialize = true, deserialize = true)
    private int tileId;

    @Expose(serialize = true, deserialize = true)
    private int xCoord;

    @Expose(serialize = true, deserialize = true)
    private int yCoord;

    @Expose(serialize = true, deserialize = true)
    private TileType tileType;

    @Expose(serialize = true, deserialize = true)
    private TileInfo tileInfo;

    @Expose(serialize = true, deserialize = true)
    private District district;

    /**
     *
     * @param tileId the id of this tile
     */
    public void setTileId(int tileId) {
        this.tileId = tileId;
    }

    /**
     *
     * @return Returns the id of this tile
     */
    public int getTileId() {
        return this.tileId;
    }

    /**
     *
     * @param xCoord x coordonate of this tile
     */
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     *
     * @return Returns the x coordonate of this tile
     */
    public int getxCoord() {
        return this.xCoord;
    }

    /**
     *
     * @param yCoord y coordonate of this tile
     */
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    /**
     *
     * @return Returns the y coordonate of this tile
     */
    public int getyCoord() {
        return this.yCoord;
    }

    /**
     *
     * @param tileType this tile's type
     */
    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    /**
     *
     * @return Returns this tile's type
     */
    public TileType getTileType() {
        return this.tileType;
    }

    /**
     *
     * @param tileInfo this tile's info
     */
    public void setTileInfo(TileInfo tileInfo) {
        this.tileInfo = tileInfo;
    }

    /**
     *
     * @return Returns this tile's info
     */
    public TileInfo getTileInfo() {
        return this.tileInfo;
    }

    /**
     *
     * @return Returns this tile's district
     */
    public District getDistrict() {
        return this.district;
    }

    /**
     *
     * @param district this tile's district
     */
    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "id=" + this.tileId +
                ", x=" + this.xCoord +
                ", y=" + this.yCoord + "}";
    }
}