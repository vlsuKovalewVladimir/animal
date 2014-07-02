package ru.vlsu.animal.client.gui;

import ru.vlsu.animal.constants.IClientFormStringConst;
import ru.vlsu.animal.model.Predator;
import ru.vlsu.animal.storage.AnimalList;
import ru.vlsu.animal.storage.ServerStorage;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


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
        ServerStorage serverStorage = new ServerStorage(animalList);
        serverStorage.load();

        form.AnimalListToTables(animalList);
    }

    private void actionBtnSendData(){
        try{
            AnimalList animalList = form.TablesToAnimalList();

            ServerStorage serverStorage = new ServerStorage(animalList);
            serverStorage.save();

        } catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(form,
                    ex.getMessage(),
                    IClientFormStringConst.MESSAGE_DIALOG_TITLE,
                    JOptionPane.WARNING_MESSAGE);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(form,
                    ex.getMessage(),
                    IClientFormStringConst.MESSAGE_DIALOG_TITLE,
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
