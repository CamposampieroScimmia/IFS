/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.dao.RepartiDao;
import nonConformita.model.Reparti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Service("repartiService")
@Transactional
public class RepartiServiceImpl implements RepartiService {
        @Autowired
    private RepartiDao dao;
     
    public Reparti findByNome(String nome) {
        return dao.findByNome(nome);
    }
 
    public void saveReparto(Reparti reparto) {
        dao.saveReparto(reparto);
    }
 
    public void updateReparto(Reparti reparto) {
        Reparti entity = dao.findByNome(reparto.getNome());
        if(entity!=null){
            entity.setDipendenti(reparto.getDipendenti());
            entity.setReport(reparto.getReport());
        }
    }
 
    public void deleteReparto(String nome) {
        dao.deleteReparto(nome);
    }
     
    public List<Reparti> findAllReparti() {
        return dao.findAllReparti();
    }

}
