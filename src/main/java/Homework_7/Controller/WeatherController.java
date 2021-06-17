package Homework_7.Controller;

import Homework_7.Model.AccuWeatherProvider;
import Homework_7.Model.IWeatherProvider;
import Homework_7.Model.Period;

public class WeatherController implements IWeatherController{
    private IWeatherProvider weatherProvider = new AccuWeatherProvider();

    @Override
    public void onUserInput(int command) {

        switch (command) {
            case 1:
                getCurrentWeather();
                break;
            case 2:
                getForecast();
                break;
            default:
                System.out.println("Команда не распознана!");
                System.exit(1);
        }
    }
    private void getCurrentWeather() {
        weatherProvider.getWeather(Period.NOW);
    }
    private void getForecast() {
        weatherProvider.getWeather(Period.FIVE_DAYS);
    }
}
