package pe.edu.utp.cineplex.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccess {

    public Connection getConnection() throws SQLException{
        Connection conn = null;
        try {
            // Crear la conexion
            // OJO: PARA JBOSS LA CONEXION ES JAVA:/ Y NO JDBC/
            conn = ((DataSource) InitialContext.doLookup("java:/CineplexDS")).getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet querySQL(Connection conn, String sql) throws SQLException {

        try{
            ResultSet rst = conn.createStatement().executeQuery(sql);
            return rst;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null){
            conn.close();
        }
    }

}