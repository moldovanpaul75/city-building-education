package Business;

public class Contact {
    private int contactId;
    private int telephoneNb;
    private String email;

    public Contact(int id, int telephoneNb, String email) {
        this.contactId = id;
        this.telephoneNb = telephoneNb;
        this.email = email;
    }

    public Contact(int telephoneNb, String email) {
        this.telephoneNb = telephoneNb;
        this.email = email;
    }

    public void setContactId(int id) {
        this.contactId = id;
    }

    public int getContactId() {
        return this.contactId;
    }

    public void setTelephoneNb(int nb) {
        this.telephoneNb = nb;
    }

    public int getTelephoneNb() {
        return this.telephoneNb;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public String toString() {
        return "contact: " + this.contactId + " " + this.telephoneNb + " " + this.email;
    }
}
