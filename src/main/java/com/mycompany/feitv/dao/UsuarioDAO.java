package com.mycompany.feitv.dao;

import com.mycompany.feitv.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    private Connection conn;
    
    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());
        stmt.execute();
        conn.close();
    }
    
    public ResultSet consultar(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, usuario.getEmail());
        stmt.setString(2, usuario.getSenha());
        stmt.execute();
        ResultSet resultado = stmt.getResultSet();
        return resultado;
    }
}