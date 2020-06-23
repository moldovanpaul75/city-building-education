package Model;

import javax.persistence.*;

/**
 * This class represents a tile entity
 */
@Entity
@Table(name = "tile")
public class Tile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int tileId;

    @Column(name = "xCoord", nullable = false)
    private int xCoord;

    @Column(name = "yCoord", nullable = false)
    private int yCoord;

    @ManyToOne
    @JoinColumn(name = "tileType")
    private TileType tileType;

    @OneToOne
    @JoinColumn(name = "tileInfo")
    private TileInfo tileInfo;

    @ManyToOne
    @JoinColumn(name = "district")
    private District district;

    /**
     *
     * @param tileId
     */
    public void setTileId(int tileId) {
        this.tileId = tileId;
    }

    /**
     *
     * @return
     */
    public int getTileId() {
        return this.tileId;
    }

    /**
     *
     * @param xCoord
     */
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     *
     * @return
     */
    public int getxCoord() {
        return this.xCoord;
    }

    /**
     *
     * @param yCoord
     */
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    /**
     *
     * @return
     */
    public int getyCoord() {
        return this.yCoord;
    }

    /**
     *
     * @param tileType
     */
    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    /**
     *
     * @return
     */
    public TileType getTileType() {
        return this.tileType;
    }

    /**
     *
     * @param tileInfo
     */
    public void setTileInfo(TileInfo tileInfo) {
        this.tileInfo = tileInfo;
    }

    /**
     *
     * @return
     */
    public TileInfo getTileInfo() {
        return this.tileInfo;
    }

    /**
     *
     * @return
     */
    public District getDistrict() {
        return this.district;
    }

    /**
     * s
     * @param district
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