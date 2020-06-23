package Model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

/**
 * This class represents a contact entity
 */
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Expose(serialize = true, deserialize = true)
    private int contactId;

    @Column(name = "phone", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private String telephoneNb;

    @Column(name = "email", nullable = false)
    @Expose(serialize = true, deserialize = true)
    private String email;

    @Column(name = "website", nullable = true)
    @Expose(serialize = true, deserialize = true)
    private String website;

    @OneToOne(mappedBy = "contact")
    @Expose(serialize = false, deserialize = false)
    private TileInfo tileInfo;

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

    /**
     *
     * @return Returns the tileinfo this contact is from
     */
    public TileInfo getTileInfo() {
        return this.tileInfo;
    }

    /**
     *
     * @param tileInfo the tileinfo
     */
    public void setTileInfo(TileInfo tileInfo) {
        this.tileInfo = tileInfo;
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
