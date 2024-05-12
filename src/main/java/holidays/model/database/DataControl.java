package holidays.model.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataControl {

    Connection connection = null;
    /**
     * access into local database
     */
    public DataControl(){
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/holidays.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("create table if not exists Holidays (dateCountry string PRIMARY KEY, data string)");
            statement.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * insert data to the local database
     * @param insertDate the search term, it should be date+countryID
     * @param insertData the data, it should be a string
     * @return if the insertion success
     */
    public String insert(String insertDate, String insertData){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("insert into Holidays(dateCountry,data) values('%s', '%s')",insertDate,insertData));
            statement.close();
            return "success";
        }catch (Exception e){
            System.err.println(e.getMessage());
            return "failed";
        }

    }

    /**
     * update the local database with primary key search term
     * @param updateDate the search term, it should be date+countryID
     * @param updateData the data, it should be a string
     * @return if the update success
     */
    public String update(String updateDate, String updateData){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("update Holidays set data = '%s' where dateCountry = '%s'",updateData,updateDate));
            statement.close();
            return "success";
        }catch (Exception e){
            System.err.println(e.getMessage());
            return "failed";
        }
    }

    /**
     * get the data with searchTerm
     * @param searchDate the search term, it should be date+countryID
     * @return the data
     */
    public String get(String searchDate){
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format("select * from Holidays where dateCountry = '%s'",searchDate));
            while(rs.next())
            {
                return rs.getString("data");
            }
            return null;
        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }



}