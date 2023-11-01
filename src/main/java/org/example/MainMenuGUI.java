package org.example;

import org.example.controls.*;

import javax.swing.*;
import java.awt.*;

public class MainMenuGUI extends JFrame {
    JLabel tittle;
    JButton ininitQuiz;
    JMenuBar menuBar = new JMenuBar();
    ManagerPluggedComputingInterface manager = new ManagerPluggedComputing();


    public MainMenuGUI() {
        setTitle("Plugged Computing");
        setSize(800, 600);
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.lightGray);


        tittle = new JLabel("Computação Plugada", JLabel.CENTER);
        tittle.setForeground(Color.blue);
        tittle.setFont(new Font("Serif", Font.BOLD, 34));


        setLayout(new GridLayout(3, 1));
        add(tittle);

        // Register
        JMenu menuRegister = new JMenu("Cadastrar");
        JMenuItem menuRegisterQuestion = new JMenuItem(
                "Cadastrar Questão");
        JMenuItem menuRegisterUser = new JMenuItem(
                "Cadastrar Usuário");
        menuRegister.add(menuRegisterQuestion);
        menuRegister.add(menuRegisterUser);
        menuRegisterUser.addActionListener(new addUserController(manager, this));
        menuRegisterQuestion.addActionListener(new addQuestionController(manager, this));

        // Search
        JMenu menuSearch = new JMenu("Pesquisar");
        JMenuItem menuSearchQuestion = new JMenuItem(
                "Pesquisar Questão");
        JMenuItem menuSearchUser = new JMenuItem(
                "Pesquisar Usuário");
        menuSearch.add(menuSearchQuestion);
        menuSearch.add(menuSearchUser);
        menuSearchUser.addActionListener(new searchUserController(manager, this));
        menuSearchQuestion.addActionListener(new searchQuestionController(manager, this));

        // Remove
        JMenu menuRemove = new JMenu("Remover");
        JMenuItem menuRemoveQuestion = new JMenuItem(
                "Remover Questão");
        JMenuItem menuRemoveUser = new JMenuItem(
                "Remover Usuário");
        menuRemove.add(menuRemoveQuestion);
        menuRemove.add(menuRemoveUser);
        menuRemoveUser.addActionListener(new removeUserController(manager, this));
        menuRemoveQuestion.addActionListener(new removeQuestionController(manager, this));


        menuBar.add(menuRegister);
        menuBar.add(menuSearch);
        menuBar.add(menuRemove);
        setJMenuBar(menuBar);

    }
}





