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
                healMethod(armyImpl1);
                if (removeDeadHero(armyImpl2)) break;
            } else {
                armyImpl1.peekFirst().attack(armyImpl1.peekFirst(), armyImpl2.peekFirst());
                healMethod(armyImpl1);
                if (removeDeadHero(armyImpl2)) break;
            }
            if (armyImpl2.peekFirst() instanceof DoublePunch) {
                armyImpl2.peekFirst().attack(armyImpl2.peekFirst(), armyImpl1);
                healMethod(armyImpl2);
                removeDeadHero(armyImpl1);
            } else {
                armyImpl2.peekFirst().attack(armyImpl2.peekFirst(), armyImpl1.peekFirst());
                healMethod(armyImpl2);
                removeDeadHero(armyImpl1);
            }
        }
        return !armyImpl1.isEmpty();
    }

    private void healMethod(ArmyImpl armyImpl1) {
        if (isNextHealer(armyImpl1)) {
            Healer healer = (Healer) armyImpl1.getByIndex(1);
            healer.heal(healer, armyImpl1.peekFirst());
        }
    }

    private boolean removeDeadHero(ArmyImpl armyImpl2) {
        if (armyImpl2.peekFirst().getHealth() <= 0) {
            armyImpl2.pollFirst();
            return armyImpl2.isEmpty();
        }
        return false;
    }

    private boolean isNextHealer(ArmyImpl army) {
        if (army.hasSecondFighter()) {
            return army.getByIndex(1) instanceof Healer;
        }
        return false;
    }
}
