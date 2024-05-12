package holidays.model.entity;

public class HolidayImpl implements Holiday {

    private String dateCountry;
    private String data;


    /**
     * Holiday entity class
     */
    public HolidayImpl(String dateCountry, String data) {
        this.dateCountry = dateCountry;
        this.data = data;
    }

    /**
     * get data from program database;
     * @return holiday
     */
    @Override
    public Holiday getHolidays() throws Exception {
        return this;
    }

    /**
     * get data from program database;
     * @return date+countryID
     */
    @Override
    public String getDateCountry() {
        return this.dateCountry;
    }

    /**
     * GET DATA;
     * @return whether save success
     */
    @Override
    public String getData() {
        return this.data;
    }

    /**
     * insert date+CountryId into program database;
     * @param dateCountry the object to be saved
     */
    @Override
    public void setDateCountry(String dateCountry) {
        this.dateCountry = dateCountry;
    }

    /**
     * insert data into program database;
     * @param data the object to be saved
     */
    @Override
    public void setData(String data) {
        this.data = data;
    }


}
