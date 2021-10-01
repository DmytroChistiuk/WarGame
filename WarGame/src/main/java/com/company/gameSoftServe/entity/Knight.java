package com.company.gameSoftServe.entity;

public class Knight extends Warrior {

    public Knight() {
        int defaultHealth = 50;
        setHealth(defaultHealth);
        int defaultAttack = 7;
        setAttack(defaultAttack);
        setIs_alive(true);
    }

}
