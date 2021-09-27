package com.company.gameSoftServe.actions;

import com.company.gameSoftServe.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BattleImpTest {
    private Warrior carl;
    private Warrior ramon;
    private Warrior bob;
    private Warrior zeus;
    private Warrior husband;
    private Warrior dragon;
    private Warrior jim;
    private Warrior slevin;
    private Warrior mars;
    private Warrior godkiller;
    private Warrior wife;
    private Warrior knight;
    private Warrior unit_1;
    private Warrior unit_2;
    private Warrior unit_3;
    private Warrior vampire;
    private Warrior defender;

    private ArmyImpl firstArmyImpl;
    private ArmyImpl secondArmyImpl;
    private BattleImp battle;


    @BeforeEach
    void beforeTestFunction() throws ReflectiveOperationException {
        carl = new Warrior();
        jim = new Knight();
        ramon = new Knight();
        slevin = new Warrior();
        bob = new Warrior();
        mars = new Warrior();
        zeus = new Knight();
        godkiller = new Warrior();
        husband = new Warrior();
        wife = new Warrior();
        dragon = new Warrior();
        knight = new Knight();
        unit_1 = new Warrior();
        unit_2 = new Knight();
        unit_3 = new Warrior();
        vampire = new Vampire();
        defender = new Defender();

        firstArmyImpl = new ArmyImpl();
        secondArmyImpl = new ArmyImpl();

        battle = new BattleImp();
    }


    @Test
    void Fight1() {
        boolean result = BattleImp.fight(carl, jim);
        assertFalse(result);
    }

    @Test
    void Fight2() {
        boolean result = BattleImp.fight(ramon, slevin);
        assertTrue(result);
    }

    @Test
    void Fight3() {
        BattleImp.fight(bob, mars);
        assertTrue(bob.getIs_alive());
    }

    @Test
    void Fight4() {
        BattleImp.fight(zeus, godkiller);
        assertTrue(zeus.getIs_alive());
    }

    @Test
    void Fight5() {
        BattleImp.fight(husband, wife);
        assertFalse(wife.getIs_alive());
    }

    @Test
    void Fight6() {
        BattleImp.fight(dragon, knight);
        assertTrue(knight.getIs_alive());
    }

    @Test
    void Fight7() {
        BattleImp.fight(unit_1, unit_2);
        boolean result = BattleImp.fight(unit_2, unit_3);
        assertFalse(result);
    }

    @Test
    void Fight8() {
        unit_1 = new Defender();
        boolean result = BattleImp.fight(unit_1, unit_2);
        assertFalse(result);
    }

    @Test
    void Fight9() {
        unit_1 = new Defender();
        boolean result = BattleImp.fight(unit_1, unit_3);
        assertTrue(result);
    }

    @Test
    void Fight10() {
        boolean result = BattleImp.fight(carl, vampire);
        assertTrue(result);
    }

    @Test
    void Fight11() {
        boolean result = BattleImp.fight(vampire, defender);
        assertFalse(result);
    }

    @Test
    void Fight12() {
        boolean result = BattleImp.fight(vampire, jim);
        assertFalse(result);
    }

    @Test
    void Battle1() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 1);
        secondArmyImpl.addUnits(Warrior.class, 2);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertFalse(result);
    }

    @Test
    void Battle2() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 2);
        secondArmyImpl.addUnits(Warrior.class, 3);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertFalse(result);
    }

    @Test
    void Battle3() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 5);
        secondArmyImpl.addUnits(Warrior.class, 7);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertFalse(result);
    }

    @Test
    void Battle4() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 20);
        secondArmyImpl.addUnits(Warrior.class, 21);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @Test
    void Battle5() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 10);
        secondArmyImpl.addUnits(Warrior.class, 11);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @Test
    void Battle6() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 11);
        secondArmyImpl.addUnits(Warrior.class, 7);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @Test
    void Battle7() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 5);
        firstArmyImpl.addUnits(Defender.class, 4);
        firstArmyImpl.addUnits(Warrior.class, 5);
        secondArmyImpl.addUnits(Warrior.class, 4);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @Test
    void Battle8() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Defender.class, 5);
        firstArmyImpl.addUnits(Warrior.class, 20);
        secondArmyImpl.addUnits(Warrior.class, 21);
        firstArmyImpl.addUnits(Defender.class, 4);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @Test
    void Battle9() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 10);
        firstArmyImpl.addUnits(Defender.class, 5);
        secondArmyImpl.addUnits(Warrior.class, 5);
        firstArmyImpl.addUnits(Defender.class, 10);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @Test
    void Battle10() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Defender.class, 2);
        firstArmyImpl.addUnits(Warrior.class, 1);
        firstArmyImpl.addUnits(Defender.class, 1);
        secondArmyImpl.addUnits(Warrior.class, 5);

        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertFalse(result);
    }


}