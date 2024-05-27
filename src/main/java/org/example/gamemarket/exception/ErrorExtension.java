package org.example.gamemarket.exception;

import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
public class ErrorExtension {
    String message;
    HttpStatus errorCode;
}
