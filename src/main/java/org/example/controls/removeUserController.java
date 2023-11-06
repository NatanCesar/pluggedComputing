package org.example.controls;

import org.example.ManagerPluggedComputingInterface;
import org.example.exceptions.QuestionNoExistException;
import org.example.exceptions.UserNoExistException;
import org.example.model.Question;
import org.example.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removeUserController implements ActionListener {
    private ManagerPluggedComputingInterface manager;
    private JFrame mainMenu;


    public removeUserController(ManagerPluggedComputingInterface manager, JFrame mainMenu) {
        this.manager = manager;
        this.mainMenu = mainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
    try {
        int userID = Integer.parseInt(JOptionPane.showInputDialog(mainMenu,"Digite o ID do usuário que deseja apagar"));
        User user = manager.searchUser(userID);
        String answearDelete = JOptionPane.showInputDialog(mainMenu, user.toString() + "\n\nDigite SIM caso queira apagar esse usuário.");
        if (answearDelete.toLowerCase().equals("sim")){
            manager.removeUser(userID);
            JOptionPane.showMessageDialog(mainMenu,"USUÁRIO APAGADO COM SUCESSO.");
        }
    } catch(UserNoExistException u){
        JOptionPane.showMessageDialog(mainMenu,u.getMessage());
    }
}
}
