package com.ndcode.intentrecognizer;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherIntent {

    static Logger logger = Logger.getLogger(WeatherIntent.class.getName());

    //getWeather method controls the whole flow of getting weather info and publishing it
    //using sub-methods
    public void getWeather(String question) {
        String homeTown = "Karlsruhe";

        // parsing question to get city info (Default city is hometown)
        var city = getCity(question);

        // check if city exist
        if (!city.contentEquals("N/A")) {
            System.out.println("Intent: Get Weather City");
        } else {
            System.out.println("Intent: Get Weather");
            city = homeTown;
        }
        publishWeatherInfo(city);
    }

    //prints weather info on console
    private void publishWeatherInfo(String city) {
        OkHttpClient client = getOkHttpClient();
        Request request = getRequest(city);

        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();

            // parsing response body for weather info
            var jsonData = Objects.requireNonNull(responseBody).string();
            JSONObject jsonObject = new JSONObject(jsonData);
            Map<String, Object> temperature = null;

            // pre-checks if weather info exists in the response
            // implementation can be extended to a better form using
            // swagger api or awm-openWeatherApi dependency
            if (jsonObject.has("main")) {
                temperature = jsonObject.getJSONObject("main").toMap();
            }
            String weather = null;
            if (jsonObject.has("weather")) {
                weather = jsonObject.getJSONArray("weather").toList().toString();
            }

            System.out.println("City name: " + city);
            System.out.println("temperature: " + Objects.requireNonNullElse(temperature, "Info regarding pressure is not available the moment"));
            System.out.println("weather: " + Objects.requireNonNullElse(weather, "Info regarding weather is not available the moment"));

            // closing connection
            response.body().close();
        } catch (IOException e) {
            logger.info("Error: Please contact administrator" + e.getMessage());
        }
    }

    //creating request for fact api
    private Request getRequest(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=a6009ffacdde9cb48ead344d6e6bd6b1";
        return new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
    }

    //creating http client
    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient().newBuilder()
                .build();
    }

    //getting city from questioin
    private String getCity(String question) {

        //Pattern for finding city info
        //if city name is not extracted N/A is returned
        Pattern cityPattern = Pattern.compile("in (.*?) today");
        Matcher matcher = cityPattern.matcher(question);

        return (matcher.find() ? matcher.group(1) : "N/A");
    }
}