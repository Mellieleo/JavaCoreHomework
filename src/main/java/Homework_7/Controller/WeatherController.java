package Homework_7.Controller;

import Homework_7.Model.*;

public class WeatherController implements IWeatherController{
    private IWeatherRepository weatherRepository = new WeatherRepository();

    @Override
    public void onUserInput(int command) {

        switch (command) {
            case 1:
                getCurrentWeather();
                break;
            case 2:
                getForecast();
                break;
            case 3:
                getAllFromDB();
            default:
                System.out.println("Команда не распознана!");
                System.exit(1);
        }
    }
    private void getCurrentWeather() {
        weatherRepository.fetchWeatherFromAPI(Period.NOW);
    }
    private void getForecast() {
        weatherRepository.fetchWeatherFromAPI(Period.FIVE_DAYS);
    }
    private void getAllFromDB(){
        weatherRepository.readWeatherFromDB();
    }
}
