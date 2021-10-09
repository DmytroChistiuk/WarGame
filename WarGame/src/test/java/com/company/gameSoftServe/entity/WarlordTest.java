package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.collection.ArmyImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarlordTest {

    @Test
    @DisplayName("Add only 1 warlord to army")
    void Test1() throws ReflectiveOperationException {
        ArmyImpl army = new ArmyImpl();
        army.addUnits(Warlord.class,40);
        assertEquals(1,army.sizeOfArmy());
    }


}