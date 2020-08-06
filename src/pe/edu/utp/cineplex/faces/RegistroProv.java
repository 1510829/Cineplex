package pe.edu.utp.cineplex.faces;

import pe.edu.utp.cineplex.business.GestionProveedor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "proveedor_save", urlPatterns = "/proveedor")
public class RegistroProv extends HttpServlet {

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
            //Integer pid = Integer.parseInt(req.getParameter("pid"));
            String RUC = req.getParameter("RUC");
            String Razon_social = req.getParameter("Razon_social");
            String Descripcion = req.getParameter("Descripcion");
            String Estado = req.getParameter("Estado");

            GestionProveedor ato = new GestionProveedor();
            ato.newProveedor(RUC,Razon_social,Descripcion,Estado);

           req.getRequestDispatcher("listar_proveedor.xhtml").forward(req,resp);

        }catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
