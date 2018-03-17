/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Segnalazioni;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public class SegnalazioniDaoImpl implements SegnalazioniDao {
     @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Segnalazioni findByCodice(int codice) {
            return (Segnalazioni) getSession().get(Segnalazioni.class, codice);
       
    }
 
    public void saveSegnalazione(Segnalazioni segnalazione) {
        getSession().persist(segnalazione);
    }
 
    public void deleteSegnalazione(int codice) {
        Segnalazioni s = (Segnalazioni) getSession().load(Segnalazioni.class, codice);
	if(s!=null) getSession().delete(s);
    }
 
    @SuppressWarnings("unchecked")
    public List<Segnalazioni> findAllSegnalazioni() {
       Criteria criteria = getSession().createCriteria(Segnalazioni.class);
        return (List<Segnalazioni>) criteria.list();
    }
 
    
}
