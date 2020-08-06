package pe.edu.utp.cineplex.faces;

import pe.edu.utp.cineplex.bean.arrendamiento;
import pe.edu.utp.cineplex.bean.persona;
import pe.edu.utp.cineplex.business.GestionArrendar;
import pe.edu.utp.cineplex.business.GestionPersona;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class ListaArrend implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<arrendamiento> List_arrend;

    public ListaArrend() throws SQLException {
        GestionArrendar ga = new GestionArrendar();
        List_arrend = ga.getListaArrend();
    }

    public ArrayList<arrendamiento> getList_arrend() {
        return List_arrend;
    }

    public void setList_arrend(ArrayList<arrendamiento> list_arrend) {
        List_arrend = list_arrend;
    }
}
