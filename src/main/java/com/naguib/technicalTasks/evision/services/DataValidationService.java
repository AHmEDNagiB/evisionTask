package com.naguib.technicalTasks.evision.services;

import com.naguib.technicalTasks.evision.dto.DataValidationRequestDTO;

public interface DataValidationService {
    boolean isDataValid(DataValidationRequestDTO requestDto);
}
