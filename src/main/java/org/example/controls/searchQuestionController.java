package org.example.controls;

import org.example.ManagerPluggedComputingInterface;
import org.example.model.Question;
import org.example.exceptions.QuestionNoExistException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class searchQuestionController implements ActionListener {
    private ManagerPluggedComputingInterface manager;
    private JFrame mainMenu;


    public searchQuestionController(ManagerPluggedComputingInterface manager, JFrame mainMenu) {
        this.manager = manager;
        this.mainMenu = mainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int searchMode = 0;
        while (searchMode < 1 || searchMode > 2){
            searchMode = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"1 - Ver todas as questões\n2 - Pesquisar por ID\n\nComo deseja pesquisar?"));

            if (searchMode == 1){
                HashMap<Integer, Question> allQuestions = manager.getAllQuestions();
                JOptionPane.showMessageDialog(mainMenu,allQuestions.values().toString());
                }
            if (searchMode == 2) {
                int idSearch = Integer.parseInt(JOptionPane.showInputDialog(mainMenu, "Digite o ID desejado\n"));
                try {
                    Question questionSearch = manager.searchQuestion(idSearch);
                    JOptionPane.showMessageDialog(mainMenu,questionSearch.toString());
                } catch (QuestionNoExistException q) {
                    JOptionPane.showMessageDialog(mainMenu, q.getMessage());
                }
            }
        }

    }
}
