package pe.edu.utp.cineplex.faces;

import pe.edu.utp.cineplex.business.GestionArrendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "Registro_Arrend", urlPatterns = "/new_arred")
public class RegistroArrend extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            procesar(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            procesar(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void procesar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        try {

            String id_a = req.getParameter("id_arrend");
            String descripcion = req.getParameter("Descripcion");
            String fi = req.getParameter("fecha_ingreso");
            String fv = req.getParameter("Fecha_Venci");
            String estado = req.getParameter("Estado");
            String id_prov = req.getParameter("Id_prov");
            GestionArrendar ga = new GestionArrendar();
            ga.newArrend(id_a,descripcion,fi,fv,estado,id_prov);

            req.getRequestDispatcher("listar_arrend.xhtml").forward(req,resp);

        }catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
