package com.example.arena.controller;

import com.example.arena.data.TournamentDto;
import com.example.arena.data.TournamentRepository;
import com.example.arena.model.NoSuchTournamentException;
import com.example.arena.model.creature.Creature;
import com.example.arena.model.creature.CreatureParams;
import com.example.arena.model.Tournament;
import com.example.arena.model.TournamentParams;
import com.example.arena.service.CreatureFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FightController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private CreatureFactory creatureFactory;

    private List<Tournament> tournaments = new ArrayList<>();

    @PostMapping("/tournaments")
    public TournamentDto addNewTournament(@RequestBody @Valid TournamentParams tournamentParams) {
        TournamentDto t = new TournamentDto(tournamentParams.getCapacity(), tournamentParams.getPoints());
        return tournamentRepository.save(t);
    }

    @PostMapping("/tournaments2")
    public String addNewTournament2(@RequestParam int capacity, @RequestParam int points) {
        Tournament t = new Tournament(capacity, points, tournaments.size() + 1);
        return addTournament(t);
    }

    @GetMapping("/tournaments")
    public List<Tournament> getTournamets() {
        return tournaments;
    }

    @GetMapping("/tournaments/{id}")
    public Tournament getTournament(@PathVariable int id) {
        return tournaments.get(id);
    }

    @GetMapping("/tournaments/{id}/capacity")
    public String getTournamentCapacity(@PathVariable int id) {
        Tournament t = tournaments.get(id);
        if (t == null) {
            return "No such tournament";
        }
        return String.format("Capacity: %d, slots already taken: %d",
                t.getCapacity(), t.getCapacity() - t.getFighters().size());
    }

    @GetMapping("/tournaments/{id}/points")
    public String getTournamentPoints(@PathVariable int id) {
        Tournament t = null;
        try {
            t = tournaments.get(id);
        } catch (Exception e) {
            throw new NoSuchTournamentException(id);
        }
        return String.format("Points: %d", t.getPoints());
    }

    @GetMapping("/tournaments/points")
    public String getTournamentPointsByRequestParam(@RequestParam int id) {
        Tournament t = tournaments.get(id);
        if (t == null) {
            return "No such tournament";
        }
        return String.format("Points: %d", t.getPoints());
    }

    @PostMapping("/tournaments/{tournamentId}/fighters")
    public String addFighter(@PathVariable int tournamentId, @RequestBody CreatureParams creatureParams) {
        Tournament t = tournaments.get(tournamentId);
        if (t == null) {
            return "No such tournament";
        }
        Creature c = creatureFactory.newCreature(creatureParams);
        return "Fighter successfully added to the tournament";
    }

    @PostMapping("/tournaments/{id}/start")
    public String startTournament(@PathVariable int id) {
        Tournament t = tournaments.get(id);
        if (t == null) {
            return "No such tournament";
        }

        return "Not implemented yet";
    }

    private String addTournament(Tournament t) {
        tournaments.add(t);
        return String.format("New tournament successfully created. Capacity: %d. Points: %d. Tournament id: %d.",
                t.getCapacity(), t.getPoints(), t.getId());
    }

}
