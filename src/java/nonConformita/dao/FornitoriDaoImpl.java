/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Fornitori;
import nonConformita.model.Fornitori;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public class FornitoriDaoImpl implements FornitoriDao{
     @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Fornitori findByPiva(String piva) {
            return (Fornitori) getSession().get(Fornitori.class, piva);
       
    }
 
    public void saveFornitore(Fornitori fornitore) {
        getSession().persist(fornitore);
    }
 
    public void deleteFornitore(String piva) {
        Fornitori f = (Fornitori) getSession().load(Fornitori.class, piva);
	if(f!=null) getSession().delete(f);
    }
 
    @SuppressWarnings("unchecked")
    public List<Fornitori> findAllFornitori() {
       Criteria criteria = getSession().createCriteria(Fornitori.class);
        return (List<Fornitori>) criteria.list();
    }
 
}
