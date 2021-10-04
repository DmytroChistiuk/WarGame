package com.company.gameSoftServe;

import com.company.gameSoftServe.actions.ArmyImpl;
import com.company.gameSoftServe.entity.BattleImp;
import com.company.gameSoftServe.entity.Healer;
import com.company.gameSoftServe.exeption.HealerBattleException;

public class main {
    public static void main(String[] args) throws ReflectiveOperationException, HealerBattleException {
        ArmyImpl army1 = new ArmyImpl();
        ArmyImpl army2 = new ArmyImpl();
        army1.addUnits(Healer.class,2);
        army2.addUnits(Healer.class,2);
        BattleImp battleImp = new BattleImp();

        System.out.println(battleImp.straightFight(army1,army2));


    }

}
