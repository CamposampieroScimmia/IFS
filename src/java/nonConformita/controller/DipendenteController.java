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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\menegazzo3523
 */
@Controller
@RequestMapping("/dipendente/")
@ComponentScan("nonConformita.service")
public class DipendenteController {

    @Autowired
    DipendenteService DipendenteService;
    @Autowired
    ElaborazioniService ElaborazioniService;
    @Autowired
    SegnalazioniService SegnalazioniService;

    @RequestMapping(value = {"/dipendente/home"}, method = RequestMethod.GET)
    public String home(ModelMap model) {

        Set<Report> ncAperte = new HashSet<Report>();
        Set<Report> ncChiuse = new HashSet<Report>();
        Set<Report> ncElaborazione = new HashSet<Report>();

        Dipendenti tmp = DipendenteService.findByMatricola(ControllerGen.dip.getMatricola());
        List<Elaborazioni> tmpE = (List<Elaborazioni>) tmp.getElaborazioni();
        for (Elaborazioni e : tmpE) {
            ncAperte.add(e.getReport());
        }

        for (Report r : ncAperte) {
            if (r.getDataFine() != null) {
                ncChiuse.add(r);
                ncAperte.remove(r);
            }
        }
        for (Report r : ncAperte) {
            if (r.getAzioniCorrettive() != null) {
                ncElaborazione.add(r);
            } else {
                ncAperte.add(r);
            }
        }

        model.addAttribute("nCAperte", ncAperte);
        model.addAttribute("nCElaborazione", ncElaborazione);
        model.addAttribute("nCChiuse", ncChiuse);

        return "homeD";
    }//home

    @RequestMapping(value = {"/dipendente/add"}, method = RequestMethod.GET)
    public String add(ModelMap model) {

        return "addSegnalazioneD";
    }//addSegnalazione

   
    @RequestMapping(value = {"/dipendente/addSegnalazione"}, method = RequestMethod.GET)
    public String addSegnalazione(ModelMap model, @ModelAttribute("segnalazione") Segnalazioni s) {

        SegnalazioniService.saveSegnalazione(s);
        return "homeD";
    }//addSegnalazione

}
   