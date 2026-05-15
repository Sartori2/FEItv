package com.mycompany.feitv.dao;

import com.mycompany.feitv.model.ListaReproducao;
import com.mycompany.feitv.model.Video;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaDAO {

    private Connection conn;

    public ListaDAO(Connection conn) {
        this.conn = conn;
    }

    public void criar(ListaReproducao lista) throws SQLException {
        String sql = "INSERT INTO lista_reproducao (nome, id_usuario) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, lista.getNome());
        stmt.setInt(2, lista.getIdUsuario());
        stmt.execute();
        conn.close();
    }

    public void excluir(int idLista) throws SQLException {
        String sqlVideos = "DELETE FROM video_lista WHERE id_lista = ?";
        PreparedStatement stmt1 = conn.prepareStatement(sqlVideos);
        stmt1.setInt(1, idLista);
        stmt1.execute();

        String sql = "DELETE FROM lista_reproducao WHERE id = ?";
        PreparedStatement stmt2 = conn.prepareStatement(sql);
        stmt2.setInt(1, idLista);
        stmt2.execute();
        conn.close();
    }

    public void editar(int idLista, String novoNome) throws SQLException {
        String sql = "UPDATE lista_reproducao SET nome = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, novoNome);
        stmt.setInt(2, idLista);
        stmt.execute();
        conn.close();
    }

    public List<ListaReproducao> listarPorUsuario(int idUsuario) throws SQLException {
        List<ListaReproducao> listas = new ArrayList<>();
        String sql = "SELECT * FROM lista_reproducao WHERE id_usuario = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ListaReproducao l = new ListaReproducao();
            l.setId(rs.getInt("id"));
            l.setNome(rs.getString("nome"));
            l.setIdUsuario(rs.getInt("id_usuario"));
            listas.add(l);
        }
        return listas;
    }

    public void adicionarVideo(int idLista, int idVideo) throws SQLException {
        String sql = "INSERT INTO video_lista (id_lista, id_video) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idLista);
        stmt.setInt(2, idVideo);
        stmt.execute();
        conn.close();
    }

    public void removerVideo(int idLista, int idVideo) throws SQLException {
        String sql = "DELETE FROM video_lista WHERE id_lista = ? AND id_video = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idLista);
        stmt.setInt(2, idVideo);
        stmt.execute();
        conn.close();
    }
    
    public List<Video> listarVideosDaLista(int idLista) throws SQLException {
        List<Video> videos = new ArrayList<>();
        String sql = "SELECT v.* FROM video v "
                   + "INNER JOIN video_lista vl ON v.id = vl.id_video "
                   + "WHERE vl.id_lista = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idLista);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Video v = new Video(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("descricao"),
                rs.getString("canal"),
                rs.getInt("curtidas"),
                rs.getString("thumbnail")
            ) {};
            videos.add(v);
        }
        return videos;
    }
    
}