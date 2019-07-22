
package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import model.*;
import persistencia.EmprestimoDao;
import persistencia.UsuarioDao;


public class EmprestimoController {
    
    public ArrayList exibirEmpUsuario(String matricula) throws SQLException{       
        ArrayList dadosUsuario = new UsuarioDao().checarExiste(matricula);
        
        return dadosUsuario;
        
    }
    
    public void apagarAntigos()throws SQLException{
        new EmprestimoDao().apagarAntigos();
         
    }
    
    public ArrayList listarAtivos()throws SQLException{
        ArrayList lista = new EmprestimoDao().listarAtivos();

        return lista;  
    }
    
    public void devolver(String numObjeto)throws SQLException{
        new EmprestimoDao().devolver(numObjeto);

    }

    public String salvar(String matricula, String numObj) throws SQLException, ParseException {           
        Emprestimo emprestimo = new Emprestimo();
        Usuario usuario = new Usuario();
        Objeto objeto = new Objeto();
        
        usuario.setMatricula(matricula);
        objeto.setId(Integer.valueOf(numObj));
        
        emprestimo.setUsuario(usuario);
        emprestimo.setObjeto(objeto);
        
        String msgRetorno = new Emprestimo().salvar(emprestimo);
        return msgRetorno;
        
    }
    
}
