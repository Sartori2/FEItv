package com.mycompany.feitv.controller;

import com.mycompany.feitv.dao.Conexao;
import com.mycompany.feitv.dao.VideoDAO;
import com.mycompany.feitv.model.Video;
import com.mycompany.feitv.view.Home;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleHome {
    
    private Home tela;
    
    public ControleHome(Home tela) {
        this.tela = tela;
    }
    
    public void carregarVideos() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            List<Video> videos = dao.listarTodos();
            
            tela.getLblTitulo1().setText(videos.get(0).getTitulo());
            tela.getLblTitulo2().setText(videos.get(1).getTitulo());
            tela.getLblTitulo3().setText(videos.get(2).getTitulo());
            tela.getLblTitulo4().setText(videos.get(3).getTitulo());
            tela.getLblTitulo5().setText(videos.get(4).getTitulo());
            tela.getLblTitulo6().setText(videos.get(5).getTitulo());
            
            tela.getLblCanal1().setText(videos.get(0).getCanal());
            tela.getLblCanal2().setText(videos.get(1).getCanal());
            tela.getLblCanal3().setText(videos.get(2).getCanal());
            tela.getLblCanal4().setText(videos.get(3).getCanal());
            tela.getLblCanal5().setText(videos.get(4).getCanal());
            tela.getLblCanal6().setText(videos.get(5).getCanal());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Vídeo não carregado",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void buscarVideo() {
        String busca = tela.getTxtBusca().getText();
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            List<Video> videos = dao.buscarPorTitulo(busca);
            if (videos.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "Nenhum vídeo encontrado",
                                              "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(tela, "Vídeo encontrado: " + videos.get(0).getTitulo(),
                                              "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao encontrar vídeo",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
