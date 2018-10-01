package com.example.arena.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tournament")
public class TournamentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private final Integer capacity;
    private final Integer points;

}