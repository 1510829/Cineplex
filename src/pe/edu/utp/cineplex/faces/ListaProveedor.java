package pe.edu.utp.cineplex.faces;

import pe.edu.utp.cineplex.bean.proveedor;
import pe.edu.utp.cineplex.business.GestionProveedor;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class ListaProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<proveedor> List_proveedor;

    public ListaProveedor() throws SQLException {
        GestionProveedor gp = new GestionProveedor();
        List_proveedor = gp.getListaProveedor();

    }

    public ArrayList<proveedor> getList_proveedor() {

        return List_proveedor;
    }

    public void setList_proveedor(ArrayList<proveedor> list_proveedor) {

        this.List_proveedor = list_proveedor;
    }

    public void updateProv(proveedor p) throws SQLException{
        GestionProveedor gp = new GestionProveedor();
        gp.updateProveedor(p);
    }
    public void deleteProv(proveedor p) throws SQLException{
        GestionProveedor gp = new GestionProveedor();
        gp.updateProveedor(p);
    }

}
