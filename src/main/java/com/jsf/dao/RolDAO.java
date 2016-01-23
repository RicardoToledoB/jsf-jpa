/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.dao;

import com.jsf.model.Rol;
import com.jsf.model.Usuario;
import java.util.List;

/**
 *
 * @author ricardotoledo
 */
public interface RolDAO {
    public void save(Rol r);
    public List<Rol> list();
    public Rol search(Rol r);
    public void delete(Rol r);
    public void edit(Rol r);
}
