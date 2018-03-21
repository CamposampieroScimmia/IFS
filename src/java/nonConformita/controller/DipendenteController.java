/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Controller
@RequestMapping("/")
@ComponentScan("nonConformita.service")
public class DipendenteController {
    @Autowired
    Service service;
    
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";
    }
}
