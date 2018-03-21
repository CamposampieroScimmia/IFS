/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Dipendenti;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Repository("dipendenteDao")
public class DipendenteDaoImpl implements DipendenteDao{
     @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Dipendenti findByMatricola(String matricola) {
            return (Dipendenti) getSession().get(Dipendenti.class, matricola);
       
    }
 
    public void saveDipendente(Dipendenti dipendente) {
        getSession().persist(dipendente);
    }
 
    public void deleteDipendente(String matricola) {
        Dipendenti d = (Dipendenti) getSession().load(Dipendenti.class, matricola);
	if(d!=null) getSession().delete(d);
    }
 
    @SuppressWarnings("unchecked")
    public List<Dipendenti> findAllDipendenti() {
       Criteria criteria = getSession().createCriteria(Dipendenti.class);
        return (List<Dipendenti>) criteria.list();
    }
 
}
