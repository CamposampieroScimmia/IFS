/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.dao.ReportDao;
import nonConformita.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService{
    @Autowired
    private ReportDao dao;
     
    public Report findById(int id) {
        return dao.findByCodiceNC(id);
    }
 
    public void saveReport(Report report) {
        dao.saveReport(report);
    }
 
    public void updateReport(Report report) {
        Report entity = dao.findByCodiceNC(report.getCodiceNC());
        if(entity!=null){
            entity.setDescrizioneProb(report.getDescrizioneProb());
            entity.setDataInizio(report.getDataInizio());
            entity.setDataFine(report.getDataFine());
            entity.setStato(report.getStato());
            entity.setCause(report.getCause());
            entity.setTeamOp(report.getTeamOp());
            entity.setAzioniCorrettive(report.getAzioniCorrettive());
            entity.setEfficaciaAC(report.getEfficaciaAC());
            entity.setAzioniContenitive(report.getAzioniContenitive());
            entity.setPrevenzione(report.getPrevenzione());
            entity.setCosto(report.getCosto());
            entity.setRevisioneF(report.getRevisioneF());
            entity.setReport(report.getReport());
            entity.setTipoNC(report.getTipoNC());
            entity.setFornitore(report.getFornitore());
            entity.setReparto(report.getReparto());
            entity.setCliente(report.getCliente());
            entity.setPezzi(report.getPezzi());
        }
    }
 
    public void deleteReport(int id) {
        dao.deleteReport(id);
    }
     
    public List<Report> findAllReports() {
        return dao.findAllReports();
    }
}
