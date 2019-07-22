package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

public class EmprestimoDao extends GenericDao{
    
    public void salvar(Emprestimo emprestimo) throws SQLException{
        String insert = "INSERT INTO emprestimo(emp_usuario,emp_objeto) VALUES(?,?)";
        execute(insert, emprestimo.getUsuario().getMatricula(), emprestimo.getObjeto().getId());

    }
    
    public ArrayList listarAtivos()throws SQLException{                 
        String sql_listar = "SELECT emp_objeto FROM emprestimo WHERE datadev IS NULL ORDER BY emp_objeto";    
        ArrayList<String> lista = list(sql_listar);
        return lista;
   
    }
    
    public void apagarAntigos()throws SQLException{         
        String sql = "delete from emprestimo where datadev < (strftime('%Y', 'now', '-1 year'))";
        execute(sql);

    }
    
    public void devolver(String numObjeto)throws SQLException {
        String devolver = "UPDATE emprestimo SET datadev = strftime('%Y-%m-%d %H:%M', 'now', '-3 hour') WHERE emp_objeto = ? AND datadev IS NULL";
        execute(devolver, numObjeto);   
    }
    
     
}
