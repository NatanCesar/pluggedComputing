package org.example.controls;
import org.example.ManagerPluggedComputingInterface;
import org.example.exceptions.QuestionNoExistException;

import org.example.model.Question;
import org.example.model.TypeQuestions;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.List;

public class alterQuestionController implements ActionListener {
    private ManagerPluggedComputingInterface manager;
    private JFrame mainMenu;


    public alterQuestionController(ManagerPluggedComputingInterface manager, JFrame mainMenu) {
        this.manager = manager;
        this.mainMenu = mainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int questionID = Integer.parseInt(JOptionPane.showInputDialog(mainMenu, "Qual o ID da questão que deseja alterar?"));
            Question question = manager.searchQuestion(questionID);
            alterQuestion(question);
        } catch (QuestionNoExistException u) {
            JOptionPane.showMessageDialog(mainMenu, u.getMessage());
        }
    }


    public void alterQuestion (Question question) {
        int optionsAlter = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"1 - Cabeçario\n2 - Alternativas\n3 - Questão correta\n4 - Tipo de questão"+
                "\n\nQual opção você deseja alterar?"));
        switch (optionsAlter) {
            case 1:
                String newHeader = JOptionPane.showInputDialog(mainMenu, "Digite o novo cabeçario: ");
                question.setHeader(newHeader);
                JOptionPane.showMessageDialog(mainMenu, "Alterado com sucesso!");
                break;
            case 2:
                int alternativeIndex = Integer.parseInt(JOptionPane.showInputDialog(mainMenu, question.showQuestion() + "\n\nQual das alternativas você deseja alterar? "));
                int quantityAlternatives = question.getAlternatives().size();
                if (alternativeIndex >= 1 && alternativeIndex <= quantityAlternatives) {
                    String newAlternative = JOptionPane.showInputDialog(mainMenu, "Digite a nova alternativa: ");
                    List<String> allAlternatives = question.getAlternatives();
                    allAlternatives.set(alternativeIndex-1, newAlternative);
                    question.setAlternatives(allAlternatives);
                    JOptionPane.showMessageDialog(mainMenu, "Alterado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(mainMenu, "Alternativa não existe.");
                }
                break;
            case 3:
                int newIndexCorrectAlternative = Integer.parseInt(JOptionPane.showInputDialog(mainMenu, question.showQuestion() + "\n\nDigite o número da nova alternativa certa: "));
                int quantityAlternatives1 = question.getAlternatives().size();
                if (newIndexCorrectAlternative >= 1 && newIndexCorrectAlternative <= quantityAlternatives1) {
                    question.setIndexCorrectQuestion(newIndexCorrectAlternative);
                    JOptionPane.showMessageDialog(mainMenu, "Alterado com sucesso!");
                }
                break;
            case 4:
                int indexTypeQuestion = Integer.parseInt(JOptionPane.showInputDialog(mainMenu, "1 - Verdadeiro ou Falso\n2 - Multipla Escolha\n3 - Aberta" +"\n" +
                        "\nEscolha o novo tipo de questão:"));
                switch (indexTypeQuestion){
                    case 1:
                        question.setTypeQuestion(TypeQuestions.TRUE_FALSE);
                        JOptionPane.showMessageDialog(mainMenu, "Alterado com sucesso!");
                        break;
                    case 2:
                        question.setTypeQuestion(TypeQuestions.MULTIPLE_CHOICE);
                        JOptionPane.showMessageDialog(mainMenu, "Alterado com sucesso!");
                        break;
                    case 3:
                        question.setTypeQuestion(TypeQuestions.DISCURSIVE);
                        JOptionPane.showMessageDialog(mainMenu, "Alterado com sucesso!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(mainMenu,"Opção inválida");
                }

        }

    }
}
