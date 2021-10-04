package com.company.gameSoftServe;

import com.company.gameSoftServe.collection.ArmyImpl;
import com.company.gameSoftServe.entity.ability.DoublePunch;
import com.company.gameSoftServe.entity.Healer;
import com.company.gameSoftServe.entity.Warrior;
import com.company.gameSoftServe.exeption.HealerBattleException;

import java.util.Iterator;

public class BattleImp implements Battle {

    public static boolean fight(Warrior warrior1, Warrior warrior2) throws HealerBattleException {
        if (warrior1 instanceof Healer & warrior2 instanceof Healer) {
            throw new HealerBattleException("Failed to create battle between healer and healer");
        }
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
            if (armyImpl1.peekFirst() instanceof Healer & armyImpl2.peekFirst() instanceof Healer) {
                armyImpl2.pollFirst();
                if (armyImpl2.isEmpty()) {
                    break;
                }
                armyImpl1.pollFirst();
                if (armyImpl1.isEmpty()) {
                    break;
                }
            }
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

    @Override
    public boolean straightFight(ArmyImpl armyImpl1, ArmyImpl armyImpl2) throws HealerBattleException {
        Iterator<Warrior> armyIterator1 = armyImpl1.iterator(armyImpl1);
        Iterator<Warrior> armyIterator2 = armyImpl2.iterator(armyImpl2);
        Warrior currentWarrior1 = armyIterator1.next();
        Warrior currentWarrior2 = armyIterator2.next();
        while (true) {
            if (currentWarrior1 instanceof Healer & currentWarrior2 instanceof Healer) {
                if (armyImpl2.hasNext(armyIterator2)) {
                    currentWarrior2 = moveTheIteratorPoint(armyIterator2);
                } else {
                    return true;
                }
                if (armyImpl1.hasNext(armyIterator1)) {
                    currentWarrior1 = moveTheIteratorPoint(armyIterator1);
                } else {
                    return false;
                }
            } else {
                boolean result = fight(currentWarrior1, currentWarrior2);
                if (result) {
                    if (armyImpl2.hasNext(armyIterator2)) {
                        currentWarrior2 = moveTheIteratorPoint(armyIterator2);
                    } else {
                        return true;
                    }
                }
                if (!result) {
                    if (armyImpl1.hasNext(armyIterator1)) {
                        currentWarrior1 = moveTheIteratorPoint(armyIterator1);
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    private Warrior moveTheIteratorPoint(Iterator<Warrior> armyIterator2) {
        Warrior currentWarrior;
        armyIterator2.remove();
        currentWarrior = armyIterator2.next();
        return currentWarrior;
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
