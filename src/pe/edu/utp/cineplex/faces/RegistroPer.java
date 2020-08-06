package pe.edu.utp.cineplex.faces;

import pe.edu.utp.cineplex.business.GestionPersona;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(value = "persona_save", urlPatterns = "/persona")
public class RegistroPer extends HttpServlet {

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

            String DNI = req.getParameter("DNI");
            String nombres = req.getParameter("Nombre");
            String apellidos = req.getParameter("Apellidos");
            String fecha = req.getParameter("Fec_Nac");
            String sexo = req.getParameter("Sexo");
            String estado = req.getParameter("Estado");
            GestionPersona gp = new GestionPersona();
            gp.newPersona(DNI,nombres,apellidos,fecha,sexo,estado);

            req.getRequestDispatcher("listar_persona.xhtml").forward(req,resp);

        }catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
