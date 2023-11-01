package org.example.controls;
import org.example.ManagerPluggedComputingInterface;

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

    }
}
