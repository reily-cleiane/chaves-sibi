package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Objeto;


public class ObjetoDao extends GenericDao{
    
    public String salvar(Objeto objeto) throws SQLException{
        String id = null;
        String insert = "INSERT INTO objeto(tipo) VALUES(?)";
        execute(insert, objeto.getTipo());

        ObjetoDao novoobj = new ObjetoDao();
        id = novoobj.ultimoObj();
 
        return id ;
    }
    
    public void alterar(String old_id, Objeto objeto) throws SQLException {
        String update = "UPDATE objeto " +
                "SET id = ?, tipo = ?" +
                "WHERE id = ?";

        update(update, old_id, objeto.getId(), objeto.getTipo());
        
    }
    
    public ArrayList tiposObj() throws SQLException {
        String sql = "SELECT distinct tipo FROM objeto"; 
        ArrayList lista = list(sql);
        return lista;
    }
    
    public String ultimoObj()throws SQLException {
        String sql = "SELECT MAX(id) FROM objeto";       
        ArrayList lista = list(sql);
        String id = String.valueOf(lista.get(0));
        return id;
    }
    

    public ArrayList checarExiste(String id)throws SQLException{         
        String checar = "select id,tipo FROM objeto where id = ?";
        ArrayList<String> obj = list(checar,id);
        
        return obj;
        
    }
    
    public ArrayList checarEmprestimoAtivo(Objeto objeto)throws SQLException{       
        String checar = "Select emp_objeto FROM emprestimo where (emp_objeto = ?) AND datadev IS NULL";
        ArrayList<String> lista = list(checar,objeto.getId());
        
        return lista;

    }
    
}
