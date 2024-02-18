package com.airbnb.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MyErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;
}
