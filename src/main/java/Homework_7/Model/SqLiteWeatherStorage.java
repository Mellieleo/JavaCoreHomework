package Homework_7.Model;

import Homework_7.GlobalState;
import Homework_7.entity.WeatherObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqLiteWeatherStorage implements ILocalStorageProvider {

    static {
        try {
            GlobalState.getInstance().getConnection().createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS weatherapp (id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT, date TEXT, weather_day TEXT, temp_day TEXT, weather_night TEXT, temp_night TEXT)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void saveWeatherLocally(WeatherObject weatherObject) {
        try {
            GlobalState.getInstance().getStatement().executeUpdate("INSERT INTO weatherapp (city, date, weather_day, temp_day, weather_night, temp_night) VALUES "
                    + weatherObject.getCity() + ", " + weatherObject.getDate() + ", " + weatherObject.getWeatherTextDay() + ", " + weatherObject.getTempDay() + ", "
                    + weatherObject.getWeatherTextNight() + ", " + weatherObject.getTempNight());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<WeatherObject> getAllWeather() {
        List<WeatherObject> weather = new ArrayList<>();
        try {
            ResultSet resultSet = GlobalState.getInstance().getStatement().executeQuery("SELECT * FROM " + GlobalState.getInstance().DB_NAME);
            while (resultSet.next()) {
                String city = resultSet.getString("city");
                String date = resultSet.getString("date");
                String weather_day = resultSet.getString("weather_day");
                String temp_day = resultSet.getString("temp_day");
                String weather_night = resultSet.getString("weather_night");
                String temp_night = resultSet.getString("temp_night");
                WeatherObject weatherObject = new WeatherObject(city, date, weather_day, temp_day, weather_night, temp_night);
                weather.add(weatherObject);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return weather;
    }
}
