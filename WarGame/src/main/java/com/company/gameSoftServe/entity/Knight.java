package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.weapon.Weapon;

public class Knight extends Warrior {
    private int defaultHealth = 50;
    private final int priority = 2;

    @Override
    public int getPriority() {
        return priority;
    }

    public Knight() {
        setHealth(defaultHealth);
        int defaultAttack = 7;
        setAttack(defaultAttack);

    }

    @Override
    public int getDefaultHealth() {
        return defaultHealth;
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
        if (this.defaultHealth<0){
            this.defaultHealth = 0;
        }
        if (this.getAttack()<0){
            this.setAttack(0);
        }
    }


}
