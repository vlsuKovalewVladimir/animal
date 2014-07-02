package ru.vlsu.animal.storage;

import ru.vlsu.animal.constants.IStorageStringConst;
import ru.vlsu.animal.model.Grass;
import ru.vlsu.animal.model.Herbivores;
import ru.vlsu.animal.model.Predator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;

public class ServerStorage {

    private List<Herbivores> herbivoresList;
    private List<Predator>   predatorList;
    private List<Grass>      grassList;

    public ServerStorage(AnimalList animalList){
        herbivoresList = animalList.getHerbivoresList();
        predatorList   = animalList.getPredatorList();
        grassList      = animalList.getGrassList();
    }


    public void load(){
        String fileNameHerbivores = IStorageStringConst.FILE_NAME_HERBIVORES;
        String fileNamePredator   = IStorageStringConst.FILE_NAME_PREDATOR;
        String fileNameGrass      = IStorageStringConst.FILE_NAME_GRASS;

        try {
            FileInputStream herbivoresFileInputStream = new FileInputStream(fileNameHerbivores);
            FileInputStream predatorFileInputStream   = new FileInputStream(fileNamePredator);
            FileInputStream grassFileInputStream      = new FileInputStream(fileNameGrass);

            ObjectInputStream herbivoresObjectInputStream = new ObjectInputStream(herbivoresFileInputStream);
            ObjectInputStream predatorObjectInputStream   = new ObjectInputStream(predatorFileInputStream);
            ObjectInputStream grassObjectInputStream      = new ObjectInputStream(grassFileInputStream);


            herbivoresList = (List<Herbivores>) herbivoresObjectInputStream.readObject();
            predatorList   = (List<Predator>) predatorObjectInputStream.readObject();
            grassList      = (List<Grass>) grassObjectInputStream.readObject();

        } catch (FileNotFoundException e) {
            defaultLoad();
        } catch (IOException e) {
            defaultLoad();
        }
        catch (ClassNotFoundException e) {
            defaultLoad();
        }
    }

    private void defaultLoad() {
        herbivoresList.add(new Herbivores(1 ,"Травоядное1" ,true ,40));
        herbivoresList.add(new Herbivores(2 ,"Травоядное2" ,true ,60));
        herbivoresList.add(new Herbivores(3 ,"Травоядное3" ,true ,80));
        herbivoresList.add(new Herbivores(4 ,"Травоядное4" ,false,10));
        herbivoresList.add(new Herbivores(5 ,"Травоядное5" ,true ,20));
        herbivoresList.add(new Herbivores(6 ,"Травоядное6" ,true ,80));
        herbivoresList.add(new Herbivores(7 ,"Травоядное7" ,true ,90));
        herbivoresList.add(new Herbivores(8 ,"Травоядное8" ,true ,10));
        herbivoresList.add(new Herbivores(9 ,"Травоядное9" ,false,50));
        herbivoresList.add(new Herbivores(10,"Травоядное10",true ,80));
        herbivoresList.add(new Herbivores(11,"Травоядное11",true ,20));
        herbivoresList.add(new Herbivores(12,"Травоядное12",true ,10));
        herbivoresList.add(new Herbivores(13,"Травоядное13",false,70));
        herbivoresList.add(new Herbivores(14,"Травоядное14",true ,90));
        herbivoresList.add(new Herbivores(15,"Травоядное15",true ,30));

        predatorList.add(new Predator(1 ,"Хищник1" ,true ,90));
        predatorList.add(new Predator(2 ,"Хищник2" ,true ,10));
        predatorList.add(new Predator(3 ,"Хищник3" ,false,90));
        predatorList.add(new Predator(4 ,"Хищник4" ,true ,60));
        predatorList.add(new Predator(5 ,"Хищник5" ,true ,20));
        predatorList.add(new Predator(6 ,"Хищник6" ,true ,10));
        predatorList.add(new Predator(7 ,"Хищник7" ,true ,90));
        predatorList.add(new Predator(8 ,"Хищник8" ,true ,40));
        predatorList.add(new Predator(9 ,"Хищник9" ,true ,70));
        predatorList.add(new Predator(10,"Хищник10",false,70));
        predatorList.add(new Predator(11,"Хищник11",true ,80));
        predatorList.add(new Predator(12,"Хищник12",true ,40));
        predatorList.add(new Predator(13,"Хищник13",true ,10));
        predatorList.add(new Predator(14,"Хищник14",true ,40));
        predatorList.add(new Predator(15,"Хищник15",false,70));

        grassList.add(new Grass(70));
        grassList.add(new Grass(20));
        grassList.add(new Grass(10));
        grassList.add(new Grass(40));
        grassList.add(new Grass(60));
        grassList.add(new Grass(80));
        grassList.add(new Grass(90));
        grassList.add(new Grass(20));
        grassList.add(new Grass(10));
        grassList.add(new Grass(50));
        grassList.add(new Grass(20));
        grassList.add(new Grass(70));
        grassList.add(new Grass(10));
        grassList.add(new Grass(40));
        grassList.add(new Grass(30));
    }


    public void save(){
        String fileNameHerbivores = IStorageStringConst.FILE_NAME_HERBIVORES;
        String fileNamePredator = IStorageStringConst.FILE_NAME_PREDATOR;
        String fileNameGrass = IStorageStringConst.FILE_NAME_GRASS;

        try {
            FileOutputStream herbivoresFileOutputStream = new FileOutputStream(fileNameHerbivores);
            FileOutputStream predatorFileOutputStream   = new FileOutputStream(fileNamePredator);
            FileOutputStream grassFileOutputStream      = new FileOutputStream(fileNameGrass);

            ObjectOutputStream herbivoresObjectOutputStream = new ObjectOutputStream(herbivoresFileOutputStream);
            ObjectOutputStream predatorObjectOutputStream   = new ObjectOutputStream(predatorFileOutputStream);
            ObjectOutputStream grassObjectOutputStream      = new ObjectOutputStream(grassFileOutputStream);

            herbivoresObjectOutputStream.writeObject(herbivoresList);
            herbivoresObjectOutputStream.flush();
            herbivoresObjectOutputStream.close();
            herbivoresFileOutputStream.close();

            predatorObjectOutputStream.writeObject(predatorList);
            predatorObjectOutputStream.flush();
            predatorObjectOutputStream.close();
            predatorFileOutputStream.close();

            grassObjectOutputStream.writeObject(grassList);
            grassObjectOutputStream.flush();
            grassObjectOutputStream.close();
            herbivoresFileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
