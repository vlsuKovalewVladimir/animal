package ru.vlsu.animal.run;

import ru.vlsu.animal.client.gui.ClientMainForm;

import java.awt.EventQueue;

/**
 * Запуск клиента
 */
public class RunClient {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientMainForm frame = new ClientMainForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


