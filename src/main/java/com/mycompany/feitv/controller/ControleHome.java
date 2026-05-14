package com.mycompany.feitv.controller;

import com.mycompany.feitv.dao.Conexao;
import com.mycompany.feitv.dao.VideoDAO;
import com.mycompany.feitv.model.Usuario;
import com.mycompany.feitv.model.Video;
import com.mycompany.feitv.view.Home;
import com.mycompany.feitv.view.InformacaoVideo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControleHome {
    
    private Home tela;
    private Usuario usuarioLogado;
    private List<Video> videosCarregados;
    
    public ControleHome(Home tela, Usuario usuarioLogado) {
        this.tela = tela;
        this.usuarioLogado = usuarioLogado;
    }
    
public void carregarVideos() {
    Conexao conexao = new Conexao();
    try {
        Connection conn = conexao.getConnection();
        VideoDAO dao = new VideoDAO(conn);
        videosCarregados = dao.listarTodos();
        
        tela.getLblTitulo1().setText(videosCarregados.get(0).getTitulo());
        tela.getLblTitulo2().setText(videosCarregados.get(1).getTitulo());
        tela.getLblTitulo3().setText(videosCarregados.get(2).getTitulo());
        tela.getLblTitulo4().setText(videosCarregados.get(3).getTitulo());
        tela.getLblTitulo5().setText(videosCarregados.get(4).getTitulo());
        tela.getLblTitulo6().setText(videosCarregados.get(5).getTitulo());
        
        tela.getLblCanal1().setText(videosCarregados.get(0).getCanal());
        tela.getLblCanal2().setText(videosCarregados.get(1).getCanal());
        tela.getLblCanal3().setText(videosCarregados.get(2).getCanal());
        tela.getLblCanal4().setText(videosCarregados.get(3).getCanal());
        tela.getLblCanal5().setText(videosCarregados.get(4).getCanal());
        tela.getLblCanal6().setText(videosCarregados.get(5).getCanal());
        
        // Verifica curtidas de cada vídeo
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videosCarregados.get(0).getId()))
            tela.getBtnCurtir1().setText("❤️ Descurtir");
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videosCarregados.get(1).getId()))
            tela.getBtnCurtir2().setText("❤️ Descurtir");
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videosCarregados.get(2).getId()))
            tela.getBtnCurtir3().setText("❤️ Descurtir");
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videosCarregados.get(3).getId()))
            tela.getBtnCurtir4().setText("❤️ Descurtir");
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videosCarregados.get(4).getId()))
            tela.getBtnCurtir5().setText("❤️ Descurtir");
        if (dao.usuarioCurtiu(usuarioLogado.getId(), videosCarregados.get(5).getId()))
            tela.getBtnCurtir6().setText("❤️ Descurtir");
        
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
                JOptionPane.showMessageDialog(tela, "Nenhum vídeo encontrado!",
                                              "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                // mostra todos os videos encontrados
                StringBuilder resultado = new StringBuilder("Vídeos encontrados:\n");
                for (Video v : videos) {
                    resultado.append("- ").append(v.getTitulo())
                             .append(" (").append(v.getCanal()).append(")\n");
                }
                JOptionPane.showMessageDialog(tela, resultado.toString(),
                                              "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao buscar vídeo!",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void curtirVideo(int posicao, JButton btnCurtir) {
        int idVideo = videosCarregados.get(posicao).getId();
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);

            if (dao.usuarioCurtiu(usuarioLogado.getId(), idVideo)) {
                dao.descurtir(usuarioLogado.getId(), idVideo);
                btnCurtir.setText("Curtir");
            } else {
                dao.curtir(usuarioLogado.getId(), idVideo);
                btnCurtir.setText("❤️ Descurtir");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao curtir!",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

    public void abrirVideo(int posicao) {
        Video video = videosCarregados.get(posicao);
        InformacaoVideo tela = new InformacaoVideo(usuarioLogado, video);
        tela.setVisible(true);
    }
}
