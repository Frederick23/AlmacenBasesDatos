
/**
 * Implementa la parte de Modelo de Datow
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ModeloArrayList extends ModeloAbs{
    public ArrayList <Producto> lista;
    
    public ModeloArrayList()
    {
       lista=new ArrayList <Producto>();
    }

    public boolean insertarProducto ( Producto p){
      assert ( p != null ); // No permito productos nulos  
      return lista.add(p);     
    }
 
    public boolean borrarProducto ( int codigo ){
      Producto p = buscarProducto (codigo);
      if ( p != null ){
          // Remove null 
          return lista.remove(p);
        }
      return false;
    }
    
    public Producto buscarProducto ( int codigo) {
       for ( Producto p: lista ){
           if ( p.getCodigo() == codigo ){
               return p;
            }
        }
        return null;
    }
    
    public void listarProductos (){
        int i = 1;
        for ( Producto p: lista){
            System.out.println(" Nº "+i+" "+p);
            i++;
        }
    }
    
    public boolean modificarProducto (Producto nuevo){
       Producto p;
       int i =   lista.indexOf(nuevo);
       // Si no esta devuelvo false
       return ( i != -1);
    }
    
    public Iterator <Producto> getIterator(){
        return lista.iterator();   
    }   
} 