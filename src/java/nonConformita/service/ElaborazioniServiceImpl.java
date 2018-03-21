/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.dao.ElaborazioniDao;
import nonConformita.model.Elaborazioni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Service("elaborazioniService")
@Transactional
public class ElaborazioniServiceImpl implements ElaborazioniService {
    @Autowired
    private ElaborazioniDao dao;
     
    public Elaborazioni findById(int id) {
        return dao.findById(id);
    }
 
    public void saveElaborazione(Elaborazioni elaborazione) {
        dao.saveElaborazione(elaborazione);
    }
 
    public void updateElaborazione(Elaborazioni elaborazione) {
        Elaborazioni entity = dao.findById(elaborazione.getID());
        if(entity!=null){
            entity.setDescrizione(elaborazione.getDescrizione());
            entity.setDataI(elaborazione.getDataI());
            entity.setDataF(elaborazione.getDataF());
            entity.setDipendente(elaborazione.getDipendente());
            entity.setReport(elaborazione.getReport());
        }
    }
 
    public void deleteElaborazione(int id) {
        dao.deleteElaborazione(id);
    }
     
    public List<Elaborazioni> findAllElaborazioni() {
        return dao.findAllElaborazioni();
    }

}
