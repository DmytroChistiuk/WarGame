package com.company.gameSoftServe.entity;

import java.lang.reflect.Constructor;
import java.util.ArrayDeque;
import java.util.Deque;

public class Army {
    public Deque<Warrior> warriors = new ArrayDeque<>();

    public void addUnits(Class<? extends Warrior> clazz, int number) throws ReflectiveOperationException {
        Constructor<? extends Warrior> constr = clazz.getConstructor();

        for (int i = 0; i < number; i++) {
            Warrior warrior = constr.newInstance();
            warriors.addLast(warrior);
            }
        }

    }
