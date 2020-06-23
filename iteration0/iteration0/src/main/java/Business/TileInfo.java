package Business;

public class TileInfo {
    private int tileInfoId;
    private int capacity;
    private int availability;
    private Address address;
    private Contact contact;

    public TileInfo(int tileInfoId, int capacity, int availability, Address address, Contact contact) {
        this.tileInfoId = tileInfoId;
        this.capacity = capacity;
        this.availability = availability;
        this.address = address;
        this.contact = contact;
    }

    public void setTileInfoId(int tileInfoId) {
        this.tileInfoId = tileInfoId;
    }

    public int getTileInfoId() {
        return this.tileInfoId;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getAvailability() {
        return this.availability;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return this.contact;
    }

    public String toString() {
        return "tile info: " + this.tileInfoId + " " + this.capacity + " " + this.availability + "\n" + this.address + "\n" + this.contact;
    }
}
