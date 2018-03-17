/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Clienti;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface ClienteDao {
    Clienti findByPiva(String piva);
    void saveCliente(Clienti cliente);
    void deleteCliente(String piva);
    List<Clienti> findAllClienti();
}
