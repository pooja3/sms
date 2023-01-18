package com.java.student.sms.utils;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(value = NullPointerException.class)
    public void nullPointerExceptionHandler(Model model) {
        model.addAttribute("service-message", "Null Pointer exception has occurred");
    }

    @ExceptionHandler(value = DataAccessException.class)
    public String dataAccessExceptionHandler() {
        return "Something went wrong with sql query";
    }
}
