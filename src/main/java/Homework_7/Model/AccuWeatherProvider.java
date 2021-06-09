package Homework_7.Model;

import Homework_7.GlobalState;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuWeatherProvider implements IWeatherProvider {

    public static final String SCHEME = "https";
    public static final String BASE_HOST = "dataservice.accuweather.com";
    public static final String FORECAST = "forecasts";
    public static final String VERSION = "v1";
    public static final String FREQUENCY = "daily";
    public static final String DAY1 = "1day";
    public static final String DAY5 = "5day";

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void getWeather(Period period) {
        String key = detectCityKeyByName();
        if (period.equals(Period.NOW)) {
            Request reqOneDay = reqConstructor(urlConstructor(key, DAY1));
            try {
                    Response response = client.newCall(reqOneDay).execute();
                    String jsResponse = response.body().string();
                    String date = mapper.readTree(jsResponse).at("/DailyForecasts/0/Date").asText();
                    String weatherTextDay = mapper.readTree(jsResponse).at("/DailyForecasts/0/Day/IconPhrase").asText();
                    String weatherTextNight = mapper.readTree(jsResponse).at("/DailyForecasts/0/Night/IconPhrase").asText();
                    String tempDay = mapper.readTree(jsResponse).at("/DailyForecasts/0/Temperature/Maximum/Value").asText();
                    String tempNight = mapper.readTree(jsResponse).at("/DailyForecasts/0/Temperature/Minimum/Value").asText();
                    System.out.printf("Дата %s: Днем %s, %s; Ночью %s, %s\n", date, weatherTextDay, tempDay, weatherTextNight, tempNight);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (period.equals(Period.FIVE_DAYS)) {
            Request reqFiveDays = reqConstructor(urlConstructor(key, DAY5));
            try {
                Response response = client.newCall(reqFiveDays).execute();
                String jsResponse = response.body().string();
                String folder = "/DailyForecasts/";
                for (int i = 0; i < 5; i++) {
                    String date = mapper.readTree(jsResponse).at(folder + i + "/Date").asText();
                    String weatherTextDay = mapper.readTree(jsResponse).at(folder + i + "/Day/IconPhrase").asText();
                    String weatherTextNight = mapper.readTree(jsResponse).at(folder + i + "/Night/IconPhrase").asText();
                    String tempDay = mapper.readTree(jsResponse).at(folder + i + "/Temperature/Maximum/Value").asText();
                    String tempNight = mapper.readTree(jsResponse).at(folder + i + "/Temperature/Minimum/Value").asText();
                    System.out.printf("Дата %s: Днем %s, %s; Ночью %s, %s\n", date, weatherTextDay, tempDay, weatherTextNight, tempNight);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    private HttpUrl urlConstructor (String city, String duration) {
        HttpUrl url = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(VERSION)
                .addPathSegment(FREQUENCY)
                .addPathSegment(duration)
                .addPathSegment(city)
                .addQueryParameter("apikey", GlobalState.getInstance().API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();
        return url;
    }

    private Request reqConstructor (HttpUrl url) {
        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();
        return request;
    }

    private String detectCityKeyByName() {
        String selectedCity = GlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(VERSION)
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", GlobalState.getInstance().API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = reqConstructor(detectLocationURL);

        Response locationResponse = null;
        try {
            locationResponse = client.newCall(request).execute();

            if (!locationResponse.isSuccessful()) {
                throw new RuntimeException("Сервер ответил " + locationResponse.code());
            }

            String jsonResponse = locationResponse.body().string();

            if (mapper.readTree(jsonResponse).size() > 0) {
                String code = mapper.readTree(jsonResponse).get(0).at("/Key").asText();
                String cityName = mapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
                String countryName = mapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();

                System.out.printf("Погода в городе %s, %s:\n", cityName, countryName);
                return code;
            } else {
                throw new RuntimeException(selectedCity + " - такой город не найден");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


}
