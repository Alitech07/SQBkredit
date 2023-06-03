package org.example.utils;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.entity.ExchangeRateApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.IOException;
public class JsonToData {
    public ExchangeRateApi getData() {
        String url_str = "https://cbu.uz/uz/arkhiv-kursov-valyut/json/USD/2019-01-01/";
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url_str);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();

            String responseString = EntityUtils.toString(entity);
            String substring = responseString.substring(1, responseString.length() - 1);
            System.out.println(substring);

            Gson gson = new Gson();
            ExchangeRateApi rateApi = gson.fromJson(substring, ExchangeRateApi.class);
            return rateApi;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}