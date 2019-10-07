
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Usuario;



public class UsuarioDAO {

    Conexion con;

    public UsuarioDAO() {
        this.con = new Conexion();
    }

//Buscar a alguien por variable
    public Usuario getEmpleado(String Nombre) {
        Connection accesoBD = con.getConexion();
        Usuario em = null;

        try {
            String sql = "SELECT * FROM usuario WHERE nombre ='" + Nombre + "'";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) {
                int id_usuario = resultados.getInt("id_usuario");
                String nombre = resultados.getString("nombre");
               
                
                em = new Usuario(id_usuario, nombre);
            }

            return em;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
    }

     public ArrayList<Usuario> getUsuarios(){
        
        ArrayList<Usuario> usuariosBD = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM usuario ";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int id_usuario=resultados.getInt("id_usuario");
                String nombre=resultados.getString("nombre");
               
                usuariosBD.add(new Usuario(id_usuario, nombre));
            }
            return usuariosBD;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
    }

}
