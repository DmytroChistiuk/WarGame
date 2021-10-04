package com.company.gameSoftServe.actions;

import com.company.gameSoftServe.entity.Warrior;

import java.lang.reflect.Constructor;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class ArmyImpl implements Army {
    private Deque<Warrior> warriors = new LinkedList<>();

    public void addUnits(Class<? extends Warrior> clazz, int number) throws ReflectiveOperationException {
        Constructor<? extends Warrior> constr = clazz.getConstructor();

        for (int i = 0; i < number; i++) {
            Warrior warrior = constr.newInstance();
            warriors.addLast(warrior);
        }
    }

    public boolean isEmpty() {
        return warriors.isEmpty();
    }


    public Warrior peekFirst() {
        return warriors.peekFirst();
    }

    public Warrior pollFirst() {
        return warriors.pollFirst();
    }

    public Warrior getByIndex(int index) {
        return ((LinkedList<Warrior>) warriors).get(index);
    }

    private int sizeOfArmy() {
        return warriors.size();
    }

    public Warrior remove(int index) {
        return ((LinkedList<Warrior>) warriors).remove(index);
    }

    public boolean hasSecondFighter() {
       if(sizeOfArmy()>=2){
           return true;
       }
       return false;
    }

    public Iterator<Warrior> iterator(ArmyImpl army){
        Iterator<Warrior> armyIterator1 = warriors.iterator();
        return armyIterator1;
    }
    public boolean hasNext(Iterator<Warrior> armyIterator1){
        return armyIterator1.hasNext();
    }
    public Warrior next(Iterator<Warrior> armyIterator1){
        return armyIterator1.next();
    }
    public void remove(Iterator<Warrior> armyIterator1){
        armyIterator1.remove();
    }

}



