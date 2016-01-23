/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.dao;

import com.jsf.model.Pais;
import java.util.List;

/**
 *
 * @author ricardotoledo
 */
public interface PaisDAO {
       public void save(Pais p);
    public List<Pais> list();
    public Pais search(Pais p);
    public void delete(Pais p);
    public void edit(Pais p);
}
