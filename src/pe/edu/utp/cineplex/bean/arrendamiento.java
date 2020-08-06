package pe.edu.utp.cineplex.bean;

import java.util.Date;

public class arrendamiento {

    private String id_arrend;
    private String descripcion;
    private Date fecha_ing;
    private Date fecha_venc;
    private String estado;
    private String id_prov;


    public arrendamiento(String id_arrend, String descripcion, Date fecha_ing, Date feca_venc, String estado, String id_prov) {
        this.id_arrend = id_arrend;
        this.descripcion = descripcion;
        this.fecha_ing = fecha_ing;
        this.fecha_venc = fecha_venc;
        this.estado = estado;
        this.id_prov = id_prov;
    }


    public arrendamiento() {
        id_arrend="";
        descripcion="";
        fecha_ing= new Date();
        fecha_venc=  new Date();
        estado="";
        id_prov="";
    }


    public String getId_arrend() {
        return id_arrend;
    }

    public void setId_arrend(String id_arrend) {
        this.id_arrend = id_arrend;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_ing() {
        return fecha_ing;
    }

    public void setFecha_ing(Date fecha_ing) {
        this.fecha_ing = fecha_ing;
    }

    public Date getFecha_venc() {
        return fecha_venc;
    }

    public void setFecha_venc(Date fecha_venc) {
        this.fecha_venc = fecha_venc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_prov() {
        return id_prov;
    }

    public void setId_prov(String id_prov) {
        this.id_prov = id_prov;
    }
}
