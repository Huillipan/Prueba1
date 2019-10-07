
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.NuevoMensaje;


public class Controlador implements ActionListener{
      public UsuarioDAO ed = new UsuarioDAO();
public ArrayList<Usuario> listaUsuarios = ed.getUsuarios();
    @Override
    public void actionPerformed(ActionEvent ae) {
        
            if(ae.getActionCommand().equals("nuevoMensaje")){    
               
                 NuevoMensaje b= new NuevoMensaje();
                b.setVisible(true);
            }
    }
    
}
