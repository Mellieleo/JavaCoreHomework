package Homework_7;

public final class GlobalState {
    private static GlobalState INSTANCE;
    private String selectedCity = null;
    public static final String API_KEY = "Pu8esEEOwkAp2bSBOyfVoAMqVsp7YjgK";

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
}
