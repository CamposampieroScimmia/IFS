/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.model.Pezzi;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface PezziService {
    Pezzi findById(int id);
    void savePezzo(Pezzi pezzo);
    void updatePezzo(Pezzi pezzo);
    void deletePezzo(int id);
    List<Pezzi> findAllPezzi(); 
}
