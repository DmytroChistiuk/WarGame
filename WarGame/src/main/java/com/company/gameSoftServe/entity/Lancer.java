package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.actions.ArmyImpl;

public class Lancer extends Warrior implements DoublePunch {
    private static final int SECOND_DAMAGE_PERCENT = 50;

    public Lancer() {
        int defaultHealth = 50;
        setHealth(defaultHealth);
        int defaultAttack = 6;
        setAttack(defaultAttack);
        setIs_alive(true);

    }

    @Override
    void getDamage(Warrior attacker, Warrior lancer) {
        lancer.setHealth(lancer.getHealth() - attacker.getAttack());
    }

    @Override
    public void attack(Warrior warrior, Warrior takingDamage) {
        takingDamage.getDamage(warrior, takingDamage);
    }

    @Override
    public void attack(Warrior warrior, ArmyImpl takingDamageArmy) {
        warrior.attack(warrior, takingDamageArmy.getByIndex(0));
        Warrior warrior1 = takingDamageArmy.getByIndex(1);
        warrior.attack(warrior, warrior1);
        warrior1.setHealth(warrior1.getHealth() + ((warrior.getAttack() * SECOND_DAMAGE_PERCENT) / 100));
        if (takingDamageArmy.getByIndex(1).getHealth() <= 0) {
            takingDamageArmy.remove(1);
        }
        if (takingDamageArmy.getByIndex(0).getHealth() <= 0) {
            takingDamageArmy.remove(0);
        }
    }
}
