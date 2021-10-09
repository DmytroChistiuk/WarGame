package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.weapon.Weapon;

public class Warlord extends Warrior {
    private int defaultHealth = 100;
    private int defense = 2;
    private final int priority = 1;


    public Warlord() {
        setHealth(defaultHealth);
        int defaultAttack = 4;
        setAttack(defaultAttack);

    }

    private void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public int getDefaultHealth() {
        return defaultHealth;
    }

    @Override
    void getDamage(Warrior attacker, Warrior warlord) {
        if (attacker.getAttack() > defense) {
            warlord.setHealth(warlord.getHealth() - attacker.getAttack() + defense);
        } else {
            System.out.println("Didn't strike!");
        }
    }

    @Override
    public void attack(Warrior defender, Warrior takingDamage) {
        takingDamage.getDamage(defender, takingDamage);
    }

    @Override
    public Warrior equipWeapon(Weapon weapon) {
        this.setHealth(weapon.getHEALTH_EFFECT() + this.getHealth());
        this.setAttack(weapon.getATTACK_EFFECT() + this.getAttack());
        this.defense += weapon.getDEFENSE_EFFECT();
        this.defaultHealth += weapon.getHEALTH_EFFECT();
        weaponLimit();
        return this;
    }

    public int getPriority() {
        return priority;
    }

    private void weaponLimit() {
        if (this.defaultHealth < 0) {
            this.defaultHealth = 0;
        }
        if (this.getAttack() < 0) {
            this.setAttack(0);
        }
        if (this.defense < 0) {
            this.defense = 0;
        }
    }
}

