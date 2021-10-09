package com.company.gameSoftServe.weapon;

public class Shield extends Weapon {

    public Shield() {
        final int HEALTH_EFFECT = 20;
        final int ATTACK_EFFECT = -1;
        final int DEFENSE_EFFECT = 2;
        setHEALTH_EFFECT(HEALTH_EFFECT);
        setATTACK_EFFECT(ATTACK_EFFECT);
        setDEFENSE_EFFECT(DEFENSE_EFFECT);
    }

}
