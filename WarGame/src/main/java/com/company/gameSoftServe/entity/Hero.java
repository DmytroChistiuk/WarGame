package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.weapon.Weapon;

public abstract class Hero {
    private int health;
    private int attack;

    protected abstract void attack(Warrior attacker, Warrior takingDamage);

    protected abstract Warrior equipWeapon(Weapon weapon);

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
        if (health > 0)
            return true;
        else
            return false;
    }


}
