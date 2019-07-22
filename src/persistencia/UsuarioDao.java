package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDao extends GenericDao{
    
    public void salvar(Usuario usuario) throws SQLException {
        String insert = "INSERT INTO usuario(matricula,nome) VALUES(?,?)";
        execute(insert, usuario.getMatricula(), usuario.getNome());
    }
    
    public void alterar(String old_matricula, Usuario usuario ) throws SQLException {
        String update = "UPDATE usuario " +
                "SET matricula = ?, nome = ? " +
                "WHERE matricula = ?";
        update(update, old_matricula, usuario.getMatricula(), usuario.getNome() );
    }
    
    public void excluir(String matricula) throws SQLException {
        String delete = "DELETE FROM usuario WHERE matricula = ?";
        execute(delete, matricula);
    }
    
    public ArrayList checarExiste(String matricula)throws SQLException{         
        String checar = "select matricula,nome FROM usuario where matricula = ?";
        ArrayList<String> usuario = list(checar,matricula);  

        return usuario;       
    }
   
    public ArrayList listar()throws SQLException{ 
        String sql = "select matricula,nome FROM usuario order by nome";
        ArrayList<String> lista = list(sql);
       
        return lista;        
    }

    public ArrayList pegarUsuariosNome(String nome)throws SQLException{ 
        String listasql = "select matricula, nome FROM usuario WHERE nome like ?";          
        ArrayList<String> lista = searchString(listasql,nome);

        return lista;
    }
      
    public void apagarAntigos()throws SQLException{        
        String sql = "delete from emprestimo where emp_usuario not in "
                + "(select distinct emp_usuario from emprestimo where datadev > (strftime('%Y', 'now', '-1 year')))";
        execute(sql);
        
        UsuarioDao apagar = new UsuarioDao();
        sql = "delete from usuario where matricula not in "
                + "(select distinct emp_usuario from emprestimo where datadev > (strftime('%Y', 'now', '-1 year')))";
        apagar.execute(sql);
    }
    
    public ArrayList checarEmprestimoAtivo(Usuario usuario)throws SQLException{       
        String checar = "select emp_usuario, emp_objeto FROM emprestimo where (emp_usuario = ?) AND datadev IS NULL";     
        return list(checar,usuario.getMatricula());
    }

}
