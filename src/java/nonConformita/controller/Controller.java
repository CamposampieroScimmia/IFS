/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.controller;

import java.util.List;


/**
 *
 * @author FSEVERI\bollettin3412
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import org.springframework.context.annotation.ComponentScan;
 
@org.springframework.stereotype.Controller
@RequestMapping("/")
@ComponentScan("nonConformita.dao")
public class Controller {
 
    @Autowired
     
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";
    }
 
}

