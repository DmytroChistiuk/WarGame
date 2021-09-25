package com.company.gameSoftServe.actions;

import com.company.gameSoftServe.entity.Army;
import com.company.gameSoftServe.entity.Warrior;

public class BattleImp implements Battle {

    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.getIs_alive() && warrior2.getIs_alive()) {
            warrior1.getDamage(warrior1, warrior2);
            if (warrior2.getHealth() <= 0) {
                warrior2.setIs_alive(false);
                break;
            }
            warrior2.getDamage(warrior2, warrior1);
            if (warrior1.getHealth() <= 0) {
                warrior1.setIs_alive(false);
            }
        }
        return warrior1.getIs_alive();
    }

    @Override
    public boolean fight(Army army1, Army army2) {
        while ((!army1.warriors.isEmpty())&&(!army2.warriors.isEmpty())){
            boolean result = fight(army1.warriors.peekFirst(),army2.warriors.peekFirst());
            if (result){
                army2.warriors.pollFirst();
            }
            if(!result){
                army1.warriors.pollFirst();
            }
        }
        if (army1.warriors.isEmpty()){
            return false;
        }
        return true;
    }
}
