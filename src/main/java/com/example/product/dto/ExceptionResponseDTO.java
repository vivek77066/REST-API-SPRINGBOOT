package com.example.product.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExceptionResponseDTO {

    private String apipath;
    private HttpStatus httpCode;
    private String errorMessage;
    private LocalDateTime errortime;

    public String getApipath() {
        return apipath;
    }

    public ExceptionResponseDTO() {
    }

    public ExceptionResponseDTO(String apipath, HttpStatus httpCode, String errorMessage, LocalDateTime errortime) {
        this.apipath = apipath;
        this.httpCode = httpCode;
        this.errorMessage = errorMessage;
        this.errortime = errortime;
    }

    public void setApipath(String apipath) {
        this.apipath = apipath;
    }

    public HttpStatus getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(HttpStatus httpCode) {
        this.httpCode = httpCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getErrortime() {
        return errortime;
    }

    public void setErrortime(LocalDateTime errortime) {
        this.errortime = errortime;
    }
}
