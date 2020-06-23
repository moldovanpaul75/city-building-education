package Model;

import com.google.gson.annotations.Expose;


public class Address {

    @Expose(serialize = true, deserialize = true)
    private int addressId;

    @Expose(serialize = true, deserialize = true)
    private String address;

    @Expose(serialize = true, deserialize = true)
    private String zipcode;

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


    @Override
    public String toString() {
        return "Address{" +
                "id=" + this.addressId +
                ", address=" + this.address +
                ", zipcode=" + this.zipcode + "}";
    }
}
