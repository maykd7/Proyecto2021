
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarDB {
    private static Connection coneccion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/proyec2021";
    
    public ConectarDB(){
        coneccion = null;
        try {
            Class.forName(driver);
            coneccion = (Connection) DriverManager.getConnection(url, usuario, pass);
            if(coneccion != null){
                System.out.println("Coneccion exitosa ");
            } 
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error de coneccion: " + ex);
        }
    }
    
    public Connection inciarConeccion(){
        return coneccion;
    }
    
    public void desconectar(){
        coneccion = null;
        if(coneccion == null){
            System.out.println("Se desconecto bien");
        }
    }
}
