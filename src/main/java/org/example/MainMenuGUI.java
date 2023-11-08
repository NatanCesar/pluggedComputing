package org.example;

import org.example.controls.*;
import org.example.gravadorDeDados.gravadorDeDados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class MainMenuGUI extends JFrame {
    JLabel tittle;
    JButton startQuiz;
    JMenuBar menuBar = new JMenuBar();
    ManagerPluggedComputingInterface manager = new ManagerPluggedComputing();
    gravadorDeDados gravador = new gravadorDeDados();


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


        // Button
        JPanel panel = new JPanel();
        startQuiz = new JButton("INICIAR");
        panel.add(startQuiz);
        startQuiz.setPreferredSize(new Dimension(200,100));
        startQuiz.addActionListener(new quizController(manager,this));
        add(panel);

        // Register
        JMenu menuRegister = new JMenu("Cadastrar");
        JMenuItem menuRegisterQuestion = new JMenuItem(
                "Cadastrar Questão");
        menuRegister.add(menuRegisterQuestion);
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

        // Alter
        JMenu menuAlter = new JMenu("Alterar");
        JMenuItem menuAlterQuestion = new JMenuItem(
                "Alterar Questão");
        JMenuItem menuAlterUser = new JMenuItem(
                "Alterar Usuário");
        menuAlter.add(menuAlterQuestion);
        menuAlter.add(menuAlterUser);
        menuAlterQuestion.addActionListener(new alterQuestionController(manager, this));
        menuAlterUser.addActionListener(new alterUserController(manager, this));


        menuBar.add(menuRegister);
        menuBar.add(menuSearch);
        menuBar.add(menuRemove);
        menuBar.add(menuAlter);
        setJMenuBar(menuBar);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                int resp = JOptionPane.showConfirmDialog(null,
                        "Tem certeza de que quer sair e salvar?");
                if (resp == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null,"Salvo.");
                    try {
                        gravador.saveQuestions(manager.getAllQuestions());
                        gravador.saveUsers(manager.getAllUsers());
                    } catch (IOException ex) {
                        ex.fillInStackTrace();
                    }
                    System.exit(0);
                }
            }
        });

    }
}





