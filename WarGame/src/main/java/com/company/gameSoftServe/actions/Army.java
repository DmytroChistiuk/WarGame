package com.company.gameSoftServe.actions;

import com.company.gameSoftServe.entity.Warrior;

public interface Army {
    public void addUnits(Class<? extends Warrior> clazz, int number) throws ReflectiveOperationException;

    boolean isEmpty();

    Warrior peekFirst();

    Warrior pollFirst();
}
