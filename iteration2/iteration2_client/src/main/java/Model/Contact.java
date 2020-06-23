package Model;

import com.google.gson.annotations.Expose;


public class Contact {

    @Expose(serialize = true, deserialize = true)
    private int contactId;

    @Expose(serialize = true, deserialize = true)
    private String telephoneNb;

    @Expose(serialize = true, deserialize = true)
    private String email;

    @Expose(serialize = true, deserialize = true)
    private String website;


    /**
     *
     * @param id the id of the contact
     */
    public void setContactId(int id) {
        this.contactId = id;
    }

    /**
     *
     * @return Returns the id of the contact
     */
    public int getContactId() {
        return this.contactId;
    }

    /**
     *
     * @param nb telephone number
     */
    public void setTelephoneNb(String nb) {
        this.telephoneNb = nb;
    }

    /**
     *
     * @return Returns the telephone number
     */
    public String getTelephoneNb() {
        return this.telephoneNb;
    }

    /**
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return Returns the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @return Returns the website
     */
    public String getWebsite() {
        return this.website;
    }

    /**
     *
     * @param website the website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        if (website != null) {
            return "Contact{" +
                    "id=" + this.contactId +
                    ", tel=" + this.telephoneNb +
                    ", email=" + this.email +
                    ", website=" + this.website + "}";
        }
        return "Contact{" +
                "id=" + this.contactId +
                ", tel=" + this.telephoneNb +
                ", email=" + this.email + "}";
    }
}
