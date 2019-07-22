package controller;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import model.Usuario;
import persistencia.UsuarioDao;

/**
 * @author cleiane
 */
public class UsuarioController {
    
    
    public void apagarAntigos()throws SQLException{
        new UsuarioDao().apagarAntigos();
         
    }

    public ArrayList relatorioUsuarios() throws SQLException{              
        ArrayList lista = new UsuarioDao().listar();
        return lista;
       
    }
    
    public void salvar(String matricula, String nome) throws SQLException, ParseException {
        Usuario usuario = new Usuario();
        usuario.setMatricula(matricula);
        usuario.setNome(nome);

        new UsuarioDao().salvar(usuario);
    }
    
    public void alterar(String old_matricula, String new_matricula,String nome ) throws SQLException, ParseException {
        Usuario new_usuario = new Usuario();
        new_usuario.setMatricula(new_matricula);
        new_usuario.setNome(nome);
        
        new UsuarioDao().alterar(old_matricula, new_usuario);
        
    }
    
    public ArrayList pegarUsuarioMatricula(String matricula)throws SQLException{
        ArrayList dadosUsuario = new UsuarioDao().checarExiste(matricula);       
        return dadosUsuario;
    }
    
    public ArrayList pegarUsuariosNome(String nome)throws SQLException{
        ArrayList listaUsuarios = new UsuarioDao().pegarUsuariosNome(nome);       
        return listaUsuarios;
        
    }
      
}
