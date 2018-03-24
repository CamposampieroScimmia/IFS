/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.controller;

import java.util.List;
import nonConformita.model.Dipendenti;
import nonConformita.model.Segnalazioni;
import nonConformita.service.DipendenteService;
import nonConformita.service.SegnalazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
     
    
    @RequestMapping(value = { "/responsabileQualita/home" }, method = RequestMethod.GET)
    public String home(ModelMap model) {
 
        List<Segnalazioni> segnalazioni = SegnalazioniService.findAllSegnalazioni();
        for(Segnalazioni s:segnalazioni){
            if(s.getDipendente().getReparto().equals(ControllerGen.dip.getReparto()));
        }
        model.addAttribute("segnalazioni", segnalazioni);
        
        return "/responsabileQualita/home";
    }
    

}
