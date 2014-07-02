package ru.vlsu.animal.run;

import ru.vlsu.animal.server.gui.ServerMainForm;

import java.awt.EventQueue;

public class RunServer {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ServerMainForm frame = new ServerMainForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
