package holidays.model.database;

import holidays.model.entity.Holiday;

import java.util.ArrayList;
import java.util.List;

public class DataImpl implements Data {

    private List<Holiday> holidayList;
    /**
     * save in the program base
     */

    public DataImpl() {
        holidayList = new ArrayList<Holiday>();
    }

    /**
     * insert data from program database;
     * @param holiday the object to be saved
     * @return whether save success
     */
    @Override
    public boolean saveSingleHoliday(Holiday holiday) {
        holidayList.add(holiday);
        return true;
    }

    /**
     * get data data from program database;
     */
    @Override
    public Holiday getSingleHoliday() {
        return null;
    }

    /**
     * clear data in the program database;
     */
    @Override
    public boolean clear() {
        holidayList = null;
        return true;
    }

    /**
     * remove holiday in the program database;
     */
    @Override
    public boolean removeHoliday() {
        return false;
    }
}
