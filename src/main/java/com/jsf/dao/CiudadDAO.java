/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.dao;

import com.jsf.model.Ciudad;
import com.jsf.model.Usuario;
import java.util.List;

/**
 *
 * @author ricardotoledo
 */
public interface CiudadDAO {
    public void save(Ciudad c);
    public List<Ciudad> list();
    public Ciudad search(Ciudad c);
    public void delete(Ciudad c);
    public void edit(Ciudad c);
}
