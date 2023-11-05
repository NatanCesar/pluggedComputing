package org.example.controls;

import org.example.ManagerPluggedComputingInterface;
import org.example.exceptions.UserNoExistException;
import org.example.model.Question;
import org.example.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class quizController implements ActionListener {

    private ManagerPluggedComputingInterface manager;
    private JFrame mainMenu;

    public quizController (ManagerPluggedComputingInterface manager, JFrame mainMenu) {
        this.manager = manager;
        this.mainMenu = mainMenu;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (manager.getAllQuestions().isEmpty()){
            JOptionPane.showMessageDialog(mainMenu,"Nenhuma questão cadastrada!");
        }
        else {
            int answerRegistered = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"1 - SIM\n2 - NÃO\n\nJá possui conta de usuário?"));
            if (answerRegistered == 1){
                int id = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"Qual o id cadastrado? "));
                try {
                    quizManager(manager.searchUser(id));
                } catch (UserNoExistException u){
                    JOptionPane.showMessageDialog(mainMenu,u.getMessage());
                }
            } else if (answerRegistered == 2){
                quizManager(addUser());
            } else {
                JOptionPane.showMessageDialog(mainMenu,"Opção inválida!");

            }

        }

    }

    public void quizManager(User user){
        HashMap<Integer, Question> allQuestions = manager.getAllQuestions();
        for (Question q: allQuestions.values()){
            int answer= Integer.parseInt(JOptionPane.showInputDialog(mainMenu, q.showQuestion() + "\nDigite o número da alternativa correta."));

            if (answer == q.getIndexCorrectQuestion()){
                JOptionPane.showMessageDialog(mainMenu,"Parabéns, você acertou!");
                q.addCorrectAnsewrs();
                user.addCorrectAnsewrs();
            } else{
                JOptionPane.showMessageDialog(mainMenu,"Você errou!");
                q.addWrongAnswers();
                user.addWrongAnsewrs();
            }
    }
        JOptionPane.showMessageDialog(mainMenu,"Parabéns, você respondeu todo o quiz!");
    }

    public User addUser() {

        String nome = JOptionPane.showInputDialog(mainMenu,"Qual o nome de usuário?");
        int idade = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"Qual a idade? "));
        String grauEscolaridade = JOptionPane.showInputDialog(mainMenu,"Qual o grau de escolaridade atual?");
        String insituicaoAtual = JOptionPane.showInputDialog(mainMenu,"Se está estudando em alguma instituição no momento informe qual: \n(se nenhuma, so aperte OK)");
        int perguntaEmail = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"1 - SIM\n(se não, so aperte OK)\nDeseja cadastrar seu email? "));
        String email = "";
        if (perguntaEmail == 1) {
            email = JOptionPane.showInputDialog(mainMenu, "Digite seu email:");
        }
        User user = new User(nome,idade,grauEscolaridade,insituicaoAtual,email,manager.getCounterIdUsers());
        manager.addUser(user);
        JOptionPane.showMessageDialog(mainMenu,"Usuário cadastrado com sucesso com o ID: " + user.getId());
        return user;
    }
}
