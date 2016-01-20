package com.jsf.bean;
import com.jsf.dao.UsuarioDAO;
import com.jsf.model.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {
    private List<Usuario> listUsers;
    @Inject
    UsuarioDAO uDAO;
    public UsuarioBean() {
    }
    public List<Usuario> getListUsers() {
        return listUsers=uDAO.list();
    }

    
}
