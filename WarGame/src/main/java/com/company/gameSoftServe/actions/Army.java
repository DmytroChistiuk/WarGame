package com.company.gameSoftServe.actions;

import com.company.gameSoftServe.entity.Warrior;

import java.lang.reflect.Constructor;
import java.util.ArrayDeque;
import java.util.Deque;

public class Army {
    private Deque<Warrior> warriors = new ArrayDeque<>();

    public void addUnits(Class<? extends Warrior> clazz, int number) throws ReflectiveOperationException {
        Constructor<? extends Warrior> constr = clazz.getConstructor();

        for (int i = 0; i < number; i++) {
            Warrior warrior = constr.newInstance();
            warriors.addLast(warrior);
        }
    }

    boolean isEmpty() {
        return warriors.isEmpty();
    }

    Warrior peekFirst() {
        return warriors.peekFirst();
    }
    Warrior pollFirst() {
        return warriors.pollFirst();
    }




}
