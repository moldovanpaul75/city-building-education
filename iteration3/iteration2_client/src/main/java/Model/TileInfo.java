package Model;

import com.google.gson.annotations.Expose;

public class TileInfo {

    @Expose(serialize = true, deserialize = true)
    private int tileInfoId;

    @Expose(serialize = true, deserialize = true)
    private int capacity;

    @Expose(serialize = true, deserialize = true)
    private int availability;

    @Expose(serialize = true, deserialize = true)
    private Address address;

    @Expose(serialize = true, deserialize = true)
    private Contact contact;


    /**
     *
     * @param tileInfoId the id of the tileinfo
     */
    public void setTileInfoId(int tileInfoId) {
        this.tileInfoId = tileInfoId;
    }

    /**
     *
     * @return Returns the id of the tileinfo
     */
    public int getTileInfoId() {
        return this.tileInfoId;
    }

    /**
     *
     * @param capacity tile's capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     *
     * @return Returns tile's capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     *
     * @param availability tile's availability
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     *
     * @return Returns tile's availability
     */
    public int getAvailability() {
        return this.availability;
    }

    /**
     *
     * @param address tile's address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     *
     * @return Returns tile's address
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     *
     * @param contact tile's contact info
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     *
     * @return Returns tile's contact info
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