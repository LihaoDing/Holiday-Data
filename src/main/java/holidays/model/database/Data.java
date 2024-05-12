package holidays.model.database;

import holidays.model.entity.Holiday;

import java.util.List;

public interface Data{

    /**
     * save in the program base
     */

    /**
     * insert data from program database;
     * @param holiday the object to be saved
     * @return whether save success
     */
    public boolean saveSingleHoliday(Holiday holiday);

    /**
     * get data data from program database;
     */
    public Holiday getSingleHoliday();

    /**
     * clear data in the program database;
     */
    public boolean clear();

    /**
     * remove holiday in the program database;
     */
    public boolean removeHoliday();



}