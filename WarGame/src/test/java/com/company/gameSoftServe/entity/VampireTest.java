package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.actions.BattleImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

class VampireTest {
    private Warrior warrior;
    private Warrior vampire;
    private BattleImp battle;

    @BeforeEach
    void beforeTestFunction() {
        warrior = new Warrior();
        vampire = new Vampire();

        battle = new BattleImp();
    }

    @Test
    void vampire_shouldnt_restore_health_from_damage_when_healthy() {
        int vampireHealth = vampire.getHealth();
        vampire.attack(vampire, warrior);
        int vampireHealthAfterAttack = vampire.getHealth();
        assertEquals(vampireHealthAfterAttack, vampireHealth);
    }

    @Test
    void vampire_should_restore_health_by_fifty_percent_from_damage_to_Warrior() {
        vampire.setHealth(20);
        int vampireHealth = vampire.getHealth();
        vampire.attack(vampire, warrior);
        assertEquals(vampireHealth + vampire.getAttack() / 2, vampire.getHealth());
    }

    @Test
    void vampire_should_restore_health_by_fifty_percent_from_damage_to_Defender() {
        warrior = new Defender();
        vampire.setHealth(20);
        int vampireHealth = vampire.getHealth();
        vampire.attack(vampire, warrior);
        assertEquals(vampireHealth + (vampire.getAttack() - warrior.getDefense()) / 2, vampire.getHealth());
    }

}