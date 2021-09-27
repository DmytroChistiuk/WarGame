package com.company.gameSoftServe.entity;

public class Warrior extends Hero {

    public Warrior() {
        setHealth(50);
        setAttack(5);
        setIs_alive(true);
    }

    void getDamage(Warrior attacker, Warrior warrior) {
        warrior.setHealth(warrior.getHealth() - attacker.getAttack());
    }

    @Override
    public void attack(Warrior warrior, Warrior takingDamage) {
        takingDamage.getDamage(warrior, takingDamage);
    }

}
