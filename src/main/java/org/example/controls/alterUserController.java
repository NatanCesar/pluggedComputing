package org.example.controls;
import org.example.ManagerPluggedComputingInterface;
import org.example.exceptions.UserNoExistException;
import org.example.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class alterUserController implements ActionListener {
    private ManagerPluggedComputingInterface manager;
    private JFrame mainMenu;


    public alterUserController(ManagerPluggedComputingInterface manager, JFrame mainMenu) {
        this.manager = manager;
        this.mainMenu = mainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int userID = Integer.parseInt(JOptionPane.showInputDialog(mainMenu, "Qual o ID do usuário que deseja alterar?"));
            User user = manager.searchUser(userID);
            alterUser(user);
        } catch (UserNoExistException u) {
            JOptionPane.showMessageDialog(mainMenu, u.getMessage());
        }
    }


    public void alterUser(User user) {
        int optionsAlter = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"1 - Alterar nome\n2 - Alterar idade\n3 - Grau de escolaridade\n4 - Instituição atual\n5 - Email" +
                "\n\nQual opção você deseja alterar?"));
        switch (optionsAlter){
            case 1:
                String newName = JOptionPane.showInputDialog(mainMenu,"Digite o novo nome: ");
                user.setName(newName);
                JOptionPane.showMessageDialog(mainMenu, "Alterado com sucesso!");
                break;
            case 2:
                int newAge= Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"Digite a nova idade: "));
                user.setAge(newAge);
                JOptionPane.showMessageDialog(mainMenu, "Alterado com sucesso!");
                break;
            case 3:
                String newEducationDegree = JOptionPane.showInputDialog(mainMenu, "Digite a nova escolaridade: ");
                user.setEducationDegree(newEducationDegree);
                JOptionPane.showMessageDialog(mainMenu, "Alterado com sucesso!");
                break;
            case 4:
                String newActualInstitution = JOptionPane.showInputDialog(mainMenu,"Digite a nova atual instituição: ");
                user.setActualInstitution(newActualInstitution);
                JOptionPane.showMessageDialog(mainMenu, "Alterado com sucesso!");
                break;
            case 5:
                String newEmail = JOptionPane.showInputDialog(mainMenu,"Digite o novo email: ");
                user.setEmail(newEmail);
                JOptionPane.showMessageDialog(mainMenu, "Alterado com sucesso!");
                break;
            default:
                JOptionPane.showMessageDialog(mainMenu,"Opção inválida");
        }

    }

}