package com.company.gameSoftServe.entity;

public class Vampire extends Warrior {
    private int defaultHealth = 40;
    private int defaultVampirism = 50;

    public Vampire() {
        setHealth(defaultHealth);
        int defaultAttack = 4;
        setAttack(defaultAttack);
        setVampirism(defaultVampirism);
        setIs_alive(true);
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

}
