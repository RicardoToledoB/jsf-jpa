package com.jsf.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apepat")
    private String apepat;
    @Column(name="apemat")
    private String apemat;
    @Column(name="username")
    private String username;
    @Column(name="fec_nac")
    @Temporal(TemporalType.DATE)
    private Date fec_nac;
    
    @Column(name="password")
    private String password;
    @Column(name="estado")
    private String estado;
    @ManyToOne
    @JoinColumn(name="ciudad_id")
    private Ciudad ciudad;
    @ManyToOne
    @JoinColumn(name="rol_id")
    private Rol rol;
    
    public Usuario() {
        rol=new Rol();
        ciudad=new Ciudad();
    }

    public Usuario(int id, String nombre, String apepat, String apemat,String username,String password,String estado,Date fec_nac) {
        this.id = id;
        this.nombre = nombre;
        this.apepat = apepat;
        this.apemat = apemat;
        this.username=username;
        this.password=password;
        this.estado=estado;
        this.fec_nac=fec_nac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
        ciudad.getUsuario().add(this);
    }

    public Rol getRol() {
        return rol;
        
    }

    public void setRol(Rol rol) {
        this.rol = rol;
        rol.getUsuario().add(this);
    }

    public Date getFec_nac() {
        return fec_nac;
    }

    public void setFec_nac(Date fec_nac) {
        this.fec_nac = fec_nac;
    }
    
    
    
}
