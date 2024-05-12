package holidays.model.clientserver;

import holidays.model.clientserver.Client;

public class offlineInput implements Client {
    /**
     * get data from the offline input API
     * @param country the search term, it should be countryID
     * @param year the search term, it should be int
     * @param month the search term, it should be int
     * @param day the search term, it should be int
     * @return the data get from input
     */
    public String getHolidaysSingleDay(String country, int year, int month, int day) {
        return "This is offline input";
    }
}