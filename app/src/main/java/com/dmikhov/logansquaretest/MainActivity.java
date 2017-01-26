package com.dmikhov.logansquaretest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bluelinelabs.logansquare.LoganSquare;
import com.dmikhov.logansquaretest.models.gson.GImagesResponse;
import com.dmikhov.logansquaretest.models.gson.GPrice;
import com.dmikhov.logansquaretest.models.jackson.JImagesResponse;
import com.dmikhov.logansquaretest.models.logan.ImagesResponse;
import com.dmikhov.logansquaretest.models.logan.Price;
import com.dmikhov.logansquaretest.models.moshi.MImagesResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "madless_tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testLoganSquare();
        testLoganSquareList();
        testGson();
        testGsonList();
        testJackson();
        testJacksonList();
        testMoshi();
        testMoshiList();
    }

    public void testLoganSquare() {
        String dataStr = getData();
        try {
            ImagesResponse resp = LoganSquare.parse(dataStr, ImagesResponse.class);
            Log.d(TAG, "testLoganSquare: resp:" + resp);
            String respSerialized = LoganSquare.serialize(resp);
            Log.d(TAG, "testLoganSquare: respSerialized: " + respSerialized);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGson() {
        String dataStr = getData();
        Gson gson = new GsonBuilder().create();
        GImagesResponse resp = gson.fromJson(dataStr, GImagesResponse.class);
        Log.i(TAG, "testGson: resp:" + resp);
        String respSerialized = gson.toJson(resp);
        Log.i(TAG, "testGson: respSerialized: " + respSerialized);
    }

    public void testJackson() {
        String dataStr = getData();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JImagesResponse resp = mapper.readValue(dataStr, JImagesResponse.class);
            Log.d(TAG, "testJackson: resp:" + resp);
            String respSerialized = mapper.writeValueAsString(resp);
            Log.d(TAG, "testJackson: respSerialized: " + respSerialized);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testMoshi() {
        String dataStr = getData();
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<MImagesResponse> jsonAdapter = moshi.adapter(MImagesResponse.class);
        try {
            MImagesResponse resp = jsonAdapter.fromJson(dataStr);
            Log.d(TAG, "testMoshi: resp:" + resp);
            String respSerialized = jsonAdapter.toJson(resp);
            Log.d(TAG, "testMoshi: respSerialized: " + respSerialized);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testLoganSquareList() {
        List<Price> prices = getPrices();
        try {
            String json = LoganSquare.serialize(prices);
            Log.d(TAG, "testLoganSquareList: json: " + json);
            List<Price> deserialized = LoganSquare.parseList(json, Price.class);
            Log.d(TAG, "testLoganSquareList: deserialized: " + deserialized);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGsonList() {
        List<Price> prices = getPrices();
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<GPrice>>(){}.getType();
        String json = gson.toJson(prices);
        Log.d(TAG, "testGsonList: json:" + json);
        List<Price> deserialized = gson.fromJson(json, listType);
        Log.d(TAG, "testGsonList: deserialized:" + deserialized);
    }

    public void testJacksonList() {
        List<Price> prices = getPrices();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference typeRef = new TypeReference<List<Price>>() {};
        try {
            String json = mapper.writeValueAsString(prices);
            Log.d(TAG, "testJacksonList: json" + json);
            List<Price> deserialized = mapper.readValue(json, typeRef);
            Log.d(TAG, "testJacksonList: deserialized: " + deserialized);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testMoshiList() {
        List<Price> prices = getPrices();
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<List<Price>> jsonAdapter = moshi.adapter(Types.newParameterizedType(List.class));
        String json = jsonAdapter.toJson(prices);
        Log.d(TAG, "testMoshiList: json:" + json);
        try {
            List<Price> deserialized = jsonAdapter.fromJson(json);
            Log.d(TAG, "testMoshiList: deserialized:" + deserialized);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getData() {
        InputStream dataStream = getResources().openRawResource(R.raw.data);
        String dataStr = readTextFile(dataStream);
        return dataStr;
    }

    public List<Price> getPrices() {
        Price p1 = new Price("USD", 100);
        Price p2 = new Price("USD", 200);
        Price p3 = new Price("USD", 300);
        return new ArrayList<>(Arrays.asList(p1, p2, p3));
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}
