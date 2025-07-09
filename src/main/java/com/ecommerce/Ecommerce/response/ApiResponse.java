package com.ecommerce.Ecommerce.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
public class ApiResponse<T> {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private T data;
    private Map<String, String> errors;

    private ApiResponse(int status, String message, T data, Map<String, String> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.data = data;
        this.errors = errors;
    }

    public static <T> ApiResponse<T> generateResponse(int status, String message, T data, Map<String, String> errors) {
        return new ApiResponse<>(status, message, data, errors);
    }
}
