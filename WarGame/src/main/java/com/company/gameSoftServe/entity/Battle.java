package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.actions.ArmyImpl;
import com.company.gameSoftServe.exeption.HealerBattleException;

public interface Battle {
      boolean fight(ArmyImpl armyImpl1, ArmyImpl armyImpl2);
      boolean straightFight(ArmyImpl armyImpl1, ArmyImpl armyImpl2) throws HealerBattleException;
}
