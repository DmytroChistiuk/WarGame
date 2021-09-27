package com.company.gameSoftServe.entity;

public class Defender extends Warrior {
    public Defender() {
        setHealth(60);
        setAttack(2);
        setDefense(3);
        setIs_alive(true);
    }

    @Override
    void getDamage(Warrior attacker, Warrior defender) {
        if(attacker.getAttack() > defender.getDefense()) {
            defender.setHealth(defender.getHealth() - attacker.getAttack() + defender.getDefense());
        }else {
            System.out.println("Didn't strike!");
        }
    }

    @Override
    public void attack(Warrior defender, Warrior takingDamage) {
        takingDamage.getDamage(defender,takingDamage);
    }
}
