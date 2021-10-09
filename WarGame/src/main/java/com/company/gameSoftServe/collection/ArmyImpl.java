package com.company.gameSoftServe.collection;

import com.company.gameSoftServe.entity.Hero;
import com.company.gameSoftServe.entity.Warlord;
import com.company.gameSoftServe.entity.Warrior;

import java.lang.reflect.Constructor;
import java.util.Comparator;
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
            if (warrior instanceof Warlord) {
                break;
            }
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
        if (warriors.peekLast() instanceof Warlord) {
            moveUnits();
        }
        return warriors.pollFirst();
    }

    @Override
    public Warrior getByIndex(int index) {
        return ((LinkedList<Warrior>) warriors).get(index);
    }

    public int sizeOfArmy() {
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

    private void moveUnits() {
        ((LinkedList<Warrior>) warriors).sort(new WarriorComparator());
        int swapIndex = getIndexToSwap();
        swapUnits(swapIndex);
    }


    private int getIndexToSwap() {
        int index;
        for (Warrior warrior : warriors) {
            if (warrior.getPriority() == 3) {
                index = ((LinkedList<Warrior>) warriors).indexOf(warrior);
                return index;
            }
        }
        for (Warrior warrior : warriors) {
            if (warrior.getPriority() == 2) {
                index = ((LinkedList<Warrior>) warriors).indexOf(warrior);
                return index;
            }
        }
        return 0;
    }

    private void swapUnits(int index) {
        Warrior warriorToSwap;
        warriorToSwap = ((LinkedList<Warrior>) warriors).get(index);
        ((LinkedList<Warrior>) warriors).remove(index);
        warriors.addFirst(warriorToSwap);
    }

    private class WarriorComparator<W extends Hero> implements Comparator<Warrior> {
        @Override
        public int compare(Warrior o1, Warrior o2) {
            if (o1.getPriority() < o2.getPriority())
                return 1;
            if (o1.getPriority() > o2.getPriority())
                return -1;
            if (o1.getPriority() == o2.getPriority()) {
                return 0;
            }
            throw new ClassCastException("Failed to compare 2 warrior");
        }
    }

}




