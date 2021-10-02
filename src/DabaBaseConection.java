
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Extends
 */
public class DabaBaseConection {
    
    
    public void ingreDatosDataBase(String nn, int ee){
        ConectarDB cdb = new ConectarDB();
        Connection conAct = cdb.inciarConeccion();
        
        String sql = "INSERT INTO uno (id_uno, nombre_uno, edad_uno) VALUES (?,?,?);";
        try {
            PreparedStatement pss = (PreparedStatement) conAct.prepareStatement(sql);
            pss.setInt(1, +0);
            pss.setString(2, nn);
            pss.setInt(3, ee);
            
            int n = pss.executeUpdate();
            if(n > 0){
                System.out.println("Datos Ingredado corractamente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DabaBaseConection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se ingresaron los datos");
        }
    }
    
    public void sacarDatos(){
        ConectarDB cdb = new ConectarDB();
        Connection conAct = cdb.inciarConeccion();
        
        String sql = "SELECT * FROM uno";
        
        try {
            Statement st = (Statement) conAct.createStatement();
            ResultSetImpl rt = (ResultSetImpl) st.executeQuery(sql);
            System.out.println("Id "+"Nombre   "+"   Edad");
            while(rt.next()){
                System.out.print(rt.getInt("id_uno")+ "  ");
                System.out.print(rt.getString("nombre_uno")+ "  ");
                System.out.print(rt.getInt("edad_uno")+ "  ");
                System.out.println();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DabaBaseConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sacarDatosUno(){
        ConectarDB cdb = new ConectarDB();
        Connection conAct = cdb.inciarConeccion();
        
        String sql = "SELECT * FROM `uno` WHERE nombre_uno = 'pedro' ";
        
        try {
            Statement st = (Statement) conAct.createStatement();
            ResultSetImpl rt = (ResultSetImpl) st.executeQuery(sql);
            System.out.println("Id "+"Nombre   "+"   Edad");
            while(rt.next()){
                System.out.print(rt.getInt("id_uno")+ "  ");
                System.out.print(rt.getString("nombre_uno")+ "  ");
                System.out.print(rt.getInt("edad_uno")+ "  ");
                System.out.println();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DabaBaseConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ConectarDB db = new ConectarDB();
        //db.inciarConeccion();
        
        DabaBaseConection pru = new DabaBaseConection();
        //pru.ingreDatosDataBase("maria", 32);
        pru.sacarDatosUno();
    }
}
