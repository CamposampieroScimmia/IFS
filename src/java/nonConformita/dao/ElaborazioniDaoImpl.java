/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Elaborazioni;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public class ElaborazioniDaoImpl implements ElaborazioniDao {
     @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Elaborazioni findById(int id) {
            return (Elaborazioni) getSession().get(Elaborazioni.class, id);
       
    }
 
    public void saveElaborazione(Elaborazioni elaborazione) {
        getSession().persist(elaborazione);
    }
 
    public void deleteElaborazione(int id) {
        Elaborazioni e = (Elaborazioni) getSession().load(Elaborazioni.class, id);
	if(e!=null) getSession().delete(e);
    }
 
    @SuppressWarnings("unchecked")
    public List<Elaborazioni> findAllElaborazioni() {
       Criteria criteria = getSession().createCriteria(Elaborazioni.class);
        return (List<Elaborazioni>) criteria.list();
    }
 
}
