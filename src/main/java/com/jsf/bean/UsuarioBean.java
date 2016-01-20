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
    Usuario user=new Usuario();
    Usuario selectedUser=new Usuario();
    @Inject
    UsuarioDAO uDAO;
    public UsuarioBean() {
    }
    public List<Usuario> getListUsers() {
        return listUsers=uDAO.list();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Usuario getSelectedUser() {
        return selectedUser;
    }

    public String setSelectedUser(Usuario selectedUser) {
        this.selectedUser = uDAO.search(selectedUser);
        return "edit?faces-redirect=true";
        
    }
    
    
    public void save(){
        uDAO.save(user);
       user=new Usuario();
    }
    public void delete(Usuario u){
        uDAO.delete(u);
    }
    public void edit(Usuario u){
        uDAO.edit(u);
    }
    
    
}
