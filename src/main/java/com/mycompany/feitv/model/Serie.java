package com.mycompany.feitv.model;

public class Serie extends Video {
    
    private int duracao;
    private int visualizacoes;
    
    public Serie() {
    }
    
    public Serie(int id, String titulo, String descricao, String canal,
                 int curtidas, String thumbnail, int duracao, int visualizacoes) {
        super(id, titulo, descricao, canal, curtidas, thumbnail);
        this.duracao = duracao;
        this.visualizacoes = visualizacoes;
    }
    
    public int getDuracao() { 
        return duracao; 
    }
    
    public void setDuracao(int duracao) { 
        this.duracao = duracao; 
    }
    
    public int getVisualizacoes() { 
        return visualizacoes; 
    }
    
    public void setVisualizacoes(int visualizacoes) { 
        this.visualizacoes = visualizacoes; 
    }
}