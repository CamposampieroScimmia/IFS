/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.List;
import nonConformita.model.Categorie;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface CategoriaService {
    Categorie findByCategoria(String nome);
    void saveCategoria(Categorie categoria);
    void updateCategoria(Categorie categoria);
    void deleteCategoria(String nome);
    List<Categorie> findAllCategorie(); 
}
