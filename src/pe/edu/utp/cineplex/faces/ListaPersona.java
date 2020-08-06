package pe.edu.utp.cineplex.faces;

import pe.edu.utp.cineplex.bean.persona;
import pe.edu.utp.cineplex.bean.proveedor;
import pe.edu.utp.cineplex.business.GestionPersona;
import pe.edu.utp.cineplex.business.GestionProveedor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class ListaPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<persona> List_persona;

    public ListaPersona() throws SQLException {
        GestionPersona gp = new GestionPersona();
        List_persona = gp.getListaPersona();
    }

    public ArrayList<persona> getList_persona() {
        return List_persona;
    }

    public void setList_persona(ArrayList<persona> list_persona) {
        List_persona = list_persona;
    }

    public void updatePersona(persona per) throws SQLException{
        GestionPersona gp = new GestionPersona();
        gp.updatePersona(per);
    }
    public void deletePersona(persona per) throws SQLException{
        GestionPersona gp = new GestionPersona();
        gp.updatePersona(per);
    }

}
