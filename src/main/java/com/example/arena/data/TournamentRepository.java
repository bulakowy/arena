package com.example.arena.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends CrudRepository<TournamentDto, Integer> {
}

