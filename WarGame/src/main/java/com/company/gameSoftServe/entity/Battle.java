package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.actions.ArmyImpl;

public interface Battle {
      boolean fight(ArmyImpl armyImpl1, ArmyImpl armyImpl2);
}
