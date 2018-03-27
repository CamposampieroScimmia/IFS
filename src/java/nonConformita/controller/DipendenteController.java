/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nonConformita.model.Dipendenti;
import nonConformita.model.Elaborazioni;
import nonConformita.model.Report;
import nonConformita.model.Segnalazioni;
import nonConformita.service.DipendenteService;
import nonConformita.service.ElaborazioniService;
import nonConformita.service.SegnalazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author FSEVERI\menegazzo3523
 */


@Controller
@RequestMapping("/Dipendente/")
@ComponentScan("nonConformita.service")
public class DipendenteController {
    @Autowired
    DipendenteService DipendenteService;
    @Autowired
    ElaborazioniService ElaborazioniService;
    @Autowired
    SegnalazioniService SegnalazioniService;
    
    @RequestMapping(value = { "/dipendente/home" }, method = RequestMethod.GET)
    public String home(ModelMap model) {
    
    Set <Report> tmpR = new HashSet <Report>();
    Set <Report> nCAperte = new HashSet <Report>();
    Set <Report> nCChiuse = new HashSet <Report>();
    Dipendenti tmp = DipendenteService.findByMatricola(ControllerGen.dip.getMatricola());
    List <Elaborazioni> tmpE = (List <Elaborazioni>) tmp.getElaborazioni();
    for(Elaborazioni e : tmpE){
        tmpR.add(e.getReport());
    }//for

        for(Report r:tmpR){
            if(r.getDataFine()==null){
                nCAperte.add(r);
            }//if
            nCChiuse.add(r);
        }//for
        
        model.addAttribute("nCAperte", nCAperte);
        model.addAttribute("nCChiuse", nCChiuse);
        
        return "/dipendente/home";
    }//home
    
        
    @RequestMapping(value = { "/dipendente/addSegnalazione" }, method = RequestMethod.GET)
    public void addSegnalazione(ModelMap model) {       
 
        Dipendenti tmp = DipendenteService.findByMatricola(ControllerGen.dip.getMatricola());    
        List<Segnalazioni> tmpS = (List<Segnalazioni>) tmp.getSegnalazioni();
        tmpS.add(new Segnalazioni());
        model.addAttribute("segnalazioni",tmpS);
    
    }//addSegnalazione
    
    @RequestMapping(value = { "/dipendente/updateSegnalazione" }, method = RequestMethod.GET)
    public void updateSegnalazione(ModelMap model) {
        
        
    }
}