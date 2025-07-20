package com.exconnect.urlshortner.controller;

import com.exconnect.urlshortner.exception.UrlNotShortened;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // or @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(UrlNotShortened.class)
    public ResponseEntity<Map<String, Object>> handleMyCustomException(UrlNotShortened ex) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("error", "short Url not available");
        errorBody.put("message", ex.getMessage());
        errorBody.put("timestamp", LocalDateTime.now());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorBody);
    }

    // Optional: handle all other unhandled exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("error", "Internal Server Error");
        errorBody.put("message", ex.getMessage());
        errorBody.put("timestamp", LocalDateTime.now());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorBody);
    }
}
