/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.dao.TipoNCDao;
import nonConformita.model.TipoNC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Service("tipoNCService")
@Transactional
public class TipoNCServiceImpl implements TipoNCService {
     @Autowired
    private TipoNCDao dao;
     
    public TipoNC findByNome(String nome) {
        return dao.findByNome(nome);
    }
 
    public void saveTipoNC(TipoNC tipoNC) {
        dao.saveTipoNC(tipoNC);
    }
 
    public void updateTipoNC(TipoNC tipoNC) {
        TipoNC entity = dao.findByNome(tipoNC.getNome());
        if(entity!=null){
            entity.setDescrizione(tipoNC.getDescrizione());
            entity.setReport(tipoNC.getReport());

        }
    }
 
    public void deleteTipoNC(String nome) {
        dao.deleteTipoNC(nome);
    }
     
    public List<TipoNC> findAllTipoNC() {
        return dao.findAllTipoNC();
    }
}
