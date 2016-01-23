package com.jsf.bean.administrador.ciudad;
import com.jsf.dao.CiudadDAO;
import com.jsf.model.Ciudad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
@Named(value = "ciudadBean")
@SessionScoped
public class CiudadBean implements Serializable {

    private List<Ciudad> listCiudades;
    Ciudad ciudad = new Ciudad();
    Ciudad viewCiudad = new Ciudad();
    Ciudad editCiudad = new Ciudad();
    @Inject
    CiudadDAO cDAO;

    public CiudadBean() {
    }

    public List<Ciudad> getListCiudades() {
        return listCiudades = cDAO.list();
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getEditCiudad() {
        return editCiudad;
    }

    public String setEditCiudad(Ciudad ciudad) {
        this.editCiudad = cDAO.search(ciudad);
        return "edit?faces-redirect=true";
    }

    public Ciudad getViewCiudad() {
        return viewCiudad;
    }

    public String setViewCiudad(Ciudad ciudad) {
        this.viewCiudad = cDAO.search(ciudad);
        return "view?faces-redirect=true";
    }

    public void save() {
        cDAO.save(ciudad);
        ciudad = new Ciudad();
    }

    public void delete(Ciudad ciudad) {
        cDAO.delete(ciudad);
    }

    public void edit(Ciudad ciudad) {
        cDAO.edit(ciudad);
        editCiudad = new Ciudad();
    }
}
