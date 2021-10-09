package com.company.gameSoftServe.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WarriorTest {

    @Test
    void constrTest() {
        Warrior carl = new Warrior();
        assertEquals(carl.getHealth(), 50);
        assertEquals(carl.getAttack(), 5);
        assertTrue(carl.getIs_alive());
    }

    @Test
    void getDamage() {
        Warrior warrior1 = new Warrior();
        Warrior warrior2 = new Warrior();
        warrior1.getDamage(warrior2, warrior1);
        assertEquals(warrior1.getHealth(), 45);
    }



}