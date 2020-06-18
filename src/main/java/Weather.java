import java.sql.Date;

public class Weather {
    private int id;
    private int regionId;
    private Date date;
    private int temperature;
    private String precipitation;

    public Weather(int id, int regionId, Date date, int temperature, String precipitation) {
        this.id = id;
        this.regionId = regionId;
        this.date = date;
        this.temperature = temperature;
        this.precipitation = precipitation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }
}