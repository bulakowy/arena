package com.example.arena.controller;

import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
class ArenaApiError {

    private HttpStatus status;
    private String message;
    private String debugMessage;

}