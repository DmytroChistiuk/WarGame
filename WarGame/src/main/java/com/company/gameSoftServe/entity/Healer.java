package com.company.gameSoftServe.entity;

public class Healer extends Warrior {
    private int healPower = 2;

    public int getHealPower() {
        return healPower;
    }

    public Healer() {
        int defaultHealth = 50;
        setHealth(defaultHealth);
        int defaultAttack = 0;
        setAttack(defaultAttack);
        setIs_alive(true);
    }

    public void heal(Warrior healer, Warrior injuredHero) {
        injuredHero.setHealth(injuredHero.getHealth()+healPower);
        if(injuredHero.getHealth()>injuredHero.getDefaultHealth()){
            injuredHero.setHealth(injuredHero.getDefaultHealth());
        }
    }
}
