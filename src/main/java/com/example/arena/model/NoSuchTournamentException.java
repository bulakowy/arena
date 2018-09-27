package com.example.arena.model;

import lombok.Value;

@Value
public class NoSuchTournamentException extends RuntimeException {

    private int id;
}
