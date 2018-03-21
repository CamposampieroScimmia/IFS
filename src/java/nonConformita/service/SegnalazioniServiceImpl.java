/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.dao.SegnalazioniDao;
import nonConformita.model.Segnalazioni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Service("segnalazioniService")
@Transactional
public class SegnalazioniServiceImpl implements SegnalazioniService {
    @Autowired
    private SegnalazioniDao dao;
     
    public Segnalazioni findById(int id) {
        return dao.findByCodice(id);
    }
 
    public void saveSegnalazione(Segnalazioni segnalazione) {
        dao.saveSegnalazione(segnalazione);
    }
 
    public void updateSegnalazione(Segnalazioni segnalazione) {
        Segnalazioni entity = dao.findByCodice(segnalazione.getCodice());
        if(entity!=null){
            entity.setDescrizione(segnalazione.getDescrizione());
            entity.setData(segnalazione.getData());
            entity.setDipendente(segnalazione.getDipendente());
        }
    }
 
    public void deleteSegnalazione(int id) {
        dao.deleteSegnalazione(id);
    }
     
    public List<Segnalazioni> findAllSegnalazioni() {
        return dao.findAllSegnalazioni();
    }
}
