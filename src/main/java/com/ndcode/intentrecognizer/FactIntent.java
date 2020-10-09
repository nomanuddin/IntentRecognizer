package com.ndcode.intentrecognizer;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

public class FactIntent {

    public void getInterestingFact() {
        OkHttpClient client = getOkHttpClient();
        Request request = getRequest();

        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            var jsonData = Objects.requireNonNull(responseBody).string();
            JSONObject jsonObject = new JSONObject(jsonData);

            String fact = null;
            if (jsonObject.has("value")) {
                fact = jsonObject.getString("value");
            }
            System.out.println("Interesting fact: " + fact);

            response.body().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Request getRequest() {
        return new Request.Builder()
                .url("https://api.chucknorris.io/jokes/random")
                .method("GET", null)
                .build();
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient().newBuilder()
                .build();
    }
}