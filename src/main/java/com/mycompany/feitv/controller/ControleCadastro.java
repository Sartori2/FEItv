package com.mycompany.feitv.controller;

import com.mycompany.feitv.dao.Conexao;
import com.mycompany.feitv.dao.UsuarioDAO;
import com.mycompany.feitv.model.Usuario;
import com.mycompany.feitv.view.Cadastro;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleCadastro {
    
    private Cadastro tela;
    
    public ControleCadastro(Cadastro tela) {
        this.tela = tela;
    }
    
    public void cadastrarUsuario() {
        String nome = tela.getTxtNome().getText();
        String email = tela.getTxtEmail().getText();
        String senha = tela.getTxtSenha().getText();
        
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(tela, "Preencha todos os campos!",
                                          "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Usuario usuario = new Usuario(nome, email, senha);
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir(usuario);
            JOptionPane.showMessageDialog(tela, "Usuario Cadastrado!",
                                          "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Usuário não cadastrado!",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
