package Homework_7;

import Homework_7.View.IUserInterface;
import Homework_7.View.UserInterface;

public class WeatherForecast {
    public static void main(String[] args) {
        IUserInterface userInterface = new UserInterface();
        userInterface.showUI();
    }
}
