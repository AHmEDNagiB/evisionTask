package com.naguib.technicalTasks.evision.services.impl;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.naguib.technicalTasks.evision.entity.TransactionEntity;
import com.naguib.technicalTasks.evision.services.JsonParserService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class JsonParserServiceImpl implements JsonParserService {
    @Override
    public boolean isValidJson(InputStream dataFile) {
        JsonReader reader = new JsonReader(new InputStreamReader(dataFile));
        Gson gson = new Gson();
        boolean validObj = true;
        try {
            reader.beginArray();
            while (reader.hasNext() && validObj) {
                TransactionEntity entity = gson.fromJson(reader, TransactionEntity.class);
                validObj = entity.isValid();
            }
            if (validObj) {
                reader.endArray();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            validObj = false;
        }
        return validObj;
    }
}
