package com.naguib.technicalTasks.evision.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DataValidationRequestDTO {

    @NotNull
    @NotBlank
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
