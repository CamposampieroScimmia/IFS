/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Categorie;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public class CategoriaDaoImpl implements CategoriaDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Categorie findByCategoria(String categoria) {
            return (Categorie) getSession().get(Categorie.class, categoria);
       
    }
 
    public void saveCategoria(Categorie categoria) {
        getSession().persist(categoria);
    }
 
    public void deleteCategoria(String categoria) {
        Categorie c = (Categorie) getSession().load(Categorie.class, categoria);
	if(c!=null) getSession().delete(c);
    }
 
    @SuppressWarnings("unchecked")
    public List<Categorie> findAllCategorie() {
       Criteria criteria = getSession().createCriteria(Categorie.class);
        return (List<Categorie>) criteria.list();
    }
 
}
