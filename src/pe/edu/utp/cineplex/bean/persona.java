package pe.edu.utp.cineplex.bean;
import java.io.Serializable;
import java.util.Date;

public class persona implements Serializable {

    private String DNI;
    private String nombre;
    private String apellidos;
    private Date fecha_nac;
    private String sexo;
    private String estado;


    public persona(String DNI, String nombre, String apellidos, Date fecha_nac, String sexo, String estado) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
        this.estado = estado;
    }

    public persona() {
        DNI="";
        nombre="";
        apellidos="";
        fecha_nac= new Date();
        sexo ="";
        estado ="";
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
}
