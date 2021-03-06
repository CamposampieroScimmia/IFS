    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nonConformita.dao.CategoriaDao;
import nonConformita.dao.DipendenteDao;
import nonConformita.model.Categorie;
import nonConformita.model.Dipendenti;
import nonConformita.model.Ruolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Service("categoriaService")
@Transactional
public class CategoriaServiceImpl implements CategoriaService  {
    @Autowired
    private CategoriaDao dao;
    private DipendenteDao dip;
     
    public Categorie findByCategoria(String nome) {
        return dao.findByCategoria(nome);
    }
 
    public void saveCategoria(Categorie categoria) {
        dao.saveCategoria(categoria);
    }
 
    public void updateCategoria(Categorie categoria) {
        Categorie entity = dao.findByCategoria(categoria.getCategoria());
        if(entity!=null){
            entity.setNote(categoria.getNote());
            entity.setPezzi(categoria.getPezzi());
        }
    }
 
    public void deleteCategoria(String nome) {
        dao.deleteCategoria(nome);
    }
     
    public List<Categorie> findAllCategorie() {
        return dao.findAllCategorie();
    }

}
