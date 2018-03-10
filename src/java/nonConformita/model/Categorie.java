/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Entity
@Table(name="Categorie")
public class Categorie implements Serializable{
    @Id
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "note", nullable = false)
    private String note;
    
    
    @OneToMany(fetch=FetchType.EAGER,mappedBy="categoria")
    private List<Pezzi> pezzi;

}
