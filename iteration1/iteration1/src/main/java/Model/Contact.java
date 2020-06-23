package Model;

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
    private int contactId;

    @Column(name = "phone", nullable = false)
    private int telephoneNb;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "website")
    private String website;

    @OneToOne(mappedBy = "contact")
    private TileInfo tileInfo;

    /**
     *
     * @param id
     */
    public void setContactId(int id) {
        this.contactId = id;
    }

    /**
     *
     * @return
     */
    public int getContactId() {
        return this.contactId;
    }

    /**
     *
     * @param nb
     */
    public void setTelephoneNb(int nb) {
        this.telephoneNb = nb;
    }

    /**
     *
     * @return
     */
    public int getTelephoneNb() {
        return this.telephoneNb;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @return
     */
    public String getWebsite() {
        return this.website;
    }

    /**
     *
     * @param website
     */
    public void setWebsite(String website) {
        this.website = website;
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
     * @param tileInfo
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
