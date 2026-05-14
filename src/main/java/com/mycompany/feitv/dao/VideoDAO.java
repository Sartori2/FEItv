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
                rs.getInt("curtidas")
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
                rs.getInt("curtidas")
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
}
