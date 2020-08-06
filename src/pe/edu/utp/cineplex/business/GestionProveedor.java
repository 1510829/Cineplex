package pe.edu.utp.cineplex.business;

import pe.edu.utp.cineplex.bean.proveedor;
import pe.edu.utp.cineplex.util.DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionProveedor {

    private DataAccess da= new DataAccess();

    public proveedor getProv(Integer id_prov) throws SQLException {
        ResultSet rst;
        proveedor p = new proveedor();
        Connection cnn = da.getConnection();
        String strSQL = "SELECT id_prov,RUC, Razon_social FROM proveedor WHERE id_prov = " + id_prov.toString();
        rst = da.querySQL(cnn, strSQL);

        while (rst.next()) {
            int idp = rst.getInt("id_prov");
            String RUC = rst.getString("RUC");
            String Razon_Social = rst.getString("Razon_social");

            p.setId_prov(idp);
            p.setRazon_social(RUC);
            p.setRazon_social(Razon_Social);

        }
        da.closeConnection(cnn);

        if (p.getId_prov() != 0) {
            return p;
        } else {
            return null;
        }
    }

  /*  public void prueba(Integer id_prov,String Razon_social,String Descripcion,String Estado) throws SQLException {

        String strSQL = "UPDATE proveedor SET Razon_Social ='"+Razon_social+"', Descripcion= '"+Descripcion+"',Estado='"+Estado+"' WHERE id_prov ="+id_prov.toString();
        Connection cnn = da.getConnection();
        Statement st = cnn.createStatement();
        int ne = st.executeUpdate(strSQL);

        da.closeConnection(cnn);

        return getProv(id_prov);
    }*/

    public void updateProveedor(proveedor pro) throws SQLException {

        String strSQL = "UPDATE proveedor SET Razon_Social ='"+pro.getRazon_social()+"', Descripcion= '"+pro.getDescripcion()+"',Estado='"+pro.getEstado()+"' WHERE id_prov ="+pro.getId_prov();
        Connection cnn = da.getConnection();
        Statement st = cnn.createStatement();
        int ne = st.executeUpdate(strSQL);

        da.closeConnection(cnn);
    }


    public void newProveedor(String RUC,String Razon_social, String Descripcion, String Estado) throws SQLException {

        String strSQL = "INSERT INTO proveedor(RUC,Razon_social,Descripcion,Estado) VALUES ('"+ RUC+"','"+ Razon_social+"','" + Descripcion + "','" + Estado + "')";

        Connection cnn = da.getConnection();

        Statement st = cnn.createStatement();
        int ne = st.executeUpdate(strSQL);

        da.closeConnection(cnn);   // CRITICO !!!
    }

    public ArrayList<proveedor> getListaProveedor() throws SQLException {
        ResultSet rst;
        ArrayList<proveedor>resultado = new ArrayList<proveedor>();
        String strSQL = "SELECT id_prov, RUC, Razon_social, Descripcion, Estado FROM proveedor";
        Connection cnn = da.getConnection();
        rst = da.querySQL(cnn,strSQL);
        while (rst.next()) {
            int id = rst.getInt("id_prov");
            String ruc = rst.getString("RUC");
            String rsocial = rst.getString("Razon_social");
            String descripcion = rst.getString("Descripcion");
            String estado = rst.getString("Estado");
            proveedor tmp = new proveedor(id, ruc, rsocial, descripcion, estado);
            resultado.add(tmp);
            }
            da.closeConnection(cnn);
            return resultado;
    }

}
