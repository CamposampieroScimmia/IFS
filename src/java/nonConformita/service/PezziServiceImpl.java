/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.dao.PezziDao;
import nonConformita.model.Pezzi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Service("pezziService")
@Transactional
public class PezziServiceImpl implements PezziService {
    @Autowired
    private PezziDao dao;
     
    public Pezzi findById(int id) {
        return dao.findByCodice(id);
    }
 
    public void savePezzo(Pezzi pezzo) {
        dao.savePezzo(pezzo);
    }
 
    public void updatePezzo(Pezzi pezzo) {
        Pezzi entity = dao.findByCodice(pezzo.getCodice());
        if(entity!=null){
            entity.setCategoria(pezzo.getCategoria());
            entity.setReport(pezzo.getReport());
        }
    }
 
    public void deletePezzo(int id) {
        dao.deletePezzo(id);
    }
     
    public List<Pezzi> findAllPezzi() {
        return dao.findAllPezzi();
    }

}
