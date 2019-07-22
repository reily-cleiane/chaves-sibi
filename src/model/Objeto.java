package model;

/**
 * @author cleiane
 */
public class Objeto {
    private int id;
    private String tipo;
    
    
    public Objeto(){
        
    }

    public Objeto(int id, String tipo) {
        this.id = id;
        this.tipo = tipo.trim();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.trim();
    }
     
    
}
