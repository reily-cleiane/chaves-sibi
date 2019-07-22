package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import persistencia.*;

public class Emprestimo {
    private int id;
    Objeto objeto;
    Usuario usuario;
    Calendar dataemprestimo;
    Calendar datadevolucao;


    public Emprestimo(){
        
    }
    
    public Emprestimo(Usuario usuario, Objeto objeto) {
        this.objeto = objeto;
        this.usuario = usuario;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Calendar getDataemprestimo() {
        return dataemprestimo;
    }

    public void setDataemprestimo(Calendar dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }

    public Calendar getDatadevolucao() {
        return datadevolucao;
    }

    public void setDatadevolucao(Calendar datadevolucao) {
        this.datadevolucao = datadevolucao;
    }
    
    public String salvar(Emprestimo emprestimo) throws SQLException{
        
        String msgRetorno = "";
        ArrayList existeObj = new ObjetoDao().checarExiste(Integer.toString(emprestimo.getObjeto().getId()));

        if(existeObj.isEmpty()){
            msgRetorno = "Não existe chave/objeto cadastrado com esse número";
            return msgRetorno; 
        }
        
        ArrayList userEmpAtivo = new UsuarioDao().checarEmprestimoAtivo(emprestimo.getUsuario());
        ArrayList objEmpAtivo = new ObjetoDao().checarEmprestimoAtivo(emprestimo.getObjeto());
        boolean usuario = userEmpAtivo.isEmpty();
        boolean objeto = objEmpAtivo.isEmpty();
        
        //lista todos os tipos de objeto que o usuário está com empréstimo ativo
        ArrayList<String> tipoObjEmp = new ArrayList<>();
        
        //percorre cada empréstimo ativo do usuário
        for(int i = 1; i<userEmpAtivo.size(); i+=2){
            //busca na tabela objeto as informações de cada objeto emprestado (ativo) pelo usuário
            ArrayList<String> objEmprestadosUsuario = new ObjetoDao().checarExiste(""+userEmpAtivo.get(i));
            //adiciona à lista o tipo de objeto
            tipoObjEmp.add(objEmprestadosUsuario.get(1));
                       
        }
        
        boolean tiposIguais = tipoObjEmp.contains(""+existeObj.get(1));
        
        if((usuario && objeto) || (!usuario && objeto && !tiposIguais)){           
            new EmprestimoDao().salvar(emprestimo);

        } else if(!usuario && !objeto){
            msgRetorno = "Usuário já possui empréstimo. Chave já está emprestada";

        } else if(!usuario){
            msgRetorno =  "Usuário já possui empréstimo.";

        }else{            
            msgRetorno =  "Chave já emprestada";            
        }      

        return msgRetorno;
        
    } 
    
}