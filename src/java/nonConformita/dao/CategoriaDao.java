/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;
import java.util.List;
import nonConformita.model.Categorie;
/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface CategoriaDao {
    Categorie findByCategoria(String Categoria);
    void saveCategoria(Categorie categoria);
    void deleteCategoria(String Categoria);
    List<Categorie> findAllCategorie();
}
