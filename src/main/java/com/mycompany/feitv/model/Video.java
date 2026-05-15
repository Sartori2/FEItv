package com.mycompany.feitv.model;

/**
 *
 * @author user
 */
public abstract class Video {
    
    private int id;
    private String titulo;
    private String descricao;
    private String canal;
    private int curtidas;
    private String thumbnail;
    
    public Video() {
    }
    
    public Video(int id, String titulo, String descricao, String canal, int curtidas, String thumbnail) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.canal = canal;
        this.curtidas = curtidas;
        this.thumbnail = thumbnail;
    }
    
    public String getThumbnail() { 
        return thumbnail; 
    }
    
    public void setThumbnail(String thumbnail) { 
        this.thumbnail = thumbnail; 
    }
    
    public int getId() { 
        return id; 
    }
    
    public void setId(int id) { 
        this.id = id; 
    }
    
    public String getTitulo() { 
        return titulo; 
    }
    
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }
    
    public String getDescricao() { 
        return descricao; 
    }
    
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }
    
    public String getCanal() { 
        return canal; 
    }
    
    public void setCanal(String canal) { 
        this.canal = canal; 
    }
    
    public int getCurtidas() { 
        return curtidas; 
    }
    
    public void setCurtidas(int curtidas) { 
        this.curtidas = curtidas; 
    }
}
