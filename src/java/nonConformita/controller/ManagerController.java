/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import nonConformita.model.Report;
import nonConformita.model.Segnalazioni;
import nonConformita.service.DipendenteService;
import nonConformita.service.ReportService;
import nonConformita.service.SegnalazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Controller
@RequestMapping("/manager/")
@ComponentScan("nonConformita.service")
public class ManagerController {
    @Autowired
    DipendenteService DipendenteService;
    @Autowired
    SegnalazioniService SegnalazioniService;
    @Autowired
    ReportService ReportService;
     
    
    @RequestMapping(value = { "/manager/SegnalazioniLista" }, method = RequestMethod.GET)
    public String listaSegnalazioni(ModelMap model) {
 
        List<Segnalazioni> segnalazioni = SegnalazioniService.findAllSegnalazioni();
        model.addAttribute("segnalazioni", segnalazioni);
        
        return "SegnalazioniListaM";
    }
    
    @RequestMapping(value = { "nonConformita" }, method = RequestMethod.GET)
    public String nonConformita(ModelMap model) {
 
        List<Report> reports = ReportService.findAllReports();
        List<Report> reportC = (List<Report>) new HashSet<Report>();
        List<Report> reportE = (List<Report>) new HashSet<Report>();
   
        for(Report r: reports){
            if(r.getDataFine()!=null){
                reports.remove(r);
                reportC.add(r);
            }
        }
        
        for(Report r: reports){
            if(r.getAzioniCorrettive()!=null){
                reports.remove(r);
                reportE.add(r);
            }
        }
         
        model.addAttribute("nonConformitaAperte", reports);
        model.addAttribute("nonConformitaElaborazione", reportE);
        model.addAttribute("nonConformitaChiuse", reportC);
        
        return "nonConformitaM";
    }
    
}
