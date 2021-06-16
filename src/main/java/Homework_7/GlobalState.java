package Homework_7;

import java.sql.Connection;
import java.sql.Statement;

public final class GlobalState {
    private static GlobalState INSTANCE;
    private String selectedCity = null;
    public static final String API_KEY = "Pu8esEEOwkAp2bSBOyfVoAMqVsp7YjgK";
    public final String DB_NAME = "weatherapp.db";

    private Connection connection;
    private Statement statement;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private GlobalState() { }

    public static GlobalState getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GlobalState();
        }
        return INSTANCE;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
