package ru.vlsu.animal.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{

    private int port;
    private ServerSocket serverSocket;
    private List<ThreadServer> threadServerList;

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run(){
        threadServerList = new ArrayList<ThreadServer>();

        try{
            serverSocket = new ServerSocket(port);

            while (true){
                ThreadServer threadServer = new ThreadServer(serverSocket.accept());
                threadServer.start();
                threadServerList.add(threadServer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void interrupt() {
        super.interrupt();
        for (ThreadServer threadServer : threadServerList)
            threadServer.interrupt();
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
