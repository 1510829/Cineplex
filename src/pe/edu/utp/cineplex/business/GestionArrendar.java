package pe.edu.utp.cineplex.business;

import pe.edu.utp.cineplex.bean.arrendamiento;
import pe.edu.utp.cineplex.bean.persona;
import pe.edu.utp.cineplex.util.DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class GestionArrendar {

    private DataAccess da = new DataAccess();

    public void newArrend(String id_a, String descripcion, String fi, String fv, String estado, String id_prov) throws SQLException, SQLException {

        String strSQL = "INSERT INTO arrendamiento(id_arrend,descripcion,fecha_ingreso,Fec_venc,Estado,id_prov) VALUES('"+ id_a+"','"+ descripcion+"','" + fi + "','" + fv + "','"+estado+"','"+id_prov+"')";

        Connection cnn = da.getConnection();
        Statement st = cnn.createStatement();
        int ne = st.executeUpdate(strSQL);

        da.closeConnection(cnn);
    }

    public ArrayList<arrendamiento> getListaArrend() throws SQLException {
        ResultSet rst;
        ArrayList<arrendamiento>resultado = new ArrayList<arrendamiento>();
        String strSQL = "SELECT id_arrend, Descripcion, fecha_ingreso, Fecha_venci, Estado, id_prov FROM arrendamiento";
        Connection cnn = da.getConnection();
        rst = da.querySQL(cnn,strSQL);
        while (rst.next()) {
            String  id_a = rst.getString("id_arrend");
            String descripcion = rst.getString("Descripcion");
            Date fi = rst.getDate("fecha_ingreso");
            Date fv = rst.getDate("Fecha_Venci");
            String estado = rst.getString("Estado");
            String id_prov = rst.getString("id_prov");
            arrendamiento tmp = new arrendamiento(id_a, descripcion, fi, fv, estado, id_prov);
            resultado.add(tmp);
        }
        da.closeConnection(cnn);

        return resultado;
    }

}

