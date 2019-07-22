package persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import view.RelatorioEmpAtivo;
import view.RelatorioMes;

/**
 * @author 1856521
 */
public class RelatorioDao {
    
    private Connection connection;

    public RelatorioDao() {
        this.connection = Conexao.conectar();
    }

    protected Connection getConnection() {
        return connection;
    }
    
    public ArrayList<RelatorioEmpAtivo> exibirEmpAtivo() throws SQLException {
        
        String sql = "select usuario.matricula, usuario.nome, emprestimo.emp_objeto, emprestimo.dataemp from usuario"
                + " INNER JOIN emprestimo on (usuario.matricula = emp_usuario) WHERE datadev IS NULL ORDER BY dataemp";
         
        ArrayList<RelatorioEmpAtivo> lista = new ArrayList<>();

        try{
            PreparedStatement pst = getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                RelatorioEmpAtivo rel = new RelatorioEmpAtivo(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4));               
                lista.add(rel); 
                
            }
            
            pst.close();
            rs.close();
            connection.close();

        }catch (SQLException e){         
            System.out.println("Erro RelatorioDao empAtivo"+ e.getLocalizedMessage());
        }
        
        return lista;
    }
    
    
    public ArrayList<RelatorioMes> exibirMes(String mes){
        String sql;
        switch(mes){
            case "atual":
                sql = "select usuario.matricula, usuario.nome, emprestimo.emp_objeto, emprestimo.dataemp, emprestimo.datadev from usuario"
                + " INNER JOIN emprestimo on (usuario.matricula = emp_usuario)"
                + " WHERE dataemp <= (datetime('now'))"
                + " AND dataemp >= (strftime('%Y', 'now') || '-' || strftime('%m', 'now')) ORDER BY dataemp;";               
                break;
            case "anterior": 
                sql = "select usuario.matricula, usuario.nome, emprestimo.emp_objeto, emprestimo.dataemp, emprestimo.datadev from usuario"
                + " INNER JOIN emprestimo on (usuario.matricula = emp_usuario)"
                + " WHERE dataemp >= (strftime('%Y-%m', 'now', '-1 month'))"
                + " AND dataemp < date('now', 'start of month') ORDER BY dataemp;";
                break;
            default:
                sql = "select usuario.matricula, usuario.nome, emprestimo.emp_objeto, emprestimo.dataemp, emprestimo.datadev from usuario"
                + " INNER JOIN emprestimo on (usuario.matricula = emp_usuario)"
                + " WHERE dataemp <= (datetime('now'))"
                + " AND dataemp >= (strftime('%Y', 'now') || '-' || strftime('%m', 'now')) ORDER BY dataemp;"; 
        }
                       
        ArrayList<RelatorioMes> lista = new ArrayList<>();
        try{
            PreparedStatement pst = getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                RelatorioMes rel;
                
                if(rs.getString(5)== null){
                    rel = new RelatorioMes(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), "");  
                    
                } else{
                    rel = new RelatorioMes(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));  
                }
                             
                lista.add(rel);  

            }
            
            pst.close();
            rs.close();
            connection.close();

        }catch (SQLException e){         
            System.out.println("Erro RelatorioDao Mes"+ e.getLocalizedMessage());
        }
        
        return lista;
    }

    
    public ArrayList<RelatorioMes> exibirPeriodo(Object... parametros){
     
        ArrayList<RelatorioMes> lista = new ArrayList<>();
        String sql = "select usuario.matricula, usuario.nome, emprestimo.emp_objeto, emprestimo.dataemp, emprestimo.datadev from usuario"
                + " INNER JOIN emprestimo on (usuario.matricula = emp_usuario)"
                + " WHERE dataemp >= ? "
                + " AND dataemp < ? ORDER BY dataemp";
        
        try{
            PreparedStatement pst = getConnection().prepareStatement(sql);
                 
            for (int i = 0; i < parametros.length; i++) {
                pst.setObject(i+1, parametros[i]);
            }

            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                RelatorioMes rel;
               
                if(rs.getString(5)== null){
                    rel = new RelatorioMes(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), "");  
                    
                } else{
                    rel = new RelatorioMes(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));  
                }
                
                lista.add(rel);                
            }

            pst.close();
            rs.close();
            connection.close();

        }catch (SQLException e){         
            System.out.println("Erro RelatorioDao Mes"+ e.getLocalizedMessage());
        }
        
        return lista;
    }
    
    
}
