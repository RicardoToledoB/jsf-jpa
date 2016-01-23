package com.jsf.bean.administrador.rol;

import com.jsf.dao.RolDAO;
import com.jsf.model.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

@Named(value = "rolBean")
@SessionScoped
public class RolBean implements Serializable {

    private List<Rol> listRols;
    Rol rol = new Rol();
    Rol viewRol = new Rol();
    Rol editRol = new Rol();
    @Inject
    RolDAO rDAO;

    public RolBean() {
    }

    public List<Rol> getListRols() {
        return listRols = rDAO.list();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rol getEditRol() {
        return editRol;
    }

    public String setEditRol(Rol rol) {
        this.editRol = rDAO.search(rol);
        return "edit?faces-redirect=true";
    }

    public Rol getViewRol() {
        return viewRol;
    }

    public String setViewRol(Rol rol) {
        this.viewRol = rDAO.search(rol);
        return "view?faces-redirect=true";
    }

    public void save() {
        rDAO.save(rol);
        rol = new Rol();
    }

    public void delete(Rol r) {
        rDAO.delete(r);
    }

    public void edit(Rol r) {
        rDAO.edit(r);
        editRol = new Rol();
    }

}
