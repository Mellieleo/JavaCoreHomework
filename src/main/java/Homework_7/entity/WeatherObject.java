package Homework_7.entity;

public class WeatherObject {
    private String city;
    private String date;
    private String weatherTextDay;
    private String weatherTextNight;
    private String tempDay;
    private String tempNight;

    public WeatherObject(String city, String date, String weatherTextDay, String tempDay, String weatherTextNight, String tempNight) {
        this.city = city;
        this.date = date;
        this.weatherTextDay = weatherTextDay;
        this.tempDay = tempDay;
        this.weatherTextNight = weatherTextNight;
        this.tempNight = tempNight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeatherTextDay() {
        return weatherTextDay;
    }

    public void setWeatherTextDay(String weatherTextDay) {
        this.weatherTextDay = weatherTextDay;
    }

    public String getWeatherTextNight() {
        return weatherTextNight;
    }

    public void setWeatherTextNight(String weatherTextNight) {
        this.weatherTextNight = weatherTextNight;
    }

    public String getTempDay() {
        return tempDay;
    }

    public void setTempDay(String tempDay) {
        this.tempDay = tempDay;
    }

    public String getTempNight() {
        return tempNight;
    }

    public void setTempNight(String tempNight) {
        this.tempNight = tempNight;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public WeatherObject(){
    }

    @Override
    public String toString() {
        return "WeatherObject{" +
                "date='" + date + '\'' +
                ", weatherTextDay='" + weatherTextDay + '\'' +
                ", weatherTextNight='" + weatherTextNight + '\'' +
                ", tempDay='" + tempDay + '\'' +
                ", tempNight='" + tempNight + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
