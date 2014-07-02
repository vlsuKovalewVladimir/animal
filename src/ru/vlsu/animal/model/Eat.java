package ru.vlsu.animal.model;

import ru.vlsu.animal.constants.IModelStringConst;

import java.io.Serializable;

/**
 * Еда
 */
public abstract class Eat implements Serializable {

    private int m;

    protected Eat(int m){
        setM(m);
    }

    public int getM() {
        return m;
    }

    public void setM(int m) throws IllegalArgumentException{
        if (m < 0 || m > 100)
            throw new IllegalArgumentException(IModelStringConst.MESSAGE_EXCEPTION_SET_M);
        this.m = m;
    }

    @Override
    public String toString() {
        return "m = " + m;
    }
}
