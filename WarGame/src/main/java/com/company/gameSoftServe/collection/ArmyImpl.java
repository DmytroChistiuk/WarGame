package com.company.gameSoftServe.collection;

import com.company.gameSoftServe.entity.Warrior;

import java.lang.reflect.Constructor;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class ArmyImpl implements Army {
    private Deque<Warrior> warriors = new LinkedList<>();

    @Override
    public void addUnits(Class<? extends Warrior> clazz, int number) throws ReflectiveOperationException {
        Constructor<? extends Warrior> constr = clazz.getConstructor();

        for (int i = 0; i < number; i++) {
            Warrior warrior = constr.newInstance();
            warriors.addLast(warrior);
        }
    }

    @Override
    public boolean isEmpty() {
        return warriors.isEmpty();
    }

    @Override
    public Warrior peekFirst() {
        return warriors.peekFirst();
    }

    @Override
    public Warrior pollFirst() {
        return warriors.pollFirst();
    }

    @Override
    public Warrior getByIndex(int index) {
        return ((LinkedList<Warrior>) warriors).get(index);
    }



    private int sizeOfArmy() {
        return warriors.size();
    }

    @Override
    public Warrior remove(int index) {
        return ((LinkedList<Warrior>) warriors).remove(index);
    }

    @Override
    public boolean hasSecondFighter() {
        if (sizeOfArmy() >= 2) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<Warrior> iterator(ArmyImpl army) {
        Iterator<Warrior> armyIterator1 = warriors.iterator();
        return armyIterator1;
    }

    @Override
    public boolean hasNext(Iterator<Warrior> armyIterator1) {
        return armyIterator1.hasNext();
    }

    @Override
    public Warrior next(Iterator<Warrior> armyIterator1) {
        return armyIterator1.next();
    }

    @Override
    public void remove(Iterator<Warrior> armyIterator1) {
        armyIterator1.remove();
    }

}



