package ru.vlsu.animal.server;

import ru.vlsu.animal.storage.AnimalList;
import ru.vlsu.animal.storage.ServerStorage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadServer extends Thread{

    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream  inputStream;

    public ThreadServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try{
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream  = new ObjectInputStream(socket.getInputStream());

            Object input = inputStream.readObject();

            if (input instanceof AnimalList){
                AnimalList animalList = (AnimalList) input;
                ServerStorage serverStorage = new ServerStorage(animalList);
                serverStorage.save();
            }

            if (input instanceof String && ((String)input).equals("*")){
                AnimalList animalList = new AnimalList();
                ServerStorage serverStorage = new ServerStorage(animalList);
                serverStorage.load();
                outputStream.writeObject(animalList);
            }

            interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void interrupt() {
        super.interrupt();
        try {
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
