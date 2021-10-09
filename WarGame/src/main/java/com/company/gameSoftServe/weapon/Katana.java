package com.company.gameSoftServe.weapon;

public class Katana extends Weapon {

    public Katana() {
        final int HEALTH_EFFECT = -20;
        final int ATTACK_EFFECT = 6;
        final int DEFENSE_EFFECT = -5;
        final int VAMPIRISM_EFFECT = 50;
        setHEALTH_EFFECT(HEALTH_EFFECT);
        setATTACK_EFFECT(ATTACK_EFFECT);
        setDEFENSE_EFFECT(DEFENSE_EFFECT);
        setVAMPIRISM_EFFECT(VAMPIRISM_EFFECT);
    }

}
