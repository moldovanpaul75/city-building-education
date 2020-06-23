package Business;

public class Tile {
    private int tileId;
    private int xCoord;
    private int yCoord;
    private TileType tileType;
    private TileInfo tileInfo;

    public Tile(int tileId, int xCoord, int yCoord, TileType tileType) {
        this.tileId = tileId;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.tileType = tileType;
    }

    public Tile(int tileId, int xCoord, int yCoord) {
        this.tileId = tileId;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Tile(int tileId, int xCoord, int yCoord, TileType tileType, TileInfo tileInfo) {
        this.tileId = tileId;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.tileType = tileType;
        this.tileInfo = tileInfo;
    }

    public void setTileId(int tileId) {
        this.tileId = tileId;
    }

    public int getTileId() {
        return this.tileId;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getxCoord() {
        return this.xCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getyCoord() {
        return this.yCoord;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    public TileType getTileType() {
        return this.tileType;
    }

    public void setTileInfo(TileInfo tileInfo) {
        this.tileInfo = tileInfo;
    }

    public TileInfo getTileInfo() {
        return this.tileInfo;
    }

    public String toString() {
        return "tile: " + this.tileId + " x:" + this.xCoord + " y:" + this.yCoord;
    }
}
