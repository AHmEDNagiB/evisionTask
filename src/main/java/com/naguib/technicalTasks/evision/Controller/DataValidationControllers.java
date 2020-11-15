package com.naguib.technicalTasks.evision.Controller;

import com.naguib.technicalTasks.evision.dto.DataValidationRequestDTO;
import com.naguib.technicalTasks.evision.dto.ResponseDTO;
import com.naguib.technicalTasks.evision.services.DataValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@RestController
@RequestMapping(value = "/validate")
public class DataValidationControllers {

    private DataValidationService validateDataService;

    @Autowired
    public DataValidationControllers(DataValidationService validateDataService) {
        this.validateDataService = validateDataService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<String>> validateDate(@RequestBody @NotNull DataValidationRequestDTO requestDto,
                                                            HttpServletResponse httpResponse) throws IOException {
        boolean isDataValid = validateDataService.isDataValid(requestDto);
        if (isDataValid) {
            return new ResponseEntity(new ResponseDTO<>("Your data is valid.."), HttpStatus.OK);
        }
        httpResponse.sendRedirect("/invalid-request");
        return null;

    }


}
