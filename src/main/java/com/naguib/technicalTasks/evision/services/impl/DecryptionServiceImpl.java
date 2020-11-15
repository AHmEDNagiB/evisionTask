package com.naguib.technicalTasks.evision.services.impl;

import com.naguib.technicalTasks.evision.services.DecryptionService;
import org.springframework.stereotype.Service;

@Service
public class DecryptionServiceImpl implements DecryptionService {
    @Override
    public String decryptData(String data) {
        /*Here should be impl of any decryption required*/
        return data;
    }
}
