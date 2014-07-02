package ru.vlsu.animal.run;

import ru.vlsu.animal.model.*;

import java.util.ArrayList;
import java.util.List;

public class RunClient {
    public static void main(String[] args) {

        Animal herbivores = new Herbivores(10, "Травоядное", true, 80);
        Animal predator = new Predator(11, "Хищник", true, 90);
        Eat grass = new Grass(100);
        herbivores.eat(grass);
        predator.eat(herbivores);
        System.out.println(predator.getM() + " " + herbivores.getM());

    }
}
