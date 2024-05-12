package holidays.model;
import holidays.model.clientserver.Client;
import holidays.model.clientserver.Output;
import holidays.model.database.Data;
import holidays.model.database.DataControl;
import holidays.model.database.DataImpl;
import holidays.model.entity.HolidayImpl;

public class Facade {
    private Client input;
    private Output output;
    private DataControl database;
    private Data dataa = new DataImpl();
    private int thresholdHolidayCount = 1;


    public Facade(Client input, Output output) {
        this.input = input;
        this.output = output;
    }


    /**
     * get data from online input;
     * @param count the threshold holiday count set by user
     * @return whether the threshold holiday count is set correctly
     */
    public boolean setThresholdHolidayCount(int count) {
        if (count >= 1 && count <= 5) {
            this.thresholdHolidayCount = count;
            return true;
        }
        return false;
    }

    /**
     * get data from online input;
     * @param year the year to be searched
     * @param month the month to be searched
     * @param countryCode the country code to be searched
     * @return whether there are more holidays than the settled threshold holiday count. If yes return true.
     */
    public boolean checkLotsOfHoliday(int year, int month, String countryCode) {
        int temp = 0;
        for (int i = 1; i < 32; i++) {
            String response = database.get(year+""+month+""+i+countryCode);
            if (response != null) {
                System.out.println(response.length());
                if (response.length() > 2) {
                    temp++;
                }
            }
        }
        if (temp > thresholdHolidayCount) {
            return true;
        }
        return false;
    }

    /**
     * get data from online input;
     * @param country the search term, it should be countryID
     * @param year the search term, it should be int
     * @param month the search term, it should be int
     * @param day the search term, it should be int
     * @return the data get from input
     */
    public String getInput(String country, int year, int month, int day) {
        return input.getHolidaysSingleDay(country, year, month, day);
    }

    /**
     * send data to online output;
     * @param message the data to be sent
     * @return the url get from output
     */
    public String sendOutput(String message){
        String temp = output.createPaste(message);
        if (temp == null) {
            return null;
        }
        return temp;
    }

    /**
     * get data from offline input;
     * @param country the search term, it should be countryID
     * @param year the search term, it should be int
     * @param month the search term, it should be int
     * @param day the search term, it should be int
     * @return the data get from input
     */
    public String getOfflineInput(String country, int year, int month, int day) throws Exception {
        return input.getHolidaysSingleDay(country, year, month, day);
    }

    /**
     * send data to offline output;
     * @param message the data to be sent
     * @return the url get from output
     */
    public String sendOfflineOutput(String message) throws Exception {
        String temp = output.createPaste(message);
        if (temp == null) {
            return null;
        }
        return temp;
    }

    /**
     * create database;
     * @param database the database to be created
     * @return whether success
     */
    public boolean createDatabase(DataControl database) {
        try {
            this.database = database;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * send data to online output;
     * @param key the search term
     * @param data the data to be saved
     * @return whether success
     */
    public boolean writeIntoDatabase(String key, String data) {
        String temp;
        try {
            temp = database.insert(key,data);
        } catch (Exception e) {
            return false;
        }
        if (temp == "success") {
            return true;
        }
        return false;

    }

    /**
     * create a new holiday entity;
     * @param key the search term
     * @param data the data to be saved
     * @return whether success
     */
    public boolean createEntity(String key, String data) {
        try {
            dataa.saveSingleHoliday(new HolidayImpl(key, data));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * read from output;
     * @param key the search term
     * @return data get from database
     */
    public String readFromDatabase(String key) {
        try {
            return database.get(key);
        } catch (Exception e) {
            return null;
        }

    }


}