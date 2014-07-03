package ru.vlsu.animal.server.gui;

import ru.vlsu.animal.constants.IServerFormStringConst;
import ru.vlsu.animal.server.Server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс реализующий обработчики событий кнопок
 */
public class ServerFormListener implements ActionListener {

    private ServerMainForm form;
    private Server server;

    public ServerFormListener(ServerMainForm form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == form.getBtnStart()){
            try {
                int port = form.getPort();
                if (port < 1 || port > 65535)
                    throw new NumberFormatException();

                server = new Server(port);
                server.start();
                form.start();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(form,
                        IServerFormStringConst.MESSAGE_DIALOG_BODY,
                        IServerFormStringConst.MESSAGE_DIALOG_TITLE,
                        JOptionPane.WARNING_MESSAGE);
            }
            return;
        }

        if (source == form.getBtnStop()){
            server.interrupt();
            form.stop();
        }

    }

}
