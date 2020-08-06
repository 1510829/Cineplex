package pe.edu.utp.cineplex.faces;

import pe.edu.utp.cineplex.bean.proveedor;
import pe.edu.utp.cineplex.business.GestionArrendar;
import pe.edu.utp.cineplex.business.GestionProveedor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "Reg_arrend", urlPatterns = "/new_arrend")
public class Reg_arrend extends HttpServlet {

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

        Integer pid= Integer.parseInt(req.getParameter("pid"));
    }

    private void procesar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        Integer pid = Integer.parseInt(req.getParameter("pid"));

        GestionProveedor gp = new GestionProveedor();
        proveedor prov = gp.getProv(pid);

        req.setAttribute("p",prov);
        req.getRequestDispatcher("new_arred.jsp").forward(req,resp);
    }

}
