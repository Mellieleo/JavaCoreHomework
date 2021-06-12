package Homework_7.Model;

import Homework_7.entity.WeatherObject;

import java.util.List;

public interface IWeatherProvider {
    List<WeatherObject> getWeather(Period period);
}
