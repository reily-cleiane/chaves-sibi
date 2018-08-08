
package sistemachaves;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JavaConnect {
    
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:lib\\bancodedados\\BDchaves";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
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
