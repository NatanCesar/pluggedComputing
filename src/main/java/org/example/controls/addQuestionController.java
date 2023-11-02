package org.example.controls;

import org.example.ManagerPluggedComputing;
import org.example.ManagerPluggedComputingInterface;
import org.example.model.Question;
import org.example.model.TypeQuestions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class addQuestionController implements ActionListener {
    private ManagerPluggedComputingInterface manager;
    private JFrame mainMenu;



    public addQuestionController(ManagerPluggedComputingInterface manager, JFrame mainMenu) {
        this.manager = (ManagerPluggedComputing) manager;
        this.mainMenu = mainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String header = JOptionPane.showInputDialog(mainMenu,"Qual o cabeçario/pergunta da questão?");

        TypeQuestions typeOfQuestion = null;
        boolean condition = true;
        while (condition){
            int indexTypeQuestion = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"1 - Verdadeiro ou Falso\n2 - Multipla Escolha\n3 - Aberta" +
                    "\n\n Qual tipo de questão você vai cadastrar? \n"));
            switch (indexTypeQuestion) {
                case 1:
                    typeOfQuestion = TypeQuestions.TRUE_FALSE;
                    condition = false;
                    break;
                case 2:
                    typeOfQuestion = TypeQuestions.MULTIPLE_CHOICE;
                    condition = false;
                    break;
                case 3:
                    typeOfQuestion = TypeQuestions.DISCURSIVE;
                    condition = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(mainMenu, "Opção inválida, escolha novamente.");

            }
        }

        int quantityAlternatives = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"Quantas alternativas tem sua questão?"));
        List<String> alternatives = new ArrayList<>();
        for (int i = 1; i <= quantityAlternatives; i++){
            alternatives.add(JOptionPane.showInputDialog(mainMenu,"Alternativa " +i+": "));
        }

        condition = true;
        int indexCorrectQuestion = 0;
        while (condition) {
            indexCorrectQuestion = Integer.parseInt(JOptionPane.showInputDialog(mainMenu, "Qual das alternativas é a correta? " + "\nOpções: " + "1-" + quantityAlternatives));
            if (indexCorrectQuestion >= 1 && indexCorrectQuestion <= quantityAlternatives){
                condition = false;
            } else {
                JOptionPane.showMessageDialog(mainMenu,"Opção inválida, escolha novamente.");
            }
        }
        Question q = new Question(header,alternatives,indexCorrectQuestion,typeOfQuestion,manager.getCounterIdQuestions());
        manager.addQuestion(q);
        JOptionPane.showMessageDialog(mainMenu,"Questão cadastrada com sucesso!\nID: " + q.getId());
    }
}
