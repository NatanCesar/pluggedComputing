package org.example.controls;

import org.example.ManagerPluggedComputing;
import org.example.ManagerPluggedComputingInterface;
import org.example.exceptions.QuestionNoExistException;
import org.example.model.Question;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removeQuestionController implements ActionListener {
    private ManagerPluggedComputingInterface manager;
    private JFrame mainMenu;


    public removeQuestionController(ManagerPluggedComputingInterface manager, JFrame mainMenu) {
        this.manager = manager;
        this.mainMenu = mainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int questionID = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"Digite o ID da questão que deseja apagar"));
            Question question = manager.searchQuestion(questionID);
            String answearDelete = JOptionPane.showInputDialog(mainMenu, question + "\n\nDigite SIM caso queira apagar esssa questão.");
            if (answearDelete.toLowerCase().equals("sim")){
                manager.removeQuestion(questionID);
                JOptionPane.showMessageDialog(mainMenu,"QUESTÃO APAGADA COM SUCESSO.");
            }
        } catch (QuestionNoExistException q){
            JOptionPane.showMessageDialog(mainMenu,q.getMessage());
        }
    }
}
