package com.company.gameSoftServe.entity;

public abstract class Hero {
    private int health;
    private int attack;
    private int defense;
    private boolean is_alive;

    public abstract void getDamage(Warrior attacker, Warrior takingDamage);

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public boolean getIs_alive() {
        return is_alive;
    }

    public void setIs_alive(boolean is_alive) {
        this.is_alive = is_alive;
    }
}
