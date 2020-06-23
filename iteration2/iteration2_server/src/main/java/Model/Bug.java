package Model;

import com.google.gson.annotations.Expose;

public class Bug {
    @Expose(serialize = true, deserialize = true)
    private String bugName;

    @Expose(serialize = true, deserialize = true)
    private String bugType;

    @Expose(serialize = true, deserialize = true)
    private String bugDescription;

    @Expose(serialize = true, deserialize = true)
    private String clientEmail;

    @Expose(serialize = true, deserialize = true)
    private String reportTime;

    public void setBugName(String bugName) {
        this.bugName = bugName;
    }

    public void setBugType(String bugType) {
        this.bugType = bugType;
    }

    public void setBugDescription(String description) {
        this.bugDescription = description;
    }

    public void setClientEmail(String email) {
        this.clientEmail = email;
    }

    public void setReportTime(String time) {
        this.reportTime = time;
    }

    public String getBugName() {
        return this.bugName;
    }

    public String getBugType() {
        return this.bugType;
    }

    public String getBugDescription() {
        return this.bugDescription;
    }

    public String getClientEmail() {
        return this.clientEmail;
    }

    public String getReportTime() {
        return this.reportTime;
    }

    @Override
    public String toString() {
        return "[" + reportTime + "] - Bug{" +
                "Name: " + this.bugName +
                ", Type: " + this.bugType +
                ", Description: " + this.bugDescription +
                ", Client email: " + this.clientEmail + "}";
    }
}
