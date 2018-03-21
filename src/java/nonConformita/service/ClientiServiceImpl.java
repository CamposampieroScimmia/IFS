/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.dao.ClienteDao;
import nonConformita.model.Clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Service("clientiService")
@Transactional
public class ClientiServiceImpl implements ClientiService {
    @Autowired
    private ClienteDao dao;
     
    public Clienti findByPiva(String piva) {
        return dao.findByPiva(piva);
    }
 
    public void saveCliente(Clienti cliente) {
        dao.saveCliente(cliente);
    }
 
    public void updateCliente(Clienti cliente) {
        Clienti entity = dao.findByPiva(cliente.getPiva());
        if(entity!=null){
            entity.setNomeCliente(cliente.getNomeCliente());
            entity.setReport(cliente.getReport());
        }
    }
 
    public void deleteCliente(String piva) {
        dao.deleteCliente(piva);
    }
     
    public List<Clienti> findAllClienti() {
        return dao.findAllClienti();
    }

}
