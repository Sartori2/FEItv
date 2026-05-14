package com.mycompany.feitv.controller;

import com.mycompany.feitv.dao.Conexao;
import com.mycompany.feitv.dao.UsuarioDAO;
import com.mycompany.feitv.model.Usuario;
import com.mycompany.feitv.view.Home;
import com.mycompany.feitv.view.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastroLogin {
    
    private Login tela;
    
    public CadastroLogin(Login tela) {
        this.tela = tela;
    }
    
    public void loginUsuario() {
        Usuario usuario = new Usuario(null, tela.getTxtEmail().getText(), 
                                      tela.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(usuario);
            if (res.next()) {
                Usuario usuarioLogado = new Usuario();
                usuarioLogado.setId(res.getInt("id"));
                usuarioLogado.setNome(res.getString("nome"));
                usuarioLogado.setEmail(res.getString("email"));
                Home home = new Home(usuarioLogado);
                home.setVisible(true);
                tela.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(tela, "Email ou senha incorretos!", 
                                              "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro de conexão", 
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}