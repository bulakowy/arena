package com.example.arena.model;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class TournamentParams {

    @NotNull
    private Integer capacity;
    @NotNull
    private Integer points;

}
