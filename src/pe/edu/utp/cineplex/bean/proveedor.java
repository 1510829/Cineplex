package pe.edu.utp.cineplex.bean;

import java.io.Serializable;

public class proveedor implements Serializable {

    private int id_prov;
    private String ruc;
    private String razon_social;
    private String descripcion;
    private String estado;

    public proveedor(int id_prov, String ruc,String razon_social, String descripcion, String estado) {
        this.id_prov = id_prov;
        this.ruc = ruc;
        this.razon_social = razon_social;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public proveedor() {
        id_prov=0;
        ruc="";
        razon_social="";
        descripcion="";
        estado="";
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

