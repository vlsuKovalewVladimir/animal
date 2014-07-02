package ru.vlsu.animal.client.gui;

import ru.vlsu.animal.constants.IClientFormStringConst;
import ru.vlsu.animal.constants.IServerFormStringConst;
import ru.vlsu.animal.model.Animal;
import ru.vlsu.animal.storage.AnimalList;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientMainFormServerBtnListener implements ActionListener {

    private ClientMainForm form;

    public ClientMainFormServerBtnListener(ClientMainForm form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == form.getBtnUpdateData()) {
            actionBtnUpdateData();
            return;
        }

        if (source == form.getBtnSendData()){
            actionBtnSendData();
        }
    }

    private  void actionBtnUpdateData(){

        AnimalList animalList = new AnimalList();
        try {

            int port = form.getPort();
            String host = form.getHost();

            if (port < 1 || port > 65535)
                throw new NumberFormatException();

            Socket socket = new Socket(host, port);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream  inputStream  = new ObjectInputStream(socket.getInputStream());

            outputStream.writeObject(new String("*"));

            Object inputObject = inputStream.readObject();
            if (inputObject instanceof AnimalList)
                animalList = (AnimalList) inputObject;

            outputStream.close();
            inputStream.close();
            socket.close();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(form,
                    IServerFormStringConst.MESSAGE_DIALOG_BODY,
                    IServerFormStringConst.MESSAGE_DIALOG_TITLE,
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(form,
                    ex.getMessage(),
                    IServerFormStringConst.MESSAGE_DIALOG_TITLE,
                    JOptionPane.WARNING_MESSAGE);
        }

        form.AnimalListToTables(animalList);
    }

    private void actionBtnSendData(){
        try{
            AnimalList animalList = form.TablesToAnimalList();

            int port = form.getPort();
            String host = form.getHost();

            if (port < 1 || port > 65535)
                throw new NumberFormatException();

            Socket socket = new Socket(host, port);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            outputStream.writeObject(animalList);

            /*outputStream.close();
            socket.close();*/

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(form,
                    IServerFormStringConst.MESSAGE_DIALOG_BODY,
                    IServerFormStringConst.MESSAGE_DIALOG_TITLE,
                    JOptionPane.WARNING_MESSAGE);

        } catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(form,
                    ex.getMessage(),
                    IClientFormStringConst.MESSAGE_DIALOG_TITLE,
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form,
                    ex.getMessage(),
                    IClientFormStringConst.MESSAGE_DIALOG_TITLE,
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
