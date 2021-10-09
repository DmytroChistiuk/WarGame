package com.company.gameSoftServe.weapon;

import com.company.gameSoftServe.collection.ArmyImpl;
import com.company.gameSoftServe.entity.Healer;
import com.company.gameSoftServe.entity.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    @Test
    @DisplayName("the characteristics of the warrior must be increased by the characteristics of the weapon")
    void testWeapon1() {
        Warrior warrior = new Warrior();
        int firstHealth = warrior.getHealth();
        Sword sword = new Sword();
        warrior.equipWeapon(sword);
        assertEquals(firstHealth + sword.getHEALTH_EFFECT(), warrior.getHealth());
    }

    @Test
    @DisplayName("the characteristics of the warrior must be increased by the characteristics of the 2 weapons")
    void testWeapon2() {
        Warrior warrior = new Warrior();
        int firstHealth = warrior.getHealth();
        Sword sword = new Sword();
        warrior.equipWeapon(sword).equipWeapon(sword);
        assertEquals(firstHealth + sword.getHEALTH_EFFECT() + sword.getHEALTH_EFFECT(), warrior.getHealth());
    }

    @DisplayName("Healer shouldn't attack warrior")
    @Test
    void testWeapon3() {
        Healer healer = new Healer();
        Warrior warrior = new Warrior();
        Weapon weapon = new Weapon(20, 20, 0, 20, -20);
        healer.equipWeapon(weapon);
        healer.heal(healer, warrior);
        healer.attack(healer, warrior);
        assertEquals(warrior.getDefaultHealth(), warrior.getHealth());
    }

    @DisplayName("a soldier in the army according to the index take weapon")
    @Test
    void testWeapon4() throws ReflectiveOperationException {
        Warrior warrior = new Warrior();
        Healer healer = new Healer();
        Sword sword = new Sword();
        int warriorHealthWithoutWeapon = warrior.getDefaultHealth();
        int healerHealthWithoutWeapon = healer.getDefaultHealth();
        ArmyImpl army = new ArmyImpl();
        army.addUnits(Warrior.class, 1);
        army.addUnits(Healer.class, 1);
        army.getByIndex(0).equipWeapon(sword);
        army.getByIndex(1).equipWeapon(sword);
        assertEquals(warriorHealthWithoutWeapon+sword.getHEALTH_EFFECT(), army.getByIndex(0).getHealth());
        assertEquals(healerHealthWithoutWeapon+sword.getHEALTH_EFFECT(), army.getByIndex(0).getHealth());
    }


}