package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.weapon.Weapon;

public class Defender extends Warrior {
    private int defense = 3;
    private int defaultHealth = 60;
    private final int priority = 2;

    @Override
    public int getPriority() {
        return priority;
    }

    public Defender() {
        setHealth(defaultHealth);
        int defaultAttack = 2;
        setAttack(defaultAttack);
        setDefense(defense);

    }

    protected int getDefense() {
        return defense;
    }

    private void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public int getDefaultHealth() {
        return defaultHealth;
    }

    @Override
    void getDamage(Warrior attacker, Warrior defender) {
        if (attacker.getAttack() > defense) {
            defender.setHealth(defender.getHealth() - attacker.getAttack() + defense);
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
