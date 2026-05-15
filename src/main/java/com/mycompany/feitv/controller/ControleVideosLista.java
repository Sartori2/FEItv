package com.mycompany.feitv.controller;

import com.mycompany.feitv.dao.Conexao;
import com.mycompany.feitv.dao.ListaDAO;
import com.mycompany.feitv.dao.VideoDAO;
import com.mycompany.feitv.model.ListaReproducao;
import com.mycompany.feitv.model.Usuario;
import com.mycompany.feitv.model.Video;
import com.mycompany.feitv.view.VideoLista;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ControleVideosLista {

    private VideoLista tela;
    private Usuario usuarioLogado;
    private ListaReproducao lista;
    private List<Video> videosCarregados;

    public ControleVideosLista(VideoLista tela, Usuario usuarioLogado, ListaReproducao lista) {
        this.tela = tela;
        this.usuarioLogado = usuarioLogado;
        this.lista = lista;
    }

    public void carregarVideos() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            ListaDAO dao = new ListaDAO(conn);
            videosCarregados = dao.listarVideosDaLista(lista.getId());
            DefaultListModel<String> model = new DefaultListModel<>();
            for (Video v : videosCarregados) {
                model.addElement(v.getTitulo() + " - " + v.getCanal());
            }
            tela.getListVideos().setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao carregar vídeos",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void removerVideo() {
        int index = tela.getListVideos().getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(tela, "Selecione um vídeo",
                                          "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Video video = videosCarregados.get(index);
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            ListaDAO dao = new ListaDAO(conn);
            dao.removerVideo(lista.getId(), video.getId());
            JOptionPane.showMessageDialog(tela, "Vídeo removido",
                                          "Aviso", JOptionPane.INFORMATION_MESSAGE);
            carregarVideos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao remover vídeo",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void adicionarVideo() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            List<Video> todosVideos = dao.listarTodos();
            String[] opcoes = new String[todosVideos.size()];
            for (int i = 0; i < todosVideos.size(); i++) {
                opcoes[i] = todosVideos.get(i).getTitulo() + " - " + todosVideos.get(i).getCanal();
            }
            String escolha = (String) JOptionPane.showInputDialog(tela,
                "Escolha um vídeo:", "Adicionar vídeo",
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            if (escolha == null) return;
            int index = java.util.Arrays.asList(opcoes).indexOf(escolha);
            Video videoEscolhido = todosVideos.get(index);
            
            Connection conn2 = new Conexao().getConnection();
            ListaDAO listaDAO = new ListaDAO(conn2);
            listaDAO.adicionarVideo(lista.getId(), videoEscolhido.getId());
            JOptionPane.showMessageDialog(tela, "Vídeo adicionado",
                                          "Aviso", JOptionPane.INFORMATION_MESSAGE);
            carregarVideos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao adicionar vídeo",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}