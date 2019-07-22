
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
    
        public static Connection conectar() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:lib\\bancodedados\\BDchaves";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
                        
            String sql = "PRAGMA foreign_keys = ON";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            
            return conn;
       
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        
        return null;
    }
    
}
