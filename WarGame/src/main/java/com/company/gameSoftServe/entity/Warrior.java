package com.company.gameSoftServe.entity;

public class Warrior extends Hero {

    public Warrior() {
        setHealth(50);
        setAttack(5);
        setIs_alive(true);
    }

    @Override
      public void getDamage(Warrior attacker, Warrior takingDamage) {
        takingDamage.setHealth(takingDamage.getHealth() - attacker.getAttack());
    }
}
