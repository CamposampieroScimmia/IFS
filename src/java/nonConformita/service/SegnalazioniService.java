/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.model.Segnalazioni;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface SegnalazioniService {
    Segnalazioni findById(int id);
    void saveSegnalazione(Segnalazioni segnalazioni);
    void updateSegnalazione(Segnalazioni segnalazioni);
    void deleteSegnalazione(int id);
    List<Segnalazioni> findAllSegnalazioni(); 
}
