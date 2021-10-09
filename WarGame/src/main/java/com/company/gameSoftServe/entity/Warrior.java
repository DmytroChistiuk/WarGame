package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.collection.ArmyImpl;
import com.company.gameSoftServe.weapon.Weapon;

public class Warrior extends Hero {
    private int defaultHealth = 50;
    private final int priority = 2;

    public int getPriority() {
        return priority;
    }

    public Warrior() {
        setHealth(defaultHealth);
        int defaultAttack = 5;
        setAttack(defaultAttack);
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

    @Override
    public Warrior equipWeapon(Weapon weapon) {
        this.setHealth(weapon.getHEALTH_EFFECT() + this.getHealth());
        this.setAttack(weapon.getATTACK_EFFECT() + this.getAttack());
        this.defaultHealth += weapon.getHEALTH_EFFECT();
        weaponLimit();
        return this;
    }

    private void weaponLimit() {
        if (this.defaultHealth < 0) {
            this.defaultHealth = 0;
        }
        if (this.getAttack() < 0) {
            this.setAttack(0);
        }
    }
}
