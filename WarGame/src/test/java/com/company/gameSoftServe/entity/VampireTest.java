package com.company.gameSoftServe.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

class VampireTest {
    private Warrior warrior;
    private Vampire vampire;
    private Defender bob;
    private BattleImp battle;


    @BeforeEach
    void beforeTestFunction() {
        warrior = new Warrior();
        vampire = new Vampire();
        bob = new Defender();

        battle = new BattleImp();
    }

    @Test
    void constrTest() {
        assertEquals(vampire.getHealth(), 40);
        assertEquals(vampire.getVampirism(), 50);
        assertEquals(vampire.getAttack(), 4);
        assertTrue(vampire.getIs_alive());

    }

    @Test
    void vampire_dont_restore_health_from_damage_when_healthy() {
        int vampireHealth = vampire.getHealth();
        vampire.attack(vampire, warrior);
        int vampireHealthAfterAttack = vampire.getHealth();
        assertEquals(vampireHealthAfterAttack, vampireHealth);
    }

    @Test
    void vampire_restore_health_by_fifty_percent_from_damage_to_warrior() {
        vampire.setHealth(20);
        int vampireHealth = vampire.getHealth();
        vampire.attack(vampire, warrior);
        assertEquals(vampireHealth + vampire.getAttack() / 2, vampire.getHealth());
    }

    @Test
    void vampire_restore_health_by_fifty_percent_from_damage_to_defender() {
        vampire.setHealth(20);
        int vampireHealth = vampire.getHealth();
        vampire.attack(vampire, warrior);
        assertEquals(vampireHealth + (vampire.getAttack() - bob.getDefense()) / 2, vampire.getHealth());
    }

}