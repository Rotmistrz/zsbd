import DataReceivers.FileParser;
import DataReceivers.RandomManager;
import DataReceivers.Randomizer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class JDBC {
    static final String jdbUrl = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    static final String driver = "oracle.jdbc.driver.OracleDriver";
    static final String user = "HR";
    static final String password = "hr";

    static final String TABLE_CATEGORIES = "CATEGORIES";
    static final String TABLE_COLOURS = "COLOURS";
    static final String TABLE_COUNTRIES = "COUNTRIES";
    static final String TABLE_EVENTS = "EVENTS";
    static final String TABLE_EVENTS_GROUPS = "EVENTSGROUPS";
    static final String TABLE_OWNERS = "OWNERS";
    static final String TABLE_PARTICIPANTS = "PARTICIPANTS";
    static final String TABLE_PLACES = "PLACES";
    static final String TABLE_RESERVATIONS = "RESERVATIONS";
    static final String TABLE_RESERVATIONS_SEATS = "RESERVATIONSSEATS";
    static final String TABLE_SEATS = "SEATS";
    static final String TABLE_SECTORS = "SECTORS";
    static final String TABLE_TICKETS = "TICKETS";

    static final int PLACES_NUMBER = 1000;
    static final int OWNERS_NUMBER = 500;

    static final int SECTORS_MAX = 5;

    public static void clearDatabase() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("DELETE FROM " + TABLE_CATEGORIES);
            stmt.executeUpdate("DELETE FROM " + TABLE_COLOURS);
            stmt.executeUpdate("DELETE FROM " + TABLE_COUNTRIES);
            stmt.executeUpdate("DELETE FROM " + TABLE_EVENTS);
            stmt.executeUpdate("DELETE FROM " + TABLE_EVENTS_GROUPS);
            stmt.executeUpdate("DELETE FROM " + TABLE_OWNERS);
            stmt.executeUpdate("DELETE FROM " + TABLE_PARTICIPANTS);
            stmt.executeUpdate("DELETE FROM " + TABLE_PLACES);
            stmt.executeUpdate("DELETE FROM " + TABLE_RESERVATIONS);
            stmt.executeUpdate("DELETE FROM " + TABLE_RESERVATIONS_SEATS);
            stmt.executeUpdate("DELETE FROM " + TABLE_SEATS);
            stmt.executeUpdate("DELETE FROM " + TABLE_SECTORS);
            stmt.executeUpdate("DELETE FROM " + TABLE_TICKETS);
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

        Random random = new Random();
        RandomManager randomManager = new RandomManager();

        try {
            connection = getConnection();
            stmt = connection.createStatement();

            clearDatabase();

            // Poland
            int polandID = 1;
            stmt.executeUpdate("INSERT INTO " + TABLE_COUNTRIES + " (countryID, name) VALUES (" + polandID + ", 'Polska')");

            String sql = "SELECT * FROM " + TABLE_COUNTRIES;

            resultSet = stmt.executeQuery(sql);

            FileParser fileParser = new FileParser();

            ArrayList<String> addresses = fileParser.parse("resources/data/addresses.txt");
            ArrayList<String> cities = fileParser.parse("resources/data/cities.txt");
            ArrayList<String> words = fileParser.parse("resources/data/words.txt");
            ArrayList<String> colours = fileParser.parse("resources/data/colours.txt");

            ArrayList<String> menNames = fileParser.parse("resources/data/names-men.txt");
            ArrayList<String> menSurnames = fileParser.parse("resources/data/surnames-men.txt");

            ArrayList<String> womenNames = fileParser.parse("resources/data/names-women.txt");
            ArrayList<String> womenSurnames = fileParser.parse("resources/data/surnames-women.txt");

            Randomizer addressesRandomizer = new Randomizer(addresses);
            Randomizer citiesRandomizer = new Randomizer(cities);
            Randomizer wordsRandomizer = new Randomizer(words);

            Randomizer menNamesRandomizer = new Randomizer(menNames);
            Randomizer menSurnamesRandomizer = new Randomizer(menSurnames);

            Randomizer womenNamesRandomizer = new Randomizer(womenNames);
            Randomizer womenSurnamesRandomizer = new Randomizer(womenSurnames);

            int placeID = 1;
            int sectorsNumber = 0;
            int sectorID = 1;

            // Colours
            int coloursNumber = colours.size();

            for (int i = 0; i < coloursNumber; i++) {
                stmt.executeUpdate("INSERT INTO " + TABLE_COLOURS + " VALUES (" + (i + 1) + ", '" + wordsRandomizer.getToken() + "', '" + colours.get(i) + "')");
            }

            // Categories
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 1 + ", 'Sportowe', " + 0 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 2 + ", 'Muzyczne', " + 0 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 3 + ", 'Siatkówka', " + 1 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 4 + ", 'Piłka nożna', " + 1 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 5 + ", 'Tenis stołowy', " + 1 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 6 + ", 'Tenis ziemny', " + 1 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 7 + ", 'Koszykówka', " + 1 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 8 + ", 'Jeździectwo', " + 1 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 9 + ", 'Badminton', " + 1 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 10 + ", 'Snooker', " + 1 + ")");

            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 11 + ", 'Rock', " + 2 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 12 + ", 'Metal', " + 2 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 13 + ", 'Pop', " + 2 + ")");
            stmt.executeUpdate("INSERT INTO " + TABLE_CATEGORIES + " VALUES (" + 14 + ", 'Klasyczna', " + 2 + ")");

            sql = "SELECT COUNT(*) AS amount FROM " + TABLE_CATEGORIES;

            resultSet = stmt.executeQuery(sql);

            int categoriesAmount = 0;

            if (resultSet.next()) {
                categoriesAmount = resultSet.getInt("amount");
            }

            String query;

            // Owners
            for (int o = 1; o < OWNERS_NUMBER; o++) {
                query = "INSERT INTO " + TABLE_OWNERS + " VALUES (" + o + ", '" + randomManager.getNIP() + "', '" + wordsRandomizer.getMediumName() + "',";
                query += "'" + addressesRandomizer.getToken() + "', '" + citiesRandomizer.getToken() + "', '" + randomManager.getDate(2010, 2019) + "', " + polandID + ")";

                stmt.executeUpdate(query);
            }

            // Places
            for (int i = 1; i < PLACES_NUMBER; i++) {
                placeID = i;

                stmt.executeUpdate("INSERT INTO " + TABLE_PLACES + " (placeID, name, address, city, countryid) VALUES (" + placeID + ", '" + wordsRandomizer.getMediumName() + "', '" + addressesRandomizer.getToken() + "', '" + citiesRandomizer.getToken() + "', " + polandID + ")");

                // Sectors
                sectorsNumber = random.nextInt(SECTORS_MAX) + 1;

                for (int j = 0; j < sectorsNumber; j++) {
                    stmt.executeUpdate("INSERT INTO " + TABLE_SECTORS + " VALUES (" + sectorID + ", 'Sektor " + sectorID + "', " + placeID + ", "  + (random.nextInt(coloursNumber) + 1) + ")");

                    sectorID++;
                }
            }


            Iterator<String> it = addresses.iterator();

            String line;

            while(it.hasNext()) {
                line = it.next();

                System.out.println(line);
            }


            sql = "SELECT * FROM COUNTRIES";

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
