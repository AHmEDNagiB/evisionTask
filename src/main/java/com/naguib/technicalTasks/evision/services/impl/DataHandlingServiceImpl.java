package com.naguib.technicalTasks.evision.services.impl;

import com.naguib.technicalTasks.evision.services.DataHandlingService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Date;

import static com.naguib.technicalTasks.evision.utils.Constants.FILE_PATH;

@Service
public class DataHandlingServiceImpl implements DataHandlingService {
    @Override
    public String saveData(String data) {
        String fileName = String.format("%1$s%2$s.json", FILE_PATH, new Date().getTime());
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return fileName;
    }

    @Override
    public InputStream getDataAsInputStream(String fileName) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return fileInputStream;
    }
}
