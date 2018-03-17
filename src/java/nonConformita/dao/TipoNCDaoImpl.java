/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.TipoNC;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public class TipoNCDaoImpl implements TipoNCDao {
     @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public TipoNC findByNome(String nome) {
            return (TipoNC) getSession().get(TipoNC.class, nome);
       
    }
 
    public void saveTipoNC(TipoNC tipoNC) {
        getSession().persist(tipoNC);
    }
 
    public void deleteTipoNC(String nome) {
        TipoNC c = (TipoNC) getSession().load(TipoNC.class, nome);
	if(c!=null) getSession().delete(c);
    }
 
    @SuppressWarnings("unchecked")
    public List<TipoNC> findAllTipoNC() {
       Criteria criteria = getSession().createCriteria(TipoNC.class);
        return (List<TipoNC>) criteria.list();
    }
 
}
