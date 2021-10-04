package com.company.gameSoftServe;

import com.company.gameSoftServe.collection.ArmyImpl;
import com.company.gameSoftServe.exeption.HealerBattleException;

public interface Battle {
      boolean fight(ArmyImpl armyImpl1, ArmyImpl armyImpl2);
      boolean straightFight(ArmyImpl armyImpl1, ArmyImpl armyImpl2) throws HealerBattleException;
}
