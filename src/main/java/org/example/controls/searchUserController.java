package org.example.controls;

import org.example.ManagerPluggedComputingInterface;
import org.example.exceptions.QuestionNoExistException;
import org.example.exceptions.UserNoExistException;
import org.example.model.Question;
import org.example.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class searchUserController implements ActionListener {
    private ManagerPluggedComputingInterface manager;
    private JFrame mainMenu;


    public searchUserController(ManagerPluggedComputingInterface manager, JFrame mainMenu) {
        this.manager = manager;
        this.mainMenu = mainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int searchMode = 0;
        while (searchMode < 1 || searchMode > 4){
            searchMode = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"\n1 - Ver todos os usuários\n2 - Pesquisar por ID\n3 - Pesquisar por nome\n4 - Pesquisar por idade\n\nComo deseja pesquisar?"));

            if (searchMode == 1){
                HashMap<Integer, User> allUsers = manager.getAllUsers();
                JOptionPane.showMessageDialog(mainMenu,allUsers.values().toString());
            }
            else if (searchMode == 2) {
                int idSearch = Integer.parseInt(JOptionPane.showInputDialog(mainMenu, "Digite o ID desejado\n"));
                try {
                    User userSearch = manager.searchUser(idSearch);
                    JOptionPane.showMessageDialog(mainMenu,userSearch.toString());
                } catch (UserNoExistException u) {
                    JOptionPane.showMessageDialog(mainMenu, u.getMessage());
                }
            }
            else if(searchMode == 3){
                String nameUser = JOptionPane.showInputDialog(mainMenu,"Digite o nome que deseja pesquisar: ");
                try{
                    HashMap<Integer,User> allUsersName = manager.filterUserName(nameUser);
                    JOptionPane.showMessageDialog(mainMenu,allUsersName);
                } catch (UserNoExistException u){
                    JOptionPane.showMessageDialog(mainMenu,u.getMessage());
                }
            }
            else if (searchMode == 4){
                int ageUser = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"Qual idade deseja pesquisar?: "));
                try{
                    HashMap<Integer,User> allAgeUsers = manager.filterUserAge(ageUser);
                    JOptionPane.showMessageDialog(mainMenu,allAgeUsers);
                } catch (UserNoExistException u){
                    JOptionPane.showMessageDialog(mainMenu,u.getMessage());
                }

            }
        }


    }
}

