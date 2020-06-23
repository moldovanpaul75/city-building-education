package Model;

import com.google.gson.annotations.Expose;

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
    @Expose(serialize = true, deserialize = true)
    private int addressId;

    @Column(name = "address", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private String address;

    @Column(name = "zipcode", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private String zipcode;

    @OneToOne(mappedBy = "address")
    @Expose(serialize = false, deserialize = false)
    private TileInfo tileInfo;

    /**
     *
     * @param id the id of the address
     */
    public void setAddressId(int id) {
        this.addressId = id;
    }

    /**
     *
     * @return Returns the id of the address
     */
    public int getAddressId() {
        return this.addressId;
    }

    /**
     *
     * @param zipcode the zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     *
     * @return Returns the zipcode
     */
    public String getZipcode() {
        return this.zipcode;
    }

    /**
     *
     * @param address the address as string
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return Returns the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     *
     * @param tileInfo a tileInfo object
     */
    public void setTileInfo(TileInfo tileInfo) {
        this.tileInfo = tileInfo;
    }

    /**
     *
     * @return Returns the tileinfo of the address
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
