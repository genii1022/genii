package com.example.projectgenii;

import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class CardMapping {


    public static Map<String ,String> cache = new HashMap<>(); //this java class to make the mapping set global

    public static Map<String , String> getCache(){
        return cache;
    }

    public static void putCache(String key, String value){
        cache.put(key,value);
    }

    public static void removefromCache(String key){ //deletes the card
        cache.remove(key);
    }




}
