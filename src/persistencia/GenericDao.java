/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;


public abstract class GenericDao {
    private Connection connection;

    protected GenericDao() {
        this.connection = Conexao.conectar();
    }

    protected Connection getConnection() {
        return connection;
    }
    
    //Salvar, Deletar, outras funções sem retorno
    public void execute(String sql,Object... parametros)throws SQLException{ 
        PreparedStatement pst = getConnection().prepareStatement(sql);
			
        for (int i = 0; i < parametros.length; i++) {
            pst.setObject(i+1, parametros[i]);
        }

        pst.execute();
        pst.close();
        connection.close();
  
    }
  
    protected void update(String sql, Object old, Object... parametros) throws SQLException {
        PreparedStatement pst = getConnection().prepareStatement(sql);
			
        for (int i = 0; i < parametros.length; i++) {
            pst.setObject(i+1, parametros[i]);
        }
        pst.setObject(parametros.length + 1, old);
        pst.execute();
        pst.close();
        connection.close();
    }

    protected ArrayList list(String sql, Object...parametros)throws SQLException{
        
        PreparedStatement pst = getConnection().prepareStatement(sql);
        for (int i = 0; i < parametros.length; i++) {
            pst.setObject(i+1, parametros[i]);
        }
        
        ArrayList<String> lista = new ArrayList<>();
        ResultSet rs = pst.executeQuery();
        
        ResultSetMetaData rsmd = rs.getMetaData();
        int numColunas = rsmd.getColumnCount();
         
        while(rs.next()){          
            for(int i = 1; i <= numColunas; i++){
                lista.add(rs.getString(i));                   
            }            
        }
        
        pst.close();
        rs.close();
        connection.close();

        return lista;
        
    }
    
    public ArrayList searchString(String listasql, Object... parametros) throws SQLException{
        
        PreparedStatement pst = getConnection().prepareStatement(listasql);
        
        for (int i = 0; i < parametros.length; i++) {
            pst.setObject(i+1, "%"+parametros[i]+"%");
        }
        
        ArrayList<String> lista = new ArrayList<>();
        ResultSet rs = pst.executeQuery();
        
        ResultSetMetaData rsmd = rs.getMetaData();
        int numColunas = rsmd.getColumnCount();
         
        while(rs.next()){          
            for(int i = 1; i <= numColunas; i++){
                lista.add(rs.getString(i));                   
            }            
        }

        pst.close();
        rs.close();
        connection.close();
       
        return lista;
        
    }    
    
}
