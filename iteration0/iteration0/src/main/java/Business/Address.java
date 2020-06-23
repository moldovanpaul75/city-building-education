package Business;

public class Address {
    private int addressId;
    private District district;
    private String street;

    public Address(int id, District district, String street) {
        this.addressId = id;
        this.district = district;
        this.street = street;
    }

    public void setAddressId(int id) {
        this.addressId = id;
    }

    public int getAddressId() {
        return this.addressId;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public District getDistrict() {
        return this.getDistrict();
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public String toString() {
        return "address: " + this.addressId + " " + this.street + "\n" + district;
    }
}
