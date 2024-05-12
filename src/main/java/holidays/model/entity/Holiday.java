package holidays.model.entity;

public interface Holiday {

    /**
     * get data from program database;
     * @return holiday
     */
    public Holiday getHolidays() throws Exception;

    /**
     * get data from program database;
     * @return date+countryID
     */
    public String getDateCountry();

    /**
     * GET DATA;
     * @return whether save success
     */
    public String getData();

    /**
     * insert date+CountryId into program database;
     * @param dateCountry the object to be saved
     */
    public void setDateCountry(String dateCountry);

    /**
     * insert data into program database;
     * @param data the object to be saved
     */
    public void setData(String data);
}