package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.weapon.Weapon;

public class Healer extends Warrior {
    private int healPower = 2;
    private int defaultHealth = 50;
    private final int priority = 4;

    @Override
    public int getPriority() {
        return priority;
    }

    public int getHealPower() {
        return healPower;
    }

    public Healer() {
        setHealth(defaultHealth);
        int defaultAttack = 0;
        setAttack(defaultAttack);
    }

    @Override
    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void heal(Warrior healer, Warrior injuredHero) {
        injuredHero.setHealth(injuredHero.getHealth() + healPower);
        if (injuredHero.getHealth() > injuredHero.getDefaultHealth()) {
            injuredHero.setHealth(injuredHero.getDefaultHealth());
        }
    }

    @Override
    public Warrior equipWeapon(Weapon weapon) {
        this.setHealth(weapon.getHEALTH_EFFECT() + this.getHealth());
        this.setAttack(weapon.getATTACK_EFFECT() + this.getAttack());
        this.healPower += weapon.getHEAL_POWER_EFFECT();
        this.defaultHealth += weapon.getHEALTH_EFFECT();
        weaponLimit();
        return this;
    }

    private void weaponLimit() {
        if (this.defaultHealth < 0) {
            this.defaultHealth = 0;
        }
        this.setAttack(0);
        if (this.healPower < 0) {
            this.healPower = 0;
        }
    }
}
