/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import modelo.Professor;

/**
 *
 * @author guelp
 */
public class ControladorProfessor {
    
    JTextField jTextFieldId, jTextFieldNome, jTextFieldDisciplina;
    JList<String> jListProfessor;
    JButton jButtonSalvarEditar;
    
    ArrayList<Professor> listaProfessor = new ArrayList<>(); 
    DefaultListModel<String> defaultListModel;
    
    int index;

    public ControladorProfessor(JTextField jTextFieldId, JTextField jTextFieldNome, JTextField jTextFieldDisciplina, JList<String> jListProfessor, JButton jButtonSalvarEditar) {
        this.jTextFieldId = jTextFieldId;
        this.jTextFieldNome = jTextFieldNome;
        this.jTextFieldDisciplina = jTextFieldDisciplina;
        this.jListProfessor = jListProfessor;
        this.jButtonSalvarEditar = jButtonSalvarEditar;
    }

    
    
    public void salvarEditar() {
        int id = Integer.parseInt(jTextFieldId.getText());
        String nome = jTextFieldNome.getText();
        String Disciplina = jTextFieldDisciplina.getText();
       
        
        Professor professor = new Professor(id, nome, Disciplina);
        
        if (jButtonSalvarEditar.getText().compareToIgnoreCase("Salvar") == 0) {
            listaProfessor.add(professor);
        } else {
            listaProfessor.set(index, professor);
        }
        
        carregarListaAlunos();
        limpar();
    }
    
    public void carregarListaAlunos() {
        defaultListModel = new DefaultListModel<>();
        ArrayList<String> listaAtualizada = new ArrayList<>();
        for (Professor professor : listaProfessor) {
            listaAtualizada.add(professor.nome + " - " + professor.id + " - " + professor.disciplina );
        }
      
        Collections.sort(listaAtualizada);
        defaultListModel.addAll(listaAtualizada);
        jListProfessor.setModel(defaultListModel);
    }
    
   
    public void limpar() {
        jTextFieldId.setText(gerarId() + "");
        jTextFieldNome.setText("");
        jTextFieldDisciplina.setText("");
        jButtonSalvarEditar.setText("Salvar");
    }
    
    public void SelecionarAluno() {
        String selecionado = jListProfessor.getSelectedValue();
        if (selecionado == null) {
            return; // nada selecionado
        }
        index = 0;
        
        for (Professor professor : listaProfessor) {
            String temp = professor.nome + " - " + professor.id + " - " + professor.disciplina ;
            if (temp.compareToIgnoreCase(selecionado) == 0) {
                jTextFieldId.setText(professor.id + "");
                jTextFieldNome.setText(professor.nome);
                jTextFieldDisciplina.setText(professor.disciplina);
                jButtonSalvarEditar.setText("Editar");
                break;
            }
            index++;
        }
    }
        
    public int gerarId() {
        if (listaProfessor.isEmpty()) {
            return 1;
        }
        Professor ultimo = listaProfessor.get(listaProfessor.size() - 1);
        return ultimo.id + 1;
    }
    
    
}
