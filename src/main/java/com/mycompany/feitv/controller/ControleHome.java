package com.mycompany.feitv.controller;

import com.mycompany.feitv.dao.Conexao;
import com.mycompany.feitv.dao.VideoDAO;
import com.mycompany.feitv.model.Usuario;
import com.mycompany.feitv.model.Video;
import com.mycompany.feitv.view.Home;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControleHome {
    
    private Home tela;
    private Usuario usuarioLogado;
    
    public ControleHome(Home tela, Usuario usuarioLogado) {
        this.tela = tela;
        this.usuarioLogado = usuarioLogado;
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
        
        // Verifica curtidas de cada vídeo
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videos.get(0).getId()))
            tela.getBtnCurtir1().setText("❤️ Curtir");
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videos.get(1).getId()))
            tela.getBtnCurtir2().setText("❤️ Curtir");
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videos.get(2).getId()))
            tela.getBtnCurtir3().setText("❤️ Curtir");
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videos.get(3).getId()))
            tela.getBtnCurtir4().setText("❤️ Curtir");
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videos.get(4).getId()))
            tela.getBtnCurtir5().setText("❤️ Curtir");
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videos.get(5).getId()))
            tela.getBtnCurtir6().setText("❤️ Curtir");
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(tela, "Erro ao carregar vídeos!",
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
    
    public void curtirVideo(int idVideo, JButton btnCurtir) {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);

            if (dao.usuarioCurtiu(usuarioLogado.getId(), idVideo)) {
                // já curtiu, então descurte
                dao.descurtir(usuarioLogado.getId(), idVideo);
                btnCurtir.setText("Curtir");
            } else {
                // não curtiu, então curte
                dao.curtir(usuarioLogado.getId(), idVideo);
                btnCurtir.setText("❤️ Descurtir");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao curtir!",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
