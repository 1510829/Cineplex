package pe.edu.utp.cineplex.business;

import pe.edu.utp.cineplex.bean.persona;
import pe.edu.utp.cineplex.bean.proveedor;
import pe.edu.utp.cineplex.util.DataAccess;

import javax.print.DocFlavor;
import java.util.Date;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionPersona {

    private DataAccess da = new DataAccess();

    public void newPersona(String DNI, String nombre, String apellidos, String fecha, String sexo, String estado) throws SQLException, SQLException {

        String strSQL = "INSERT INTO persona(DNI,Nombre,Apellidos,Fec_Nac,Sexo,Estado) VALUES('"+ DNI+"','"+ nombre+"','" + apellidos + "','" + fecha + "','"+sexo+"','"+estado+"')";

        Connection cnn = da.getConnection();
        Statement st = cnn.createStatement();
        int ne = st.executeUpdate(strSQL);

        da.closeConnection(cnn);
    }

    public void updatePersona(persona per) throws SQLException {

        String strSQL = "UPDATE persona SET Nombre ='"+per.getNombre()+"', Apellidos= '"+per.getApellidos()+"',Fec_Nac= '"+per.getFecha_nac()+"',Sexo= '"+per.getSexo()+"',Estado='"+per.getEstado()+"' WHERE DNI ="+per.getDNI();
        Connection cnn = da.getConnection();
        Statement st = cnn.createStatement();
        int ne = st.executeUpdate(strSQL);

        da.closeConnection(cnn);
    }


    public ArrayList<persona> getListaPersona() throws SQLException {
        ResultSet rst;
        ArrayList<persona>resultado = new ArrayList<persona>();
        String strSQL = "SELECT DNI, Nombre, Apellidos, Fec_Nac, Sexo, Estado FROM persona";
        Connection cnn = da.getConnection();
        rst = da.querySQL(cnn,strSQL);
        while (rst.next()) {
            String  id_per = rst.getString("DNI");
            String nombre = rst.getString("Nombre");
            String apellidos = rst.getString("Apellidos");
            Date fecha = rst.getDate("Fec_Nac");
            String sexo = rst.getString("Sexo");
            String estado = rst.getString("Estado");
            persona tmp = new persona(id_per, nombre, apellidos, fecha, sexo, estado);
            resultado.add(tmp);
        }
        da.closeConnection(cnn);
        return resultado;
    }

}
