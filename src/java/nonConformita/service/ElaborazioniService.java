/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.model.Elaborazioni;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface ElaborazioniService {
    Elaborazioni findById(int id);
    void saveElaborazione(Elaborazioni elaborazione);
    void updateElaborazione(Elaborazioni elaborazione);
    void deleteElaborazione(int id);
    List<Elaborazioni> findAllElaborazioni(); 
}
