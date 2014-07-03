package ru.vlsu.animal.server.gui;

import ru.vlsu.animal.constants.IServerFormStringConst;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Главное окно серверной части
 */
public class ServerMainForm extends JFrame{

    private JButton    btnStart;
    private JButton    btnStop;
    private JTextArea  textAreaConsole;
    private JTextField textFieldPort;

    public ServerMainForm() {
        initDesign();
        initAction();
    }

    private void initDesign(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setTitle(IServerFormStringConst.GUI_TITLE_FORM);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

        JPanel panel_3 = new JPanel();
        panel.add(panel_3);

        /*JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));*/

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);


        JLabel lblNewLabel = new JLabel(IServerFormStringConst.GUI_LABEL_PORT);
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel_2.add(lblNewLabel);

        textFieldPort = new JTextField();
        panel_2.add(textFieldPort);
        textFieldPort.setText(IServerFormStringConst.GUI_TEXT_FIELD_PORT);
        textFieldPort.setColumns(5);

        btnStart = new JButton(IServerFormStringConst.GUI_BTN_START);
        panel_3.add(btnStart);

        btnStop = new JButton(IServerFormStringConst.GUI_BTN_STOP);
        btnStop.setEnabled(false);
        panel_3.add(btnStop);

        textAreaConsole = new JTextArea();
        textAreaConsole.setText(IServerFormStringConst.GUI_TEXT_AREA);
        textAreaConsole.setEnabled(false);
        scrollPane.setViewportView(textAreaConsole);
    }

    private void initAction(){
        ServerFormListener serverFormListener = new ServerFormListener(this);
        btnStart.addActionListener(serverFormListener);
        btnStop.addActionListener(serverFormListener);
    }

    public void start(){
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        textFieldPort.setEnabled(false);

        addConsole(IServerFormStringConst.CONSOLE_START);
    }

    public void stop(){
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        textFieldPort.setEnabled(true);

        addConsole(IServerFormStringConst.CONSOLE_STOP);
    }

    public void addConsole(String str){
        textAreaConsole.setText(textAreaConsole.getText() + "\n" + str);
    }

    public int getPort() throws NumberFormatException {
        return Integer.valueOf(textFieldPort.getText());
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public JButton getBtnStop() {
        return btnStop;
    }

}