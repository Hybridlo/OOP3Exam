import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private Connection con;
    private Statement stmt;

    DBManager() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost/examdb", "postgres", "5502");
        stmt = con.createStatement();
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Weather> getWeatherStatsInRegion(String regionName) {
        try {
            String sql = "SELECT x.id, x.regionId, x.date, x.temperature, x.precipitation " +
                    "FROM weather x INNER JOIN region y ON x.region_id = y.id "  +
                    "WHERE x.name = '" + regionName + "';";

            ResultSet rs = stmt.executeQuery(sql);
            List<Weather> weathers = new ArrayList<>();
            while (rs.next()) {
                Weather newWeather = new Weather(rs.getInt("id"), rs.getInt("region_id"),
                        rs.getDate("date"), rs.getInt("temperature"), rs.getString("precipitation"));
                weathers.add(newWeather);
            }
            return weathers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Date> getDatesWhenSnowAndTempBelow10(String regionName) {
        try {
            String sql = "SELECT x.date " +
                    "FROM weather x INNER JOIN region y ON x.region_id = y.id "  +
                    "WHERE x.name = '" + regionName + "' AND x.precipitation = 'snow' " +
                    "AND x.temperature < -10;";

            ResultSet rs = stmt.executeQuery(sql);
            List<Date> dates = new ArrayList<>();
            while (rs.next()) {
                dates.add(rs.getDate("date"));
            }
            return dates;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Weather> getWeatherByLastWeek(String language) {
        try {
            String sql = "SELECT x.id, x.regionId, x.date, x.temperature, x.precipitation " +
                    "FROM (weather x INNER JOIN region y ON x.region_id = y.id) " +
                    "INNER JOIN inhabitants z ON z.id = y.inhabitants_id "  +
                    "WHERE z.language = '" + language + "';";

            ResultSet rs = stmt.executeQuery(sql);
            List<Weather> weathers = new ArrayList<>();
            while (rs.next()) {
                Weather newWeather = new Weather(rs.getInt("id"), rs.getInt("region_id"),
                        rs.getDate("date"), rs.getInt("temperature"), rs.getString("precipitation"));
                weathers.add(newWeather);
            }
            return weathers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getAverageTemperature() {
        try {
            String sql = "SELECT AVG(temperature) " +
                    "FROM weather x INNER JOIN region y ON x.region_id = y.id "  +
                    "WHERE y.square > 1000 AND x.date >= date_trunc('week', now()-'7 day'::interval);";

            ResultSet rs = stmt.executeQuery(sql);
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
