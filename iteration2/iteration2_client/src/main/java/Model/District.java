package Model;

import com.google.gson.annotations.Expose;


public class District {

    @Expose(serialize = true, deserialize = true)
    private int districtId;

    @Expose(serialize = true, deserialize = true)
    private String districtName;

    @Expose(serialize = true, deserialize = true)
    private int xStart;

    @Expose(serialize = true, deserialize = true)
    private int xEnd;

    @Expose(serialize = true, deserialize = true)
    private int yStart;

    @Expose(serialize = true, deserialize = true)
    private int yEnd;

    @Expose(serialize = true, deserialize = true)
    private City city;

    /**
     *
     * @param id the id of the district
     */
    public void setDistrictId(int id) {
        this.districtId = id;
    }

    /**
     *
     * @return Returns the id of the district
     */
    public int getDistrictId() {
        return this.districtId;
    }

    /**
     *
     * @param city the city this district is from
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     *
     * @return Returns the district's city
     */
    public City getCity() {
        return this.city;
    }

    /**
     *
     * @param name the name of the district
     */
    public void setDistrictName(String name) {
        this.districtName = name;
    }

    /**
     *
     * @return Returns the name of the district
     */
    public String getDistrictName() {
        return this.districtName;
    }

    /**
     *
     * @param xStart x coordonate start
     */
    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    /**
     *
     * @return Returns the x coordonate start
     */
    public int getxStart() {
        return this.xStart;
    }

    /**
     *
     * @param xEnd x coordonate end
     */
    public void setxEnd(int xEnd) {
        this.xEnd = xEnd;
    }

    /**
     *
     * @return Returns the x coordonate end
     */
    public int getxEnd() {
        return this.xEnd;
    }

    /**
     *
     * @param yStart y coordonate start
     */
    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    /**
     *
     * @return Returns y coordonate start
     */
    public int getyStart() {
        return this.yStart;
    }

    /**
     *
     * @param yEnd y coordonate end
     */
    public void setyEnd(int yEnd) {
        this.yEnd = yEnd;
    }

    /**
     *
     * @return Returns y coordonate end
     */
    public int getyEnd() {
        return this.yEnd;
    }


    @Override
    public String toString() {
        return "District{" +
                "id=" + this.districtId +
                ", name=" + this.districtName +
                " x[" + this.xStart + " ," + this.xEnd + "] y[" + this.yStart + " ," + this.yEnd + "]}";
    }
}
