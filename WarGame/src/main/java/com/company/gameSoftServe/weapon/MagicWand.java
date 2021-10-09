package com.company.gameSoftServe.weapon;

public class MagicWand extends Weapon {

    public MagicWand() {
        final int HEALTH_EFFECT = 30;
        final int ATTACK_EFFECT = 3;
        final int HEAL_POWER_EFFECT = 3;
        setHEALTH_EFFECT(HEALTH_EFFECT);
        setATTACK_EFFECT(ATTACK_EFFECT);
        setHEAL_POWER_EFFECT(HEAL_POWER_EFFECT);
    }

}
