package com.company.gameSoftServe.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    @Test
    void constrTest() {
        Knight bob = new Knight();
        assertEquals(bob.getHealth(), 50);
        assertEquals(bob.getAttack(), 7);
        assertTrue(bob.getIs_alive());
    }
    @Test
    void getDamage() {
        Warrior warrior1 = new Warrior();
        Knight warrior2 = new Knight();
        warrior1.getDamage(warrior2, warrior1);
        assertEquals(warrior1.getHealth(), 43);
    }

}