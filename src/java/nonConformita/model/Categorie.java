/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.model;

import java.io.Serializable;
import java.util.Set;
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
    @Column(name = "categoria",nullable = false, length=50 )
    private String categoria;
    @Column(name = "note", nullable = false, length=50)
    private String note;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="categoria")
    private Set<Pezzi> pezzi;

    public Categorie() {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Pezzi> getPezzi() {
        return pezzi;
    }

    public void setPezzi(Set<Pezzi> pezzi) {
        this.pezzi = pezzi;
    }

}
