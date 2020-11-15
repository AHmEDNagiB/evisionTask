package com.naguib.technicalTasks.evision.services.impl;

import com.naguib.technicalTasks.evision.dto.DataValidationRequestDTO;
import com.naguib.technicalTasks.evision.services.DataHandlingService;
import com.naguib.technicalTasks.evision.services.DataValidationService;
import com.naguib.technicalTasks.evision.services.DecryptionService;
import com.naguib.technicalTasks.evision.services.JsonParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateDataServiceImpl implements DataValidationService {

    @Autowired
    DataHandlingService handlingService;
    @Autowired
    DecryptionService decryptionService;
    @Autowired
    JsonParserService jsonParserService;

    @Override
    public boolean isDataValid(DataValidationRequestDTO requestDto) {
        // Decrypt data
        String decryptedData = decryptionService.decryptData(requestDto.getData());

        // Save data to file so we can save release memory that is being held by that data object
        String fileName;
        try {
            fileName = handlingService.saveData(decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        // Release memory held by the sent data
        decryptedData = null;
        requestDto.setData(null);
        return jsonParserService.isValidJson(handlingService.getDataAsInputStream(fileName));

    }
}
