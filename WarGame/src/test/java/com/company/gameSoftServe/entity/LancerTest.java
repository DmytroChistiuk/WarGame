package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.collection.ArmyImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancerTest {

    @Test
    void constrTest() {
        Lancer lancer = new Lancer();
        assertEquals(lancer.getHealth(), 50);
        assertEquals(lancer.getAttack(), 6);
        assertTrue(lancer.getIs_alive());
    }

    @DisplayName("Simple lancer attack to 1 enemy")
    @Test
    void attack() {
        Warrior warrior = new Warrior();
        Lancer lancer = new Lancer();
        lancer.attack(lancer,warrior);
        assertEquals(warrior.getDefaultHealth()-lancer.getAttack(),warrior.getHealth());
    }

    @DisplayName("Lancer attack to 2 enemy, second should have 50% of default lancer's attack")
    @Test
    void testAttack() throws ReflectiveOperationException {
        Lancer lancer = new Lancer();
        ArmyImpl army = new ArmyImpl();
        army.addUnits(Warrior.class,2);
        lancer.attack(lancer,army);
        assertEquals(army.getByIndex(0).getDefaultHealth()-lancer.getAttack(),army.getByIndex(0).getHealth());
        assertEquals(army.getByIndex(1).getDefaultHealth()-(lancer.getAttack()/2),army.getByIndex(1).getHealth());
    }
}