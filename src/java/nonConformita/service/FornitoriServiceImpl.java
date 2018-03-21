/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.dao.FornitoriDao;
import nonConformita.model.Fornitori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Service("fornitoriService")
@Transactional
public class FornitoriServiceImpl implements FornitoriService {
   @Autowired
    private FornitoriDao dao;
     
    public Fornitori findByPiva(String piva) {
        return dao.findByPiva(piva);
    }
 
    public void saveFornitore(Fornitori fornitore) {
        dao.saveFornitore(fornitore);
    }
 
    public void updateFornitore(Fornitori fornitore) {
        Fornitori entity = dao.findByPiva(fornitore.getPiva());
        if(entity!=null){
            entity.setNomeFornitore(fornitore.getNomeFornitore());
            entity.setReport(fornitore.getReport());
        }
    }
 
    public void deleteFornitore(String piva) {
        dao.deleteFornitore(piva);
    }
     
    public List<Fornitori> findAllFornitori() {
        return dao.findAllFornitori();
    }

}
