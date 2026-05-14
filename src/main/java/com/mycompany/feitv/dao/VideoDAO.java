package com.mycompany.feitv.dao;

import com.mycompany.feitv.model.Video;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {
    
    private Connection conn;
    
    public VideoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public List<Video> listarTodos() throws SQLException {
        List<Video> videos = new ArrayList<>();
        String sql = "SELECT * FROM video";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Video v = new Video(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("descricao"),
                rs.getString("canal"),
                rs.getInt("curtidas"),
                rs.getString("thumbnail")
            );
            videos.add(v);
        }
        return videos;
    }
    
    public List<Video> buscarPorTitulo(String titulo) throws SQLException {
        List<Video> videos = new ArrayList<>();
        String sql = "SELECT * FROM video WHERE titulo ILIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + titulo + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Video v = new Video(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("descricao"),
                rs.getString("canal"),
                rs.getInt("curtidas"),
                rs.getString("thumbnail")
            );
            videos.add(v);
        }
        return videos;
    }
    
    public void curtir(int id) throws SQLException {
        String sql = "UPDATE video SET curtidas = curtidas + 1 WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        conn.close();
    }
    
    public boolean usuarioCurtiu(int idUsuario, int idVideo) throws SQLException {
        String sql = "SELECT * FROM curtida WHERE id_usuario = ? AND id_video = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        stmt.setInt(2, idVideo);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }

    public void curtir(int idUsuario, int idVideo) throws SQLException {
        String sql = "INSERT INTO curtida (id_usuario, id_video) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        stmt.setInt(2, idVideo);
        stmt.execute();

        String sqlUpdate = "UPDATE video SET curtidas = curtidas + 1 WHERE id = ?";
        PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate);
        stmtUpdate.setInt(1, idVideo);
        stmtUpdate.execute();

        conn.close();
    }

    public void descurtir(int idUsuario, int idVideo) throws SQLException {
        String sql = "DELETE FROM curtida WHERE id_usuario = ? AND id_video = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        stmt.setInt(2, idVideo);
        stmt.execute();

        String sqlUpdate = "UPDATE video SET curtidas = curtidas - 1 WHERE id = ?";
        PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate);
        stmtUpdate.setInt(1, idVideo);
        stmtUpdate.execute();

        conn.close();
    }
    
}
