
package jframe;
import com.sun.source.tree.TryTree;
import java.sql.*;

/**
 *
 * @author Hello
 */
public class DBConnection {
    
    /*
    Connection con;
    public Statement s;
    public DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            s=con.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
*/
 
    static  Connection con = null;
    
    public static Connection getConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
}
