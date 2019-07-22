
package model;

public class Usuario {
    private String matricula;
    private String nome;
    private String tipo;
    
    public Usuario(){
        
    }
        
    public Usuario(String matricula, String nome) {
        this.matricula = matricula.trim();
        nome = nomeToCapitalize(nome);
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.trim();
    }

    public String getTipo() {
        return tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula.trim();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nomeToCapitalize(nome);
        this.nome = nome;
        
    }
    
  
    private String nomeToCapitalize(String nome) {        
        nome = nome.trim();
        
        String sNova = "";
        
        for (String sNome : nome.toLowerCase().split(" ")) {
            if (!"".equals(sNome)) {
                if (!"".equals(sNova)) {
                    sNova += " ";
                }
                if (sNome.length() > 3) { // utilizado para nomes próprios, para não colocar maiúscula em De, por exemplo
                    sNova += sNome.substring(0, 1).toUpperCase() + sNome.substring(1);
                } else {
                    sNova += sNome;
                }
            }
        }
        return sNova;

    }
    
    
}
