package com.ticketbooking.globalexception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Utility class for creating standardized response entities.
 */
public class Message {

    /**
     * Creates a success response entity with optional data.
     *
     * @param data The data to include in the response.
     * @return ResponseEntity representing a successful response.
     */
    public static ResponseEntity<?> success(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "success");
        if (data != null)
            map.put("data", data);
        return ResponseEntity.ok(map);
    }

    /**
     * Creates an error response entity with optional error details.
     *
     * @param err The error details to include in the response.
     * @return ResponseEntity representing an error response.
     */
    public static ResponseEntity<?> error(Object err) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "error");
        if (err != null)
            map.put("error", err);
       System.out.println(map);
        return (ResponseEntity<?>) ResponseEntity.badRequest();
    }

    /**
     * Creates a response entity with a specified HTTP status.
     *
     * @param status The HTTP status to set for the response.
     * @return ResponseEntity with the specified HTTP status.
     */
    public static ResponseEntity<?> status(HttpStatus status) {
        return ResponseEntity.status(status).build();
    }
}

