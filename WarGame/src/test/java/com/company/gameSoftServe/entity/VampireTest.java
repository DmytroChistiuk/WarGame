package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.BattleImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Vampire don't restore health from damage when healthy")
    void Test1() {
        int vampireHealth = vampire.getHealth();
        vampire.attack(vampire, warrior);
        int vampireHealthAfterAttack = vampire.getHealth();
        assertEquals(vampireHealthAfterAttack, vampireHealth);
    }

    @Test
    @DisplayName("Vampire restore health by fifty percent from damage to warrior")
    void Test2() {
        vampire.setHealth(20);
        int vampireHealth = vampire.getHealth();
        vampire.attack(vampire, warrior);
        assertEquals(vampireHealth + vampire.getAttack() / 2, vampire.getHealth());
    }

    @Test
    @DisplayName("Vampire restore health by fifty percent from damage to defender")
    void Test3() {
        vampire.setHealth(20);
        int vampireHealth = vampire.getHealth();
        vampire.attack(vampire, warrior);
        assertEquals(vampireHealth + (vampire.getAttack() - bob.getDefense()) / 2, vampire.getHealth());
    }

}