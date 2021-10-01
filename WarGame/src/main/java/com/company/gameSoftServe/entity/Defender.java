package com.company.gameSoftServe.entity;

public class Defender extends Warrior {
    private int defense = 3;

    public Defender() {
        int defaultHealth = 60;
        setHealth(defaultHealth);
        int defaultAttack = 2;
        setAttack(defaultAttack);
        setDefense(defense);
        setIs_alive(true);
    }

    int getDefense() {
        return defense;
    }

    private void setDefense(int defense) {
        this.defense = defense;
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
}
