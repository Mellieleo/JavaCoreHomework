package Homework_6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.Objects;

public class AccuWeatherAPI {

    public static final String API_KEY = "Pu8esEEOwkAp2bSBOyfVoAMqVsp7YjgK";
    public static final String SPB = "474212_PC";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(SPB)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        Request api_req = new Request.Builder()
                .url(url)
                .addHeader("accept", "application/json")
                .build();
        System.out.println(Objects.requireNonNull(client.newCall(api_req).execute().body()).string());

    }
}
