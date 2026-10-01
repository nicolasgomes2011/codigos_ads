/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import visao.TelaProfessor;

/**
 *
 * @author guelp
 */
public class ControladorTela {
    
    JDesktopPane desktopPane;

    public ControladorTela(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

public void abrirTelaProjeto(){
   desktopPane.removeAll();
   desktopPane.updateUI();
   Dimension resolucao = desktopPane.getSize();
   TelaProfessor tela1= new TelaProfessor();
   tela1.setSize(resolucao);
   tela1.setLocation(0, 0);
   desktopPane.add(tela1);
   tela1.setVisible(true);
}

    
}
