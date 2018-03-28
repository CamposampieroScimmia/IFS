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
@RequestMapping("/Dipendente/")
@ComponentScan("nonConformita.service")
public class DipendenteController {

    @Autowired
    DipendenteService DipendenteService;
    @Autowired
    ElaborazioniService ElaborazioniService;
    @Autowired
    SegnalazioniService SegnalazioniService;

    /**
     * Metodo che consente la visualizzazione della non conformità aperte, in fase di elaborazione e chiuse
     * @param model: 
     * @return 
     */
    @RequestMapping(value = {"/dipendente/home"}, method = RequestMethod.GET)
    public String home(ModelMap model) {

        Set<Report> tmpR = new HashSet<Report>();
        Set<Report> nCAperte = new HashSet<Report>();
        Set<Report> nCChiuse = new HashSet<Report>();
        Set<Report> nCElaborazione = new HashSet<Report>();
        Dipendenti tmp = DipendenteService.findByMatricola(ControllerGen.dip.getMatricola());
        List<Elaborazioni> tmpE = (List<Elaborazioni>) tmp.getElaborazioni();
        for (Elaborazioni e : tmpE) {
            tmpR.add(e.getReport());
        }//for

        for (Report r : tmpR) {
            if (r.getDataFine() == null) {
                nCAperte.add(r);
            }//if
            if (r.getAzioniCorrettive() != null && r.getDataFine() == null) {
                nCElaborazione.add(r);
            }//if
            nCChiuse.add(r);
        }//for

        model.addAttribute("nCAperte", nCAperte);
        model.addAttribute("nCChiuse", nCChiuse);

        return "/dipendente/home";
    }//home

    /**
     * Metodo che consente al dipendente di effettuare una nuova segnalazione.
     * @param model
     * @param data attributo inerente alla Segnalazione
     * @param codice attributo inerente alla Segnalazione
     * @param descrizione attributo inerente alla Segnalazione
     * @return 
     */
    @RequestMapping(value = {"/dipendente/addSegnalazione"}, params = {"codice", "descrizione", "data"}, method = RequestMethod.GET)
    public String addSegnalazione(ModelMap model, @RequestParam("data") Date data, @RequestParam("codice") int codice, @RequestParam("descrizione") String descrizione) {

        SegnalazioniService.saveSegnalazione(new Segnalazioni(codice, descrizione, data));
        return "/dipendente/home";
    }//addSegnalazione

    /**
     * Metodo che offre al dipendente la possibilità di modificare una segnalazione effettuata in precedenza.
     * @param model
     * @param s oggetto di tipo Segnalazioni
     * @return 
     */
    @RequestMapping(value = {"/dipendente/updateSegnalazione"}, method = RequestMethod.GET)
    public String updateSegnalazione(ModelMap model, @ModelAttribute("segnalazione") Segnalazioni s) {
        if(s!=null){
            SegnalazioniService.updateSegnalazione(s);
            model.addAttribute("segnalazione", s);
        }//if
        model.addAttribute("ErrMsg", "Errore : Completare i campi indicati");
        return "/dipendente/home";
    }//updateSegnalazione
}
