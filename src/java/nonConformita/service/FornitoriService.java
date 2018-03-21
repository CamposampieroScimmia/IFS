/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.model.Fornitori;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface FornitoriService {
    Fornitori findByPiva(String piva);
    void saveFornitore(Fornitori fornitore);
    void updateFornitore(Fornitori fornitore);
    void deleteFornitore(String piva);
    List<Fornitori> findAllFornitori(); 
}
