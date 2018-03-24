/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nonConformita.model.Dipendenti;
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
@RequestMapping("/responsabileQualita/")
@ComponentScan("nonConformita.service")
public class ResponsabileQualitaController {
    @Autowired
    DipendenteService DipendenteService;
    @Autowired
    SegnalazioniService SegnalazioniService;
    @Autowired
    ReportService ReportService;
     
    
    @RequestMapping(value = { "/responsabileQualita/SegnalazioniLista" }, method = RequestMethod.GET)
    public String listaSegnalazioni(ModelMap model) {
 
        List<Segnalazioni> segnalazioni = SegnalazioniService.findAllSegnalazioni();
        for(Segnalazioni s:segnalazioni){
            if(!s.getDipendente().getReparto().equals(ControllerGen.dip.getReparto()))segnalazioni.remove(s);
        }
        model.addAttribute("segnalazioni", segnalazioni);
        
        return "/responsabileQualita/SegnalazioniLista";
    }
    
    @RequestMapping(value = { "/responsabileQualita/nonConformita" }, method = RequestMethod.GET)
    public String nonConformita(ModelMap model) {
 
        List<Report> reports = ReportService.findAllReports();
        List<Report> reportC = (List<Report>) new HashSet<Report>();
        for(Report r: reports){
            if(!r.getReparto().equals(ControllerGen.dip.getReparto()))reports.remove(r);
        }
        
        for(Report r: reports){
            if(r.getDataFine()!=null){
                reports.remove(r);
                reportC.add(r);
            }
        }
         
        model.addAttribute("nonConformitaAperte", reports);
        model.addAttribute("nonConformitaChiuse", reportC);
        
        return "/responsabileQualita/nonConformita";
    }
    
    @RequestMapping(value = { "/responsabileQualita/addNonConformita" },params = {"dataInizio", "descProb"}, method = RequestMethod.GET)
    public String addNonConformita(ModelMap model,@RequestParam("dataInizio") Date dataI, @RequestParam("descProb") String descrProb) {
        ReportService.saveReport(new Report(descrProb,dataI));
        return "/responsabileQualita/nonConformita";
    }
    
    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String updateNonConformita(ModelMap model, @ModelAttribute("report") Report r) {
        if(r!=null){
            ReportService.updateReport(r);
            model.addAttribute("nonConformita", r);
        }
        model.addAttribute("ErrMsg", "Errore : inserire valori all'interno dei campi");
        return "/responsabileQualita/nonConformita";

    }

}
