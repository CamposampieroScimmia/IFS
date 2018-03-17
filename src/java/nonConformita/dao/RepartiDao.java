/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;
import java.util.List;
import nonConformita.model.Reparti;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface RepartiDao {
    Reparti findByNome(String nome);
    void saveReparto(Reparti reparto);
    void deleteReparto(String nome);
    List<Reparti> findAllReparti();
}