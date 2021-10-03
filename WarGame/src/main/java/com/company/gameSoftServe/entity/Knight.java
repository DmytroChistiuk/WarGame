package com.company.gameSoftServe.entity;

public class Knight extends Warrior {
    private int defaultHealth = 50;

    public Knight() {
        setHealth(defaultHealth);
        int defaultAttack = 7;
        setAttack(defaultAttack);
        setIs_alive(true);
    }

    @Override
    public int getDefaultHealth() {
        return defaultHealth;
    }


}
