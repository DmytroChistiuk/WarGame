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

}