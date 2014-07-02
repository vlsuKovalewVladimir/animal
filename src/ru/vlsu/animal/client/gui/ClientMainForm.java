package ru.vlsu.animal.client.gui;

import ru.vlsu.animal.constants.IClientFormStringConst;
import ru.vlsu.animal.model.Grass;
import ru.vlsu.animal.model.Herbivores;
import ru.vlsu.animal.model.Predator;
import ru.vlsu.animal.storage.AnimalList;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ClientMainForm extends JFrame {

    private JTable tableHerbivores;
    private JTable tablePredator;
    private JTable tableGrass;

    private JTextField textFieldIP;
    private JTextField textFieldPort;

    private JButton btnUpdateData;
    private JButton btnSendData;

    private JButton btnHerbivoresAdd;
    private JButton btnHerbivoresUpdate;
    private JButton btnHerbivoresDelete;

    private JButton btnPredatorAdd;
    private JButton btnPredatorUpdate;
    private JButton btnPredatorDelete;

    private JButton btnGrassAdd;
    private JButton btnGrassUpdate;
    private JButton btnGrassDelete;


    public ClientMainForm() {
        initDesign();
        initAction();
    }

    private void initDesign() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 932, 546);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setTitle(IClientFormStringConst.GUI_TITLE);



        // PANEL

        JPanel panelTop = new JPanel();
        contentPane.add(panelTop, BorderLayout.NORTH);
        panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));

        JPanel panelConnect = new JPanel();
        panelTop.add(panelConnect);
        panelConnect.setLayout(new BoxLayout(panelConnect, BoxLayout.X_AXIS));

        JPanel panelConnect_btn = new JPanel();
        panelTop.add(panelConnect_btn);

        JPanel panel_4 = new JPanel();
        panelConnect.add(panel_4);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

        JPanel panel_6 = new JPanel();
        panelConnect.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));

        JPanel panel_5 = new JPanel();
        panelConnect.add(panel_5);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));

        Component verticalStrut = Box.createVerticalStrut(10);
        panelTop.add(verticalStrut);



        JPanel panelData = new JPanel();
        contentPane.add(panelData, BorderLayout.CENTER);
        panelData.setLayout(new BoxLayout(panelData, BoxLayout.X_AXIS));

        JPanel panelData1 = new JPanel();
        panelData1.setBorder(new LineBorder(Color.GRAY, 1, true));
        panelData.add(panelData1);
        panelData1.setLayout(new BorderLayout(0, 0));

        JPanel panelData_btn1 = new JPanel();
        panelData1.add(panelData_btn1, BorderLayout.NORTH);
        panelData_btn1.setLayout(new BoxLayout(panelData_btn1, BoxLayout.X_AXIS));

        Component horizontalStrut = Box.createHorizontalStrut(10);
        panelData.add(horizontalStrut);

        JPanel panelData2 = new JPanel();
        panelData2.setBorder(new LineBorder(Color.GRAY, 1, true));
        panelData.add(panelData2);
        panelData2.setLayout(new BorderLayout(0, 0));

        JPanel panelData_btn2 = new JPanel();
        panelData2.add(panelData_btn2, BorderLayout.NORTH);
        panelData_btn2.setLayout(new BoxLayout(panelData_btn2, BoxLayout.X_AXIS));

        Component horizontalStrut_1 = Box.createHorizontalStrut(10);
        panelData.add(horizontalStrut_1);

        JPanel panelData3 = new JPanel();
        panelData3.setBorder(new LineBorder(Color.GRAY, 1, true));
        panelData.add(panelData3);
        panelData3.setLayout(new BorderLayout(0, 0));

        JPanel panelData_btn3 = new JPanel();
        panelData3.add(panelData_btn3, BorderLayout.NORTH);
        panelData_btn3.setLayout(new BoxLayout(panelData_btn3, BoxLayout.X_AXIS));

        JScrollPane scrollPane_1 = new JScrollPane();
        panelData2.add(scrollPane_1, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        panelData1.add(scrollPane, BorderLayout.CENTER);

        JScrollPane scrollPane_2 = new JScrollPane();
        panelData3.add(scrollPane_2, BorderLayout.CENTER);



        JLabel lblNewLabel = new JLabel(IClientFormStringConst.GUI_LABEL_IP);
        panel_4.add(lblNewLabel);

        textFieldIP = new JTextField();
        panel_4.add(textFieldIP);
        textFieldIP.setColumns(15);


        JLabel label_1 = new JLabel(" ");
        panel_6.add(label_1);
        JLabel label = new JLabel(" : ");
        panel_6.add(label);


        JLabel lblNewLabel_1 = new JLabel(IClientFormStringConst.GUI_LABEL_PORT);
        panel_5.add(lblNewLabel_1);

        textFieldPort = new JTextField();
        panel_5.add(textFieldPort);
        textFieldPort.setColumns(5);



        btnUpdateData = new JButton(IClientFormStringConst.GUI_BTN_UPDATE_DATA);
        panelConnect_btn.add(btnUpdateData);

        btnSendData = new JButton(IClientFormStringConst.GUI_BTN_SEND_DATA);
        panelConnect_btn.add(btnSendData);



        btnHerbivoresAdd = new JButton(IClientFormStringConst.GUI_BTN_ADD);
        panelData_btn1.add(btnHerbivoresAdd);

        btnHerbivoresUpdate = new JButton(IClientFormStringConst.GUI_BTN_UPDATE);
        panelData_btn1.add(btnHerbivoresUpdate);

        btnHerbivoresDelete = new JButton(IClientFormStringConst.GUI_BTN_DELETE);
        panelData_btn1.add(btnHerbivoresDelete);

        tableHerbivores = new JTable();
        tableHerbivores.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                },
                IClientFormStringConst.GUI_HEADER_TABLE_ANIMAL
        ){
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, Boolean.class, Integer.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        scrollPane.setViewportView(tableHerbivores);



        btnPredatorAdd = new JButton(IClientFormStringConst.GUI_BTN_ADD);
        panelData_btn2.add(btnPredatorAdd);

        btnPredatorUpdate = new JButton(IClientFormStringConst.GUI_BTN_UPDATE);
        panelData_btn2.add(btnPredatorUpdate);

        btnPredatorDelete = new JButton(IClientFormStringConst.GUI_BTN_DELETE);
        panelData_btn2.add(btnPredatorDelete);

        tablePredator = new JTable();
        tablePredator.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                },
                IClientFormStringConst.GUI_HEADER_TABLE_ANIMAL
        ));
        scrollPane_1.setViewportView(tablePredator);



        btnGrassAdd = new JButton(IClientFormStringConst.GUI_BTN_ADD);
        panelData_btn3.add(btnGrassAdd);

        btnGrassUpdate = new JButton(IClientFormStringConst.GUI_BTN_UPDATE);
        panelData_btn3.add(btnGrassUpdate);

        btnGrassDelete = new JButton(IClientFormStringConst.GUI_BTN_DELETE);
        panelData_btn3.add(btnGrassDelete);

        tableGrass = new JTable();
        tableGrass.setModel(new DefaultTableModel(
                new Object[][]{
                        {null},
                        {null},
                        {null},
                        {null},
                },
                IClientFormStringConst.GUI_HEADER_TABLE_GRASS
        ));
        scrollPane_2.setViewportView(tableGrass);
    }

    private void initAction() {
        ClientMainFormServerBtnListener clientMainFormServerBtnListener = new ClientMainFormServerBtnListener(this);

        btnUpdateData.addActionListener(clientMainFormServerBtnListener);
        btnSendData.addActionListener(clientMainFormServerBtnListener);



        ClientMainFormTableBntListener clientMainFormTableBntListener = new ClientMainFormTableBntListener(this);

        btnHerbivoresAdd.addActionListener(clientMainFormTableBntListener);
        btnHerbivoresUpdate.addActionListener(clientMainFormTableBntListener);
        btnHerbivoresDelete.addActionListener(clientMainFormTableBntListener);

        btnPredatorAdd.addActionListener(clientMainFormTableBntListener);
        btnPredatorUpdate.addActionListener(clientMainFormTableBntListener);
        btnPredatorDelete.addActionListener(clientMainFormTableBntListener);

        btnGrassAdd.addActionListener(clientMainFormTableBntListener);
        btnGrassUpdate.addActionListener(clientMainFormTableBntListener);
        btnGrassDelete.addActionListener(clientMainFormTableBntListener);
    }

    public void AnimalListToTables(AnimalList animalList) {
        List<Herbivores> herbivoresList = animalList.getHerbivoresList();
        List<Predator>   predatorList   = animalList.getPredatorList();
        List<Grass>      grassList      = animalList.getGrassList();

        int countHerbivores = herbivoresList.size();
        int countPredator   = predatorList.size();
        int countGrass      = grassList.size();

        tableHerbivores.setModel(new DefaultTableModel(
                new Object[countHerbivores][4],
                IClientFormStringConst.GUI_HEADER_TABLE_ANIMAL
        ){
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, Boolean.class, Integer.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });

        tablePredator.setModel(new DefaultTableModel(
                new Object[countPredator][4],
                IClientFormStringConst.GUI_HEADER_TABLE_ANIMAL
        ) {
            Class[] columnTypes = new Class[]{
                    Integer.class, String.class, Boolean.class, Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });

        tableGrass.setModel(new DefaultTableModel(
                new Object[countGrass][1],
                IClientFormStringConst.GUI_HEADER_TABLE_GRASS
        ){
            Class[] columnTypes = new Class[] {
                    Integer.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });


        TableModel tableHerbivoresModel = tableHerbivores.getModel();
        TableModel tablePredatorModel = tablePredator.getModel();
        TableModel tableGrassModel = tableGrass.getModel();

        for (int i = 0; i < countHerbivores; i++){
            Herbivores herbivores = herbivoresList.get(i);
            tableHerbivoresModel.setValueAt(herbivores.getId(), i, 0);
            tableHerbivoresModel.setValueAt(herbivores.getName(), i, 1);
            tableHerbivoresModel.setValueAt(herbivores.isLive(), i, 2);
            tableHerbivoresModel.setValueAt(herbivores.getM(), i, 3);
        }

        for (int i = 0; i < countPredator; i++){
            Predator predator = predatorList.get(i);
            tablePredatorModel.setValueAt(predator.getId(), i, 0);
            tablePredatorModel.setValueAt(predator.getName(), i, 1);
            tablePredatorModel.setValueAt(predator.isLive(), i, 2);
            tablePredatorModel.setValueAt(predator.getM(), i, 3);
        }

        for (int i = 0; i < countGrass; i++){
            Grass grass = grassList.get(i);
            tableGrassModel.setValueAt(grass.getM(), i, 0);
        }
    }

    public AnimalList TablesToAnimalList() throws IllegalArgumentException, NullPointerException{
        AnimalList animalList = new AnimalList();

        List<Herbivores> herbivoresList = animalList.getHerbivoresList();
        List<Predator>   predatorList   = animalList.getPredatorList();
        List<Grass>      grassList      = animalList.getGrassList();

        int countHerbivores = tableHerbivores.getRowCount();
        int countPredator   = tablePredator.getRowCount();
        int countGrass      = tableGrass.getRowCount();

        TableModel tableHerbivoresModel = tableHerbivores.getModel();
        TableModel tablePredatorModel = tablePredator.getModel();
        TableModel tableGrassModel = tableGrass.getModel();


        for (int i = 0; i < countHerbivores; i++){
            int     id     = Integer.valueOf(tableHerbivoresModel.getValueAt(i, 0).toString());
            String  name   = tableHerbivoresModel.getValueAt(i, 1).toString();
            boolean isLive = Boolean.valueOf(tableHerbivoresModel.getValueAt(i, 2).toString());
            int     m      = Integer.valueOf(tableHerbivoresModel.getValueAt(i, 3).toString());

            herbivoresList.add(new Herbivores(id, name, isLive, m));
        }

        for (int i = 0; i < countPredator; i++){
            int     id     = Integer.valueOf(tablePredatorModel.getValueAt(i, 0).toString());
            String  name   = tablePredatorModel.getValueAt(i, 1).toString();
            boolean isLive = Boolean.valueOf(tablePredatorModel.getValueAt(i, 2).toString());
            int     m      = Integer.valueOf(tablePredatorModel.getValueAt(i, 3).toString());

            predatorList.add(new Predator(id, name, isLive, m));
        }

        for (int i = 0; i < countGrass; i++){
            int m = Integer.valueOf(tableGrassModel.getValueAt(i, 0).toString());

            grassList.add(new Grass(m));
        }

        return animalList;
    }


    public JTable getTableHerbivores() {
        return tableHerbivores;
    }

    public JTable getTablePredator() {
        return tablePredator;
    }

    public JTable getTableGrass() {
        return tableGrass;
    }

    public JTextField getTextFieldIP() {
        return textFieldIP;
    }

    public JTextField getTextFieldPort() {
        return textFieldPort;
    }

    public JButton getBtnUpdateData() {
        return btnUpdateData;
    }

    public JButton getBtnSendData() {
        return btnSendData;
    }

    public JButton getBtnHerbivoresAdd() {
        return btnHerbivoresAdd;
    }

    public JButton getBtnHerbivoresUpdate() {
        return btnHerbivoresUpdate;
    }

    public JButton getBtnHerbivoresDelete() {
        return btnHerbivoresDelete;
    }

    public JButton getBtnPredatorAdd() {
        return btnPredatorAdd;
    }

    public JButton getBtnPredatorUpdate() {
        return btnPredatorUpdate;
    }

    public JButton getBtnPredatorDelete() {
        return btnPredatorDelete;
    }

    public JButton getBtnGrassAdd() {
        return btnGrassAdd;
    }

    public JButton getBtnGrassUpdate() {
        return btnGrassUpdate;
    }

    public JButton getBtnGrassDelete() {
        return btnGrassDelete;
    }
}
