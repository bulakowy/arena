package com.example.arena;

public class FightService {

    void fight(Fightable f1, Fightable f2) {
        System.out.println("Starting a fight between " + f1 + " and " + f2);
        while (f1.isAlive() && f2.isAlive()) {
            attack(f1, f2);
            if (f2.isAlive()) {
                attack(f2, f1);
            }
        }
    }

    private void attack(Fightable f1, Fightable f2) {
        int potentialDamage = f1.attack();
        if (potentialDamage > 0) {
            f2.dodge(potentialDamage);
        }
    }
}
