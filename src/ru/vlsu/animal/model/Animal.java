package ru.vlsu.animal.model;

import ru.vlsu.animal.constants.IModelStringConst;

/**
 * Животные
 */
public abstract class Animal extends Eat {

    private int id;
    private String name;
    private boolean isLive;

    protected Animal(int id, String name, boolean isLive, int m) {
        super(m);
        setId(id);
        setName(name);
        setLive(isLive);
    }

    public void die() throws IllegalStateException{
        if (! isLive)
            throw new IllegalStateException(IModelStringConst.MESSAGE_EXCEPTION_DEAD);
        isLive = false;
    }

    public void eat(Eat e) throws IllegalStateException{
        if (! isLive)
            throw new IllegalStateException(IModelStringConst.MESSAGE_EXCEPTION_DEAD);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }
}
