package com.mycompany.feitv.controller;

import com.mycompany.feitv.dao.Conexao;
import com.mycompany.feitv.dao.ListaDAO;
import com.mycompany.feitv.model.ListaReproducao;
import com.mycompany.feitv.model.Usuario;
import com.mycompany.feitv.view.Favoritos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ControleFavoritos {

    private Favoritos tela;
    private Usuario usuarioLogado;
    private List<ListaReproducao> listas;

    public ControleFavoritos(Favoritos tela, Usuario usuarioLogado) {
        this.tela = tela;
        this.usuarioLogado = usuarioLogado;
    }

    public void carregarListas() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            ListaDAO dao = new ListaDAO(conn);
            listas = dao.listarPorUsuario(usuarioLogado.getId());
            DefaultListModel<String> model = new DefaultListModel<>();
            for (ListaReproducao l : listas) {
                model.addElement(l.getNome());
            }
            tela.getListFav().setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao carregar listas",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void criarLista() {
        String nome = tela.getTxtLista().getText().trim();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(tela, "Digite um nome",
                                          "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            ListaDAO dao = new ListaDAO(conn);
            ListaReproducao lista = new ListaReproducao(nome, usuarioLogado.getId());
            dao.criar(lista);
            tela.getTxtLista().setText("");
            JOptionPane.showMessageDialog(tela, "Lista criada",
                                          "Aviso", JOptionPane.INFORMATION_MESSAGE);
            carregarListas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao criar lista",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluirLista() {
        int index = tela.getListFav().getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(tela, "Selecione uma lista",
                                          "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ListaReproducao lista = listas.get(index);
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            ListaDAO dao = new ListaDAO(conn);
            dao.excluir(lista.getId());
            JOptionPane.showMessageDialog(tela, "Lista excluída",
                                          "Aviso", JOptionPane.INFORMATION_MESSAGE);
            carregarListas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao excluir lista",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editarLista() {
        int index = tela.getListFav().getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(tela, "Selecione uma lista",
                                          "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String novoNome = JOptionPane.showInputDialog(tela, "Digite o novo nome:");
        if (novoNome == null || novoNome.trim().isEmpty()) return;
        
        ListaReproducao lista = listas.get(index);
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            ListaDAO dao = new ListaDAO(conn);
            dao.editar(lista.getId(), novoNome);
            JOptionPane.showMessageDialog(tela, "Lista editada",
                                          "Aviso", JOptionPane.INFORMATION_MESSAGE);
            carregarListas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao editar lista",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}