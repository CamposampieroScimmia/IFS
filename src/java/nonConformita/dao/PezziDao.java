/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;
import java.util.List;
import nonConformita.model.Pezzi;

import java.util.List;
import nonConformita.model.Pezzi;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface PezziDao {
    Pezzi findByCodice(int codice);
    void savePezzo(Pezzi pezzo);
    void deletePezzo(int codice);
    List<Pezzi> findAllPezzi();
}
