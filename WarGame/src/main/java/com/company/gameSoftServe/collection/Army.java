package com.company.gameSoftServe.collection;

import com.company.gameSoftServe.entity.Warrior;

import java.util.Iterator;

public interface Army {
    public void addUnits(Class<? extends Warrior> clazz, int number) throws ReflectiveOperationException;

    boolean isEmpty();

    Warrior peekFirst();

    Warrior pollFirst();

    Warrior getByIndex(int index);

    Warrior remove(int index);

    boolean hasSecondFighter();

    Iterator<Warrior> iterator(ArmyImpl army);

    boolean hasNext(Iterator<Warrior> armyIterator1);

    Warrior next(Iterator<Warrior> armyIterator1);

    void remove(Iterator<Warrior> armyIterator1);

}
