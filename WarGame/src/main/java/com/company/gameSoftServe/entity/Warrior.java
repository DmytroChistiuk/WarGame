package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.actions.ArmyImpl;

public class Warrior extends Hero {

    public Warrior() {
        int defaultHealth = 50;
        setHealth(defaultHealth);
        int defaultAttack = 5;
        setAttack(defaultAttack);
        setIs_alive(true);
    }

    void getDamage(Warrior attacker, Warrior warrior) {
        warrior.setHealth(warrior.getHealth() - attacker.getAttack());
    }

    public void attack(Warrior warrior, ArmyImpl takingDamage) {
    }

    @Override
    public void attack(Warrior warrior, Warrior takingDamage) {
        takingDamage.getDamage(warrior, takingDamage);
    }

}
