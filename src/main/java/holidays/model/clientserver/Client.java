package holidays.model.clientserver;

public interface Client {

    /**
     * get data from the input API
     * @param country the search term, it should be countryID
     * @param year the search term, it should be int
     * @param month the search term, it should be int
     * @param day the search term, it should be int
     * @return the data get from input
     */
    public String getHolidaysSingleDay(String country, int year, int month, int day);
}