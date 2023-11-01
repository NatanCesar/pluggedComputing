package org.example.controls;

import org.example.ManagerPluggedComputing;
import org.example.ManagerPluggedComputingInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addUserController implements ActionListener {
    private ManagerPluggedComputingInterface manager;
    private JFrame mainMenu;



    public addUserController(ManagerPluggedComputingInterface manager, JFrame mainMenu) {
        this.manager = (ManagerPluggedComputing) manager;
        this.mainMenu = mainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
