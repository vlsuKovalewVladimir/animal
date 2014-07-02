package ru.vlsu.animal.client.gui;

import ru.vlsu.animal.constants.IClientFormStringConst;
import ru.vlsu.animal.model.*;
import ru.vlsu.animal.storage.AnimalList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientMainFormTableBntListener implements ActionListener {

    private ClientMainForm form;

    public ClientMainFormTableBntListener(ClientMainForm form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();


        JTable tableHerbivores = form.getTableHerbivores();
        JTable tablePredator   = form.getTablePredator();
        JTable tableGrass      = form.getTableGrass();

        DefaultTableModel defaultTableModelHerbivores = (DefaultTableModel)tableHerbivores.getModel();
        DefaultTableModel defaultTableModelPredator   = (DefaultTableModel)tablePredator.getModel();
        DefaultTableModel defaultTableModelGrass      = (DefaultTableModel)tableGrass.getModel();


        if (source == form.getBtnHerbivoresAdd()){
            defaultTableModelHerbivores.addRow(new Object[4]);
            return;
        }
        if (source == form.getBtnHerbivoresDelete()){
            int deleteRow = tableHerbivores.getSelectedRow();
            if (deleteRow != -1)
                defaultTableModelHerbivores.removeRow(deleteRow);
            return;
        }
        if (source == form.getBtnHerbivoresEat()){
            int selectedHerbivores = tableHerbivores.getSelectedRow();
            int selectedGrass      = tableGrass.getSelectedRow();

            if (selectedHerbivores == -1 || selectedGrass == -1){
                JOptionPane.showMessageDialog(form,
                        IClientFormStringConst.MESSAGE_DIALOG_EAT_BODY,
                        IClientFormStringConst.MESSAGE_DIALOG_TITLE,
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            AnimalList animalList = form.TablesToAnimalList();
            Herbivores herbivores = animalList.getHerbivoresList().get(selectedHerbivores);
            Grass      grass      = animalList.getGrassList().get(selectedGrass);

            try{
                herbivores.eat(grass);
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(form,
                        ex.getMessage(),
                        IClientFormStringConst.MESSAGE_DIALOG_TITLE,
                        JOptionPane.WARNING_MESSAGE);
            }

            form.AnimalListToTables(animalList);
        }



        if (source == form.getBtnPredatorAdd()){
            defaultTableModelPredator.addRow(new Object[4]);
            return;
        }
        if (source == form.getBtnPredatorDelete()){
            int deleteRow = tablePredator.getSelectedRow();
            if (deleteRow != -1)
                defaultTableModelPredator.removeRow(deleteRow);
            return;
        }
        if (source == form.getBtnPredatorEat()){
            int selectedHerbivores = tableHerbivores.getSelectedRow();
            int selectedPredator   = tablePredator.getSelectedRow();

            if (selectedHerbivores == -1 || selectedPredator == -1){
                JOptionPane.showMessageDialog(form,
                        IClientFormStringConst.MESSAGE_DIALOG_EAT_BODY,
                        IClientFormStringConst.MESSAGE_DIALOG_TITLE,
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            AnimalList animalList = form.TablesToAnimalList();
            Herbivores herbivores = animalList.getHerbivoresList().get(selectedHerbivores);
            Predator   predator   = animalList.getPredatorList().get(selectedPredator);

            try{
                predator.eat(herbivores);
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(form,
                        ex.getMessage(),
                        IClientFormStringConst.MESSAGE_DIALOG_TITLE,
                        JOptionPane.WARNING_MESSAGE);
            }

            form.AnimalListToTables(animalList);
        }



        if (source == form.getBtnGrassAdd()){
            defaultTableModelGrass.addRow(new Object[1]);
            return;
        }
        if (source == form.getBtnGrassDelete()){
            int deleteRow = tableGrass.getSelectedRow();
            if (deleteRow != -1)
                defaultTableModelGrass.removeRow(deleteRow);

        }
    }
}
