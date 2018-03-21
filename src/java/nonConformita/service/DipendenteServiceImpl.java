/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.dao.DipendenteDao;
import nonConformita.model.Dipendenti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Service("dipendenteService")
@Transactional
public class DipendenteServiceImpl implements DipendenteService {
@Autowired
    private DipendenteDao dao;
     
    public Dipendenti findByMatricola(String matricola) {
        return dao.findByMatricola(matricola);
    }
 
    public void saveDipendente(Dipendenti dipendente) {
        dao.saveDipendente(dipendente);
    }
 
    public void updateDipendente(Dipendenti dipendente) {
        Dipendenti entity = dao.findByMatricola(dipendente.getMatricola());
        if(entity!=null){
            entity.setPassword(dipendente.getPassword());
            entity.setNome(dipendente.getNome());
            entity.setCognome(dipendente.getCognome());
            entity.setRuolo(dipendente.getRuolo());
        }
    }
 
    public void deleteDipendente(String nome) {
        dao.deleteDipendente(nome);
    }
     
    public List<Dipendenti> findAllDipendenti() {
        return dao.findAllDipendenti();
    }

}
