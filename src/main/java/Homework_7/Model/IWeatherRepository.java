package Homework_7.Model;

import Homework_7.entity.WeatherObject;

import java.util.List;

public interface IWeatherRepository {
    List<WeatherObject> fetchWeatherFromAPI(Period period);
    List<WeatherObject> readWeatherFromDB();
    void saveWeatherInfoInDB(List<WeatherObject> weatherObjects);
}
