package com.company.gameSoftServe.entity;

import com.company.gameSoftServe.actions.ArmyImpl;

public class BattleImp implements Battle {

    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.getIs_alive() && warrior2.getIs_alive()) {
            warrior1.attack(warrior1, warrior2);
            if (warrior2.getHealth() <= 0) {
                warrior2.setIs_alive(false);
                break;
            }
            warrior2.attack(warrior2, warrior1);
            if (warrior1.getHealth() <= 0) {
                warrior1.setIs_alive(false);
            }
        }
        return warrior1.getIs_alive();
    }

    @Override
    public boolean fight(ArmyImpl armyImpl1, ArmyImpl armyImpl2) {
        while ((!armyImpl1.isEmpty()) && (!armyImpl2.isEmpty())) {
            if (armyImpl1.peekFirst() instanceof DoublePunch) {
                armyImpl1.peekFirst().attack(armyImpl1.peekFirst(), armyImpl2);
            } else {
                armyImpl1.peekFirst().attack(armyImpl1.peekFirst(), armyImpl2.peekFirst());
                if (armyImpl2.peekFirst().getHealth() <= 0) {
                    armyImpl2.pollFirst();
                    if (armyImpl2.isEmpty()) {
                        break;
                    }
                }
            }
            if (armyImpl2.peekFirst() instanceof DoublePunch) {
                armyImpl2.peekFirst().attack(armyImpl2.peekFirst(), armyImpl1);
            } else {
                armyImpl2.peekFirst().attack(armyImpl2.peekFirst(), armyImpl1.peekFirst());
                if (armyImpl1.peekFirst().getHealth() <= 0) {
                    armyImpl1.pollFirst();
                }
            }
        }
            if (armyImpl1.isEmpty()) {
                return false;
            }
            return true;
        }
    }
