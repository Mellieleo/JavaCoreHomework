package Homework_7.Model;

import Homework_7.entity.WeatherObject;

import java.sql.SQLException;
import java.util.List;

public interface ILocalStorageProvider {
    void saveWeatherLocally(WeatherObject weatherObject);
    List<WeatherObject> getAllWeather() throws SQLException;
}
