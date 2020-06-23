package Model;

import javax.persistence.*;

/**
 * This class represents a tile info entity
 */
@Entity
@Table(name = "tileInfo")
public class TileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int tileInfoId;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "availability", nullable = false)
    private int availability;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact")
    private Contact contact;

    @OneToOne(mappedBy = "tileInfo")
    private Tile tile;

    /**
     *
     * @param tileInfoId
     */
    public void setTileInfoId(int tileInfoId) {
        this.tileInfoId = tileInfoId;
    }

    /**
     *
     * @return
     */
    public int getTileInfoId() {
        return this.tileInfoId;
    }

    /**
     *
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     *
     * @return
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     *
     * @param availability
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     *
     * @return
     */
    public int getAvailability() {
        return this.availability;
    }

    /**
     *
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     *
     * @param contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     *
     * @return
     */
    public Contact getContact() {
        return this.contact;
    }

    @Override
    public String toString() {
        return "TileInfo{" +
                "id=" + this.tileInfoId +
                ", capacity=" + this.capacity +
                ", availability=" + this.availability + "}";
    }
}
