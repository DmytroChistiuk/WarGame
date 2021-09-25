package com.company.gameSoftServe.entity;

public class Defender extends Warrior {
    public Defender() {
        setHealth(60);
        setAttack(2);
        setDefense(3);
        setIs_alive(true);
    }

    @Override
    public void getDamage(Warrior attacker, Warrior takingDamage) {
        if(attacker.getAttack() > takingDamage.getDefense()) {
            takingDamage.setHealth(takingDamage.getHealth() - attacker.getAttack() + takingDamage.getDefense());
        }else {
            System.out.println("Didn't strike!");
        }
    }

}
