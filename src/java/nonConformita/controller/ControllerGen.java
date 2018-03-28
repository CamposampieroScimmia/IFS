/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.controller;

import nonConformita.model.Dipendenti;
import nonConformita.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@RequestMapping("/")
@ComponentScan("nonConformita.service")
public class ControllerGen {

    @Autowired
    DipendenteService DipendenteService;
    public static Dipendenti dip;
    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }//login

    @RequestMapping(value = {"/check"}, params = {"matr", "pass"}, method = RequestMethod.POST)
    public String check(ModelMap model, @RequestParam("matr") String matr, @RequestParam("pass") String pass) {
        Dipendenti user = DipendenteService.findByMatricola(matr);
        if (user == null) {
            model.addAttribute("ErrMsg", "Errore : nome utente non esistente");
            return "login";
        } else if (user.getPassword().equals(pass)) {
            dip=DipendenteService.findByMatricola(matr);
            if (user.getRuolo().equals("manager")) {
                return "homeM";
            }
            if (user.getRuolo().equals("responsabileQualita")) {
                return " homeR";
            }
            return " /dipendente/homeD";
        } else {
            model.addAttribute("ErrMsg", "Errore : password sbagliata");
            return "login";
        }
    }//check
}
