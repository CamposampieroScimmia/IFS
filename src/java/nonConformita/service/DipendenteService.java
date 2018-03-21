/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.model.Dipendenti;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface DipendenteService {
    Dipendenti findByMatricola(String matricola);
    void saveDipendente(Dipendenti dipendente);
    void updateDipendente(Dipendenti dipendente);
    void deleteDipendente(String matricola);
    List<Dipendenti> findAllDipendenti(); 
}
