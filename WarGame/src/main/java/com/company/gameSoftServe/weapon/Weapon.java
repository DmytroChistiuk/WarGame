package com.company.gameSoftServe.weapon;

public class Weapon {
    private int HEALTH_EFFECT;
    private int ATTACK_EFFECT;
    private int DEFENSE_EFFECT;
    private int VAMPIRISM_EFFECT;
    private int HEAL_POWER_EFFECT;

    public Weapon() {
        HEALTH_EFFECT = 0;
        ATTACK_EFFECT = 0;
        DEFENSE_EFFECT = 0;
        VAMPIRISM_EFFECT = 0;
        HEAL_POWER_EFFECT = 0;
    }

    public Weapon(int HEALTH_EFFECT, int ATTACK_EFFECT, int DEFENSE_EFFECT, int VAMPIRISM_EFFECT, int HEAL_POWER_EFFECT) {
        this.HEALTH_EFFECT = HEALTH_EFFECT;
        this.ATTACK_EFFECT = ATTACK_EFFECT;
        this.DEFENSE_EFFECT = DEFENSE_EFFECT;
        this.VAMPIRISM_EFFECT = VAMPIRISM_EFFECT;
        this.HEAL_POWER_EFFECT = HEAL_POWER_EFFECT;
    }

    public int getHEALTH_EFFECT() {
        return HEALTH_EFFECT;
    }

    public void setHEALTH_EFFECT(int HEALTH_EFFECT) {
        this.HEALTH_EFFECT = HEALTH_EFFECT;
    }

    public int getATTACK_EFFECT() {
        return ATTACK_EFFECT;
    }

    public void setATTACK_EFFECT(int ATTACK_EFFECT) {
        this.ATTACK_EFFECT = ATTACK_EFFECT;
    }

    public int getDEFENSE_EFFECT() {
        return DEFENSE_EFFECT;
    }

    public void setDEFENSE_EFFECT(int DEFENSE_EFFECT) {
        this.DEFENSE_EFFECT = DEFENSE_EFFECT;
    }

    public int getVAMPIRISM_EFFECT() {
        return VAMPIRISM_EFFECT;
    }

    public void setVAMPIRISM_EFFECT(int VAMPIRISM_EFFECT) {
        this.VAMPIRISM_EFFECT = VAMPIRISM_EFFECT;
    }

    public int getHEAL_POWER_EFFECT() {
        return HEAL_POWER_EFFECT;
    }

    public void setHEAL_POWER_EFFECT(int HEAL_POWER_EFFECT) {
        this.HEAL_POWER_EFFECT = HEAL_POWER_EFFECT;
    }
}
