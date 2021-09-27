package com.company.gameSoftServe.entity;

public class Vampire extends Warrior {

    public Vampire() {
        setHealth(40);
        setAttack(4);
        setVampirism(50);
        setIs_alive(true);
    }

    @Override
    void getDamage(Warrior attacker, Warrior vampire) {
        vampire.setHealth(vampire.getHealth() - attacker.getAttack());
    }
    @Override
    public void attack(Warrior vampire, Warrior takingDamage) {
        int startHealth = takingDamage.getHealth();
        takingDamage.getDamage(vampire, takingDamage);
        int healthDifference =startHealth-takingDamage.getHealth();
        vampire.setHealth(vampire.getHealth()+(healthDifference*50)/100);
        if(vampire.getHealth()>40){
            vampire.setHealth(40);
        }
    }

}
