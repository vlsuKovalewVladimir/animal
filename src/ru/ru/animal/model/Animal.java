package ru.ru.animal.model;

public abstract class Animal extends Eat {

    protected int id;
    protected String name;
    protected boolean isLive;
    protected float m;

    protected Animal(int id, String name, boolean isLive, float m) {
        this.id = id;
        this.name = name;
        this.isLive = isLive;
        this.m = m;
    }

    protected void die(){
        if (! isLive)
            throw new IllegalStateException();
        isLive = false;
    }

    protected abstract void eat(Eat e);

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

    public float getM() {
        return m;
    }

    public void setM(float m) {
        this.m = m;
    }
}
