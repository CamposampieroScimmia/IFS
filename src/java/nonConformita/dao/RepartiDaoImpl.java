/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Reparti;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public class RepartiDaoImpl implements RepartiDao {
     @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Reparti findByNome(String nome) {
            return (Reparti) getSession().get(Reparti.class, nome);
       
    }
 
    public void saveReparto(Reparti reparto) {
        getSession().persist(reparto);
    }
 
    public void deleteReparto(String nome) {
        Reparti r = (Reparti) getSession().load(Reparti.class, nome);
	if(r!=null) getSession().delete(r);
    }
 
    @SuppressWarnings("unchecked")
    public List<Reparti> findAllReparti() {
       Criteria criteria = getSession().createCriteria(Reparti.class);
        return (List<Reparti>) criteria.list();
    }
 
}
