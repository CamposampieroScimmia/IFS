/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.model.TipoNC;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface TipoNCService {
        TipoNC findByNome(String nome);
    void saveTipoNC(TipoNC tipoNC);
    void updateTipoNC(TipoNC tipoNC);
    void deleteTipoNC(String nome);
    List<TipoNC> findAllTipoNC(); 
}
