package com.example.arena;

public interface Fightable {

    AttackResult attack();

    AttackResult dodge(AttackResult attackResult);

}
