import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import java.sql.Date;

public class Main {
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBManager dbManager = new DBManager();

        System.out.println("Enter region to get info about its weather");
        String regionName = scanner.nextLine();
        List<Weather> weatherList = dbManager.getWeatherStatsInRegion(regionName);
        for (Weather w : weatherList) {
            System.out.println(w.toString());
        }

        System.out.println("Enter region to get info about snowy days and the temperature below -10.");
        regionName = scanner.nextLine();
        List<Date> snowyDates = dbManager.getDatesWhenSnowAndTempBelow10(regionName);
        for (Date d : snowyDates) {
            System.out.println(d);
        }

        System.out.println("Enter language to get the weather for the last week in the regions where the inhabitants speak a given language.");
        String language = scanner.nextLine();
        weatherList = dbManager.getWeatherByLastWeek(language);
        for (Weather w : weatherList) {
            System.out.println(w.toString());
        }

        System.out.println("Get the average temperature for the last week in regions with an area of more than 1000.");
        int temperature = dbManager.getAverageTemperature();
        System.out.println("Average temperature is : " + temperature);

        System.out.println("Close connection with db");
        dbManager.close();
    }
}
