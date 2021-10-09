package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.weapon.Weapon;

public class Vampire extends Warrior {
    private int defaultHealth = 40;
    private int defaultVampirism = 50;
    private final int priority = 2;

    @Override
    public int getPriority() {
        return priority;
    }

    public Vampire() {
        setHealth(defaultHealth);
        int defaultAttack = 4;
        setAttack(defaultAttack);
        setVampirism(defaultVampirism);
    }

    public int getVampirism() {
        return defaultVampirism;
    }

    private void setVampirism(int defaultVampirism) {
        this.defaultVampirism = defaultVampirism;
    }

    @Override
    public int getDefaultHealth() {
        return defaultHealth;
    }

    @Override
    public void attack(Warrior vampire, Warrior takingDamage) {
        final int MAX_PERCENT = 100;
        int startHealth = takingDamage.getHealth();
        takingDamage.getDamage(vampire, takingDamage);
        int healthDifference = startHealth - takingDamage.getHealth();
        vampire.setHealth(vampire.getHealth() + (healthDifference * defaultVampirism) / MAX_PERCENT);
        if (vampire.getHealth() > defaultHealth) {
            vampire.setHealth(defaultHealth);
        }
    }

    @Override
    public Warrior equipWeapon(Weapon weapon) {
        this.setHealth(weapon.getHEALTH_EFFECT() + this.getHealth());
        this.setAttack(weapon.getATTACK_EFFECT() + this.getAttack());
        this.defaultHealth += weapon.getHEALTH_EFFECT();
        this.defaultVampirism += weapon.getVAMPIRISM_EFFECT();
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
        if (defaultVampirism < 0) {
            this.defaultVampirism = 0;
        }
    }


}
