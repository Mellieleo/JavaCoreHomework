package Homework_7.Model;

import Homework_7.entity.WeatherObject;

import java.sql.SQLException;
import java.util.List;

public class WeatherRepository implements IWeatherRepository {

    IWeatherProvider apiWeatherProvider = new AccuWeatherProvider();
    ILocalStorageProvider localStorageProvider = new SqLiteWeatherStorage();

    @Override
    public List<WeatherObject> fetchWeatherFromAPI(Period period) {
        List<WeatherObject> weather = apiWeatherProvider.getWeather(period);
        saveWeatherInfoInDB(weather);
        return weather;
    }

    @Override
    public List<WeatherObject> readWeatherFromDB() {
        List<WeatherObject> dbResult = null;
        try {
            dbResult = localStorageProvider.getAllWeather();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(dbResult);
        return dbResult;
    }

    @Override
    public void saveWeatherInfoInDB(List<WeatherObject> weatherObjects) {
        for (WeatherObject weatherObject:weatherObjects) {
            localStorageProvider.saveWeatherLocally(weatherObject);
        }
    }
}
