package com.company.gameSoftServe.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefenderTest {
    @Test
    void constrTest() {
        Defender slava = new Defender();
        assertEquals(slava.getHealth(), 60);
        assertEquals(slava.getAttack(), 2);
        assertEquals(slava.getDefense(), 3);
        assertTrue(slava.getIs_alive());
    }
    @Test
    void getDamage() {
        Defender warrior1 = new Defender();
        Warrior warrior2 = new Warrior();
        warrior1.getDamage(warrior2, warrior1);
        assertEquals(warrior1.getHealth(), 58);
    }
}