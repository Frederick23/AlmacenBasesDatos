
/**
 * Clase basica que gestiona una conexion JDBC a MySQL ModeloDB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Iterator;
import java.util.ArrayList;
import java.sql.*;



public class ModeloDB extends ModeloAbs
{
    // instance variables - replace the example below with your own
   static final String DATABASE USTATIC FINAL String DATABASE_URL = "jdbc:mysql://localhost/productosdb";
   static final String USER = "alumno";
   static final String PASSWORD = "alumno";

    public Connection con = null;
    public Statement st = null;
    public ResulSet rs = null;  
    /**
     * Constructor for objects of class ModeloDB
     * Establece la conexion a la base de datos
     */
    public ModeloDB()
    {
        try{
            con = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            st = con.createStatement();

        }catch (SQLException e){
            System.out.println("Error al conectarse");
            sql.printStackTrace();
        }
    }

    // INSERT
    public boolean insertarProducto ( Producto p){
        try{

            st.executeUpdate("INSERT INTO productos values("+p.getCodigo()+","+"p.getNombre()"+","+p.getStock()+","+p.getStock_min()+","+p.getPrecio()+")");
            return true;

        }catch(SQLException e){
            sql.printStackTrace();
        }

    return false; 
    }
    
    
    // DELETE
    boolean borrarProducto ( int codigo ){
        try{
            st.executeUpdate("DELETE from productos where codigo = "+codigo);
            return true;
        }catch(SQLException e){
            sql.printStackTrace();
        }
    return false;    
    }
    
    // SELECT
    public Producto buscarProducto ( int codigo){
        Producto aux = null;

        try{

            rs = st.executeQuery("select * from productos where codigo  ="+c);
            rs.next();
            aux = new Producto(rs.getInt(1),rs.getString(2));
            aux.setStock(rs.getInt(3));
            aux.setStock_min(rs.getInt(4));
            aux.setPrecio(rs.getFloat(5));


        }catch(SQLException e){
            sql.printStackTrace();
        }

    return aux;    
    }
    
    
    //SELECT
    void listarProductos (){
        try{

            rs = st.executeQuery("select codigo, nombre, precio from productos");
            while(rs.next()){
                System.out.printf("Codigo %d Nombre %s Precio %f",rs.getInt(1),rs.getString(2),rs.getFloat(3));
                System.out.println(" ");
            }


        }catch(SQLException e){
            sql.printStackTrace();
        }
    }
    
    //UPDATE
    boolean modificarProducto (Producto nuevo){
        try{
            st.executeUpdate("UPDATE PRODUCTOS set stock = "+nuevo.getStock()+" set stock_min = "+nuevo.getStock_min()+ "set precio = "+nuevo.getPrecio() + " where codigo = " +nuevo.getCodigo());
            return true;
        }catch(SQLException e){
            sql.printStackTrace();
        }
    return false;    
    }
    
    // Devuelvo un Iterador de una ArrayList con los resultados
    // copiados de Rset al ArrayList
     Iterator <Producto> getIterator(){
       ArrayList <Producto> lista = new ArrayList<Producto>();
       // Relleno el array list con los resultados de al consulta
       try{
            rs = st.executeQuery("SELECT * from productos");
            Producto aux = new Producto(rs.getInt(1),rs.getString(2));
            aux.setStock(rs.getInt(3));
            aux.setStock_min(rs.getInt(4));
            aux.setPrecio(rs.getFloat(5));
            lista.insertarProducto(aux);


       }catch(SQLException e){
            sql.printStackTrace();
       }
       
       return lista.iterator();
     }
}
