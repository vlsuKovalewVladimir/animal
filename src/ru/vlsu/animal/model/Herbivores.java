package ru.vlsu.animal.model;

import ru.vlsu.animal.constants.IModelStringConst;

/**
 * Травоядные
 */
public class Herbivores extends Animal {

    public Herbivores(int id, String name, boolean isLive, int m) {
        super(id, name, isLive, m);
    }

    @Override
    public void eat(Eat e) throws IllegalStateException, IllegalArgumentException {
        super.eat(e);

        if (e instanceof Grass){
            try{
                int newM = getM() + e.getM();
                this.setM(newM);
            } catch (IllegalArgumentException ex){
                int newM = e.getM() - (100 - this.getM());
                e.setM(newM);
                this.setM(100);
            }
            return;
        }

        throw new IllegalArgumentException(IModelStringConst.MESSAGE_EXCEPTION_NOT_EAT);
    }
}
