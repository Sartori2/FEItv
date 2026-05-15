package com.mycompany.feitv.model;

public class Filme extends Video {
    
    private String titulo;
    private String canal;
    
    public Filme() {
    }
    
    public Filme(int id, String titulo, String descricao, String canal, 
                 int curtidas, String thumbnail) {
        super(id, titulo, descricao, canal, curtidas, thumbnail);
        this.titulo = titulo;
        this.canal = canal;
    }
    
    public String getTitulo() { 
        return titulo; 
    }
    
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }
    
    public String getCanal() { 
        return canal; 
    }
    
    public void setCanal(String canal) { 
        this.canal = canal; 
    }
}