/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Pezzi;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Repository("pezziDao")
public class PezziDaoImpl implements PezziDao{
     @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Pezzi findByCodice(int codice) {
            return (Pezzi) getSession().get(Pezzi.class, codice);
       
    }
 
    public void savePezzo(Pezzi pezzo) {
        getSession().persist(pezzo);
    }
 
    public void deletePezzo(int codice) {
        Pezzi p = (Pezzi) getSession().load(Pezzi.class, codice);
	if(p!=null) getSession().delete(p);
    }
 
    @SuppressWarnings("unchecked")
    public List<Pezzi> findAllPezzi() {
       Criteria criteria = getSession().createCriteria(Pezzi.class);
        return (List<Pezzi>) criteria.list();
    }
 
}
