/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Report;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public class ReportDaoImpl implements ReportDao {
     @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Report findByCodiceNC(int codiceNC) {
            return (Report) getSession().get(Report.class, codiceNC);
       
    }
 
    public void saveReport(Report report) {
        getSession().persist(report);
    }
 
    public void deleteReport(int codiceNC) {
        Report r = (Report) getSession().load(Report.class, codiceNC);
	if(r!=null) getSession().delete(r);
    }
 
    @SuppressWarnings("unchecked")
    public List<Report> findAllReports() {
       Criteria criteria = getSession().createCriteria(Report.class);
        return (List<Report>) criteria.list();
    }
 
}
