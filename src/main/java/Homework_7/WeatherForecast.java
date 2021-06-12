package Homework_7;

import Homework_7.View.IUserInterface;
import Homework_7.View.UserInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WeatherForecast {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + GlobalState.getInstance().DB_NAME);
        GlobalState.getInstance().setConnection(connection);
        Statement statement = connection.createStatement();
        GlobalState.getInstance().setStatement(statement);
        IUserInterface userInterface = new UserInterface();
        userInterface.showUI();
    }
}
