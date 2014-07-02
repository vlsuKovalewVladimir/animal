package ru.vlsu.animal.model;

import ru.vlsu.animal.constants.IModelStringConst;

import java.io.Serializable;

/**
 * Хищники
 */
public class Predator extends Animal implements Serializable {

    public Predator(int id, String name, boolean isLive, int m) {
        super(id, name, isLive, m);
    }

    @Override
    public void eat(Eat e) throws IllegalStateException, IllegalArgumentException {
        super.eat(e);

        if (e instanceof Herbivores){
            try{
                int newM = getM() + e.getM();
                this.setM(newM);
                e.setM(0);
            } catch (IllegalArgumentException ex){
                int newM = e.getM() - (100 - this.getM());
                e.setM(newM);
                this.setM(100);
            }
            if (((Herbivores) e).isLive())
                ((Herbivores) e).die();
            return;
        }

        throw new IllegalArgumentException(IModelStringConst.MESSAGE_EXCEPTION_NOT_EAT);
    }
}
