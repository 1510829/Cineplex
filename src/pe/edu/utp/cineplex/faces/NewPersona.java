package pe.edu.utp.cineplex.faces;

import pe.edu.utp.cineplex.bean.persona;
import pe.edu.utp.cineplex.business.GestionPersona;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;

@ManagedBean
@SessionScoped
public class NewPersona implements Serializable {

    private String DNI;
    private String nombre;
    private String apellidos;
    private Date fecha_nac;
    private String sexo;
    private String estado;


    public NewPersona(String DNI, String nombre, String apellidos, Date fecha_nac, String sexo, String estado) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
        this.estado = estado;
    }

    public NewPersona() {

    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*public String addPersona() throws SQLException {
        GestionPersona gp = new GestionPersona();
        persona tmp = new persona();
        tmp.setDNI(DNI);
        tmp.setNombre(nombre);
        tmp.setApellidos(apellidos);
        tmp.setFecha_nac(fecha_nac);
        tmp.setSexo(sexo);
        tmp.setEstado("A");
        int np = gp.newPersona(tmp);
        if (np > 0){
            return "success";
        }else{
            return "error";
        }
    }*/
}
