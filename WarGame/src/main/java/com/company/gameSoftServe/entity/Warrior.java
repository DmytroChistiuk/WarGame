package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.collection.ArmyImpl;

public class Warrior extends Hero {
    private int defaultHealth = 50;

    public Warrior() {
        setHealth(defaultHealth);
        int defaultAttack = 5;
        setAttack(defaultAttack);
        setIs_alive(true);
    }

    public int getDefaultHealth() {
        return defaultHealth;
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
