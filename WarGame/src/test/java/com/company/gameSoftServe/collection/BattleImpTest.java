package com.company.gameSoftServe.collection;

import com.company.gameSoftServe.BattleImp;
import com.company.gameSoftServe.entity.*;
import com.company.gameSoftServe.exeption.HealerBattleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("fight between Warrior and Knight")
    @Test
    void Fight1() throws HealerBattleException {
        boolean result = BattleImp.fight(carl, jim);
        assertFalse(result);
    }

    @Test
    void Fight2() throws HealerBattleException {
        boolean result = BattleImp.fight(ramon, slevin);
        assertTrue(result);
    }

    @DisplayName("fight between Warrior and Warrior")
    @Test
    void Fight3() throws HealerBattleException {
        BattleImp.fight(bob, mars);
        assertTrue(bob.getIs_alive());
    }

    @Test
    void Fight4() throws HealerBattleException {
        BattleImp.fight(zeus, godkiller);
        assertTrue(zeus.getIs_alive());
    }

    @Test
    void Fight5() throws HealerBattleException {
        BattleImp.fight(husband, wife);
        assertFalse(wife.getIs_alive());
    }

    @Test
    void Fight6() throws HealerBattleException {
        BattleImp.fight(dragon, knight);
        assertTrue(knight.getIs_alive());
    }

    @DisplayName("fight with a wounded hero")
    @Test
    void Fight7() throws HealerBattleException {
        BattleImp.fight(unit_1, unit_2);
        boolean result = BattleImp.fight(unit_2, unit_3);
        assertFalse(result);
    }

    @DisplayName("fight between Defender and Knight")
    @Test
    void Fight8() throws HealerBattleException {
        unit_1 = new Defender();
        boolean result = BattleImp.fight(unit_1, unit_2);
        assertFalse(result);
    }

    @DisplayName("fight between Defender and Warrior")
    @Test
    void Fight9() throws HealerBattleException {
        unit_1 = new Defender();
        boolean result = BattleImp.fight(unit_1, unit_3);
        assertTrue(result);
    }

    @DisplayName("fight between Warrior and Vampire")
    @Test
    void Fight10() throws HealerBattleException {
        boolean result = BattleImp.fight(carl, vampire);
        assertTrue(result);
    }

    @DisplayName("fight between Vampire and Defender")
    @Test
    void Fight11() throws HealerBattleException {
        boolean result = BattleImp.fight(vampire, defender);
        assertFalse(result);
    }

    @Test
    void Fight12() throws HealerBattleException {
        boolean result = BattleImp.fight(vampire, jim);
        assertFalse(result);
    }


    @DisplayName("Army fight between Warrior and 2 Warriors")
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
        assertFalse(result);
    }

    @Test
    void Battle5() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 10);
        secondArmyImpl.addUnits(Warrior.class, 11);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertFalse(result);
    }

    @Test
    void Battle6() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 11);
        secondArmyImpl.addUnits(Warrior.class, 7);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @DisplayName("Army fight with Warriors and Defenders")
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

    @DisplayName("Army fight with Lancer and Defenders")
    @Test
    void Battle11() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 2);
        secondArmyImpl.addUnits(Lancer.class, 1);
        secondArmyImpl.addUnits(Warrior.class, 1);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertFalse(result);
    }

    @Test
    void Battle12() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 30);
        secondArmyImpl.addUnits(Lancer.class, 15);
        secondArmyImpl.addUnits(Warrior.class, 15);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertFalse(result);
    }

    @Test
    void Battle13() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 10);
        firstArmyImpl.addUnits(Warrior.class, 20);
        secondArmyImpl.addUnits(Lancer.class, 15);
        secondArmyImpl.addUnits(Warrior.class, 15);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertFalse(result);
    }

    @Test
    void Battle14() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Warrior.class, 10);
        firstArmyImpl.addUnits(Warrior.class, 20);
        secondArmyImpl.addUnits(Lancer.class, 15);
        secondArmyImpl.addUnits(Warrior.class, 15);
        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertFalse(result);
    }

    @DisplayName("Army fight with Lancers,Defenders,Vampires,Healers")
    @Test
    void Battle15() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Lancer.class, 7);
        firstArmyImpl.addUnits(Vampire.class, 3);
        firstArmyImpl.addUnits(Healer.class, 1);
        firstArmyImpl.addUnits(Warrior.class, 4);
        firstArmyImpl.addUnits(Healer.class, 1);
        firstArmyImpl.addUnits(Defender.class, 2);

        secondArmyImpl.addUnits(Warrior.class, 4);
        secondArmyImpl.addUnits(Defender.class, 4);
        secondArmyImpl.addUnits(Healer.class, 1);
        secondArmyImpl.addUnits(Vampire.class, 6);
        secondArmyImpl.addUnits(Lancer.class, 4);

        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @DisplayName("Straight fight with Warriors and Healers")
    @Test
    void Battle16() throws ReflectiveOperationException, HealerBattleException {
        firstArmyImpl.addUnits(Warrior.class, 5);
        secondArmyImpl.addUnits(Healer.class, 10);

        boolean result = battle.straightFight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @DisplayName("Straight fight with Healer and Healer, first healer should win")
    @Test
    void Battle17() throws ReflectiveOperationException, HealerBattleException {
        firstArmyImpl.addUnits(Healer.class, 1);
        secondArmyImpl.addUnits(Healer.class, 1);

        boolean result = battle.straightFight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @DisplayName("Straight fight with Healers, first pair healers should skip,in the end Healer's pair should win first")
    @Test
    void Battle18() throws ReflectiveOperationException, HealerBattleException {
        firstArmyImpl.addUnits(Healer.class, 2);
        firstArmyImpl.addUnits(Warrior.class,1);
        firstArmyImpl.addUnits(Healer.class,1);
        secondArmyImpl.addUnits(Healer.class, 2);
        secondArmyImpl.addUnits(Warrior.class,1);
        secondArmyImpl.addUnits(Healer.class,1);

        boolean result = battle.straightFight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @DisplayName("Huge straight fight")
    @Test
    void Battle19() throws ReflectiveOperationException, HealerBattleException {
        firstArmyImpl.addUnits(Healer.class, 14);
        firstArmyImpl.addUnits(Warrior.class,20);
        firstArmyImpl.addUnits(Healer.class,13);
        secondArmyImpl.addUnits(Healer.class, 20);
        secondArmyImpl.addUnits(Warrior.class,30);
        secondArmyImpl.addUnits(Healer.class,3);

        boolean result = battle.straightFight(firstArmyImpl, secondArmyImpl);
        assertFalse(result);
    }

    @DisplayName("Behavior healers in army fight")
    @Test
    void Battle20() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Healer.class, 2);
        secondArmyImpl.addUnits(Healer.class, 2);

        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }

    @DisplayName("First healer's pair should been skipped")
    @Test
    void Battle21() throws ReflectiveOperationException {
        firstArmyImpl.addUnits(Healer.class, 1);
        firstArmyImpl.addUnits(Warrior.class,2);
        secondArmyImpl.addUnits(Healer.class, 1);
        secondArmyImpl.addUnits(Warrior.class,2);

        boolean result = battle.fight(firstArmyImpl, secondArmyImpl);
        assertTrue(result);
    }
}