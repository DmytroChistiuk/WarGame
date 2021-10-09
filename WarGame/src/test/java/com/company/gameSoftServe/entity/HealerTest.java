package com.company.gameSoftServe.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HealerTest {
    @Test
    void constrTest() {
        Healer healer = new Healer();
        assertEquals(healer.getHealth(), 50);
        assertEquals(healer.getAttack(), 0);
        assertEquals(healer.getHealPower(), 2);
        assertTrue(healer.getIs_alive());
    }

    @DisplayName("Healer should heal warriors on healer's heal power")
    @Test
    void heal1() {
        Healer healer = new Healer();
        Warrior warrior = new Warrior();
        warrior.attack(warrior,warrior);
        healer.heal(healer,warrior);
        assertEquals(warrior.getDefaultHealth()-warrior.getAttack()+healer.getHealPower(),warrior.getHealth());
    }

    @DisplayName("Healer shouldn't heal warrior with full heal points")
    @Test
    void heal2() {
        Healer healer = new Healer();
        Warrior warrior = new Warrior();
        healer.heal(healer,warrior);
        assertEquals(warrior.getDefaultHealth(),warrior.getHealth());
    }


}