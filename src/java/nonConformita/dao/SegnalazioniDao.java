/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Segnalazioni;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface SegnalazioniDao {
    Segnalazioni findByCodice(int codice);
    void saveSegnalazione(Segnalazioni cliente);
    void deleteSegnalazione(int codice);
    List<Segnalazioni> findAllSegnalazioni();
}
