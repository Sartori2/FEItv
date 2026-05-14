package com.mycompany.feitv.controller;

import com.mycompany.feitv.dao.Conexao;
import com.mycompany.feitv.dao.VideoDAO;
import com.mycompany.feitv.model.Usuario;
import com.mycompany.feitv.model.Video;
import com.mycompany.feitv.view.InformacaoVideo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleVideo {

    private InformacaoVideo tela;
    private Usuario usuarioLogado;
    private Video video;

    public ControleVideo(InformacaoVideo tela, Usuario usuarioLogado, Video video) {
        this.tela = tela;
        this.usuarioLogado = usuarioLogado;
        this.video = video;
    }

    public void carregarInformacoes() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);

            List<Video> videos = dao.listarTodos();
            for (Video v : videos) {
                if (v.getId() == video.getId()) {
                    video = v;
                    break;
                }
            }

            tela.getLblTitulo().setText(video.getTitulo());
            tela.getLblCanal().setText("Canal: " + video.getCanal());
            tela.getLblCurtidas().setText("Curtidas: " + video.getCurtidas());
            tela.getTxtDescricao().setText(video.getDescricao());
            tela.getTxtDescricao().setEditable(false);

            if (dao.usuarioCurtiu(usuarioLogado.getId(), video.getId())) {
                tela.getBtnCurtir().setText("❤️ Descurtir");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao carregar!",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void curtirVideo() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            if (dao.usuarioCurtiu(usuarioLogado.getId(), video.getId())) {
                dao.descurtir(usuarioLogado.getId(), video.getId());
                tela.getBtnCurtir().setText("Curtir");
                int curtidas = Integer.parseInt(tela.getLblCurtidas().getText().replace("Curtidas: ", "")) - 1;
                tela.getLblCurtidas().setText("Curtidas: " + curtidas);
            } else {
                dao.curtir(usuarioLogado.getId(), video.getId());
                tela.getBtnCurtir().setText("❤️ Descurtir");
                int curtidas = Integer.parseInt(tela.getLblCurtidas().getText().replace("Curtidas: ", "")) + 1;
                tela.getLblCurtidas().setText("Curtidas: " + curtidas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao curtir",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
