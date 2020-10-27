import DataReceivers.FileParser;
import DataReceivers.Randomizer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class JDBC {
    static final String jdbUrl = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    static final String driver = "oracle.jdbc.driver.OracleDriver";
    static final String user = "system";
    static final String password = "FilipBartek123";

    static final String TABLE_COUNTRIES = "SYS.COUNTRIES";
    static final String TABLE_PLACES = "SYS.PLACES";

    public static void clearDatabase() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("DELETE FROM " + TABLE_PLACES);
            stmt.executeUpdate("DELETE FROM " + TABLE_COUNTRIES);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return java.sql.DriverManager.getConnection(jdbUrl, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        Statement stmt = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            stmt = connection.createStatement();

            clearDatabase();

            // Poland
            int polandID = 1;
            stmt.executeUpdate("INSERT INTO " + TABLE_COUNTRIES + " (countryID, name) VALUES (" + polandID + ", 'Polska')");

            String sql = "SELECT * FROM SYS.COUNTRIES";

            //resultSet = stmt.executeQuery(sql);

            FileParser fileParser = new FileParser();

            ArrayList<String> addresses = fileParser.parse("resources/data/addresses.txt");
            ArrayList<String> cities = fileParser.parse("resources/data/cities.txt");
            ArrayList<String> words = fileParser.parse("resources/data/words.txt");

            Randomizer addressesRandomizer = new Randomizer(addresses);
            Randomizer citiesRandomizer = new Randomizer(cities);
            Randomizer wordsRandomizer = new Randomizer(words);

            // Places
            for (int i = 1; i < 1000; i++) {
                stmt.executeUpdate("INSERT INTO " + TABLE_PLACES + " VALUES (\"" + i + "\", \"" + wordsRandomizer.getMediumName() + "\", \"" + addressesRandomizer.getToken() + "\", \"" + citiesRandomizer.getToken() + "\", \"" + polandID + "\")");
            }


            Iterator<String> it = addresses.iterator();

            String line;

            while(it.hasNext()) {
                line = it.next();

                System.out.println(line);
            }


            sql = "SELECT * FROM SYS.COUNTRIES";

            resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(stmt != null) {
                stmt.close();
            }
            if(resultSet != null) {
                resultSet.close();
            }
        }
    }
}
