package ru.vlsu.animal.storage;

import ru.vlsu.animal.model.Grass;
import ru.vlsu.animal.model.Herbivores;
import ru.vlsu.animal.model.Predator;

import java.util.ArrayList;
import java.util.List;

public class AnimalList {
    private List<Herbivores> herbivoresList;
    private List<Predator>   predatorList;
    private List<Grass>      grassList;

    public AnimalList () {
        herbivoresList = new ArrayList<Herbivores>();
        predatorList   = new ArrayList<Predator>();
        grassList      = new ArrayList<Grass>();
    }

    public List<Herbivores> getHerbivoresList() {
        return herbivoresList;
    }
    public void setHerbivoresList(List<Herbivores> herbivoresList) {
        this.herbivoresList = herbivoresList;
    }


    public List<Predator> getPredatorList() {
        return predatorList;
    }
    public void setPredatorList(List<Predator> predatorList) {
        this.predatorList = predatorList;
    }

    public List<Grass> getGrassList() {
        return grassList;
    }
    public void setGrassList(List<Grass> grassList) {
        this.grassList = grassList;
    }
}
