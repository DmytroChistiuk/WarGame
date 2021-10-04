package com.company.gameSoftServe.entity;

public abstract class Hero {
    private int health;
    private int attack;
    private boolean is_alive;

    public abstract void attack(Warrior attacker, Warrior takingDamage);

    public int getHealth() {
        return health;
    }

    void setHealth(int health) {
        this.health = health;
    }

    int getAttack() {
        return attack;
    }

    void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean getIs_alive() {
        return is_alive;
    }

    public void setIs_alive(boolean is_alive) {
        this.is_alive = is_alive;
    }

}
