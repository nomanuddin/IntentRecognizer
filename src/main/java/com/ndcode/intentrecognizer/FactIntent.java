package com.ndcode.intentrecognizer;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

public class FactIntent {

    static Logger logger = Logger.getLogger(FactIntent.class.getName());

    //getInterestingFact method call sub-methods for calling fact api
    //and displaying content after parsing response body.
    public void getInterestingFact() {
        OkHttpClient client = getOkHttpClient();
        Request request = getRequest();

        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();

            // parsing response body for fact info
            var jsonData = Objects.requireNonNull(responseBody).string();
            JSONObject jsonObject = new JSONObject(jsonData);

            // pre-check if fact exist
            String fact = null;
            if (jsonObject.has("value")) {
                fact = jsonObject.getString("value");
            }

            System.out.println("Interesting fact: " +
                    Objects.requireNonNullElse(fact, "No fact available please try again."));

            // closing connection
            response.body().close();
        } catch (IOException e) {
            logger.info("Error: Please contact administrator" + e.getMessage());
        }
    }

    // creating request for fact api
    private Request getRequest() {
        return new Request.Builder()
                .url("https://api.chucknorris.io/jokes/random")
                .method("GET", null)
                .build();
    }

    // creating http client
    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient().newBuilder()
                .build();
    }
}