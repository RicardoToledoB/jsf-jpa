package com.jsf.bean.administrador.pais;

import com.jsf.dao.PaisDAO;
import com.jsf.model.Pais;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
@Named(value = "paisBean")
@SessionScoped
public class PaisBean implements Serializable {
 private List<Pais> listPaises;
    Pais pais = new Pais();
    Pais viewPais = new Pais();
    Pais editPais = new Pais();
    @Inject
    PaisDAO pDAO;

    public PaisBean() {
    }

    public List<Pais> getListPaises() {
        return listPaises = pDAO.list();
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Pais getEditPais() {
        return editPais;
    }

    public String setEditPais(Pais pais) {
        this.editPais = pDAO.search(pais);
        return "edit?faces-redirect=true";
    }

    public Pais getViewPais() {
        return viewPais;
    }

    public String setViewPais(Pais pais) {
        this.viewPais = pDAO.search(pais);
        return "view?faces-redirect=true";
    }

    public void save() {
        pDAO.save(pais);
        pais = new Pais();
    }

    public void delete(Pais pais) {
        pDAO.delete(pais);
    }

    public void edit(Pais pais) {
        pDAO.edit(pais);
        editPais= new Pais();
    }
}
