package com.naguib.technicalTasks.evision.services;

import java.io.InputStream;

public interface DataHandlingService {
    String saveData(String data);

    InputStream getDataAsInputStream(String fileName);
}
