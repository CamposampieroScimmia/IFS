/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Clienti;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Repository("clienteDao")
public class ClienteDaoImpl implements ClienteDao{
     @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Clienti findByPiva(String piva) {
            return (Clienti) getSession().get(Clienti.class, piva);
       
    }
 
    public void saveCliente(Clienti cliente) {
        getSession().persist(cliente);
    }
 
    public void deleteCliente(String piva) {
        Clienti c = (Clienti) getSession().load(Clienti.class, piva);
	if(c!=null) getSession().delete(c);
    }
 
    @SuppressWarnings("unchecked")
    public List<Clienti> findAllClienti() {
       Criteria criteria = getSession().createCriteria(Clienti.class);
        return (List<Clienti>) criteria.list();
    }
 
}
