package com.mycompany.feitv.model;

public class ListaReproducao {
    
    private int id;
    private String nome;
    private int idUsuario;
    
    public ListaReproducao() {
    }
    
    public ListaReproducao(String nome, int idUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
    }
    
    public int getId() { 
        return id; 
    }
    
    public void setId(int id) { 
        this.id = id; 
    }
    
    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    
    public int getIdUsuario() { 
        return idUsuario; 
    }
    
    public void setIdUsuario(int idUsuario) { 
        this.idUsuario = idUsuario; 
    }
    
    @Override
    public String toString() {
        return nome;
    }
}