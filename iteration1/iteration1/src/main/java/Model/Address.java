package Model;

import javax.persistence.*;

/**
 * This class represents an address entity
 */
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int addressId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @OneToOne(mappedBy = "address")
    private TileInfo tileInfo;

    /**
     *
     * @param id
     */
    public void setAddressId(int id) {
        this.addressId = id;
    }

    /**
     *
     * @return
     */
    public int getAddressId() {
        return this.addressId;
    }

    /**
     *
     * @param zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     *
     * @return
     */
    public String getZipcode() {
        return this.zipcode;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return this.address;
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

    @Override
    public String toString() {
        return "Address{" +
                "id=" + this.addressId +
                ", address=" + this.address +
                ", zipcode=" + this.zipcode + "}";
    }
}
