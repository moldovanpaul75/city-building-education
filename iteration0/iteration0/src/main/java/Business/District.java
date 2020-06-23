package Business;

public class District {
    private int districtId;
    private City city;
    private String districtName;
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;

    public District(int id, City city, String name, int xStart, int yStart, int xEnd, int yEnd) {
        this.districtId = id;
        this.city = city;
        this.districtName = name;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public District(City city, String name, int xStart, int yStart, int xEnd, int yEnd) {
        this.city = city;
        this.districtName = name;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public void setDistrictId(int id) {
        this.districtId = id;
    }

    public int getDistrictId() {
        return this.districtId;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return this.city;
    }

    public void setDistrictName(String name) {
        this.districtName = name;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public int getxStart() {
        return this.xStart;
    }

    public void setxEnd(int xEnd) {
        this.xEnd = xEnd;
    }

    public int getxEnd() {
        return this.xEnd;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public int getyStart() {
        return this.yStart;
    }

    public void setyEnd(int yEnd) {
        this.yEnd = yEnd;
    }

    public int getyEnd() {
        return this.yEnd;
    }

    public String toString() {
        return "district: " + this.districtId + " " + this.districtName + " x[" + this.xStart + " ," + this.xEnd + "] y[" + this.yStart + " ," + this.yEnd + "] \n" + this.city;
    }
}
