package com.example.arena.model;

import com.example.arena.model.AttackResult;

public interface Fightable {

    AttackResult attack();

    AttackResult dodge(AttackResult attackResult);

}
