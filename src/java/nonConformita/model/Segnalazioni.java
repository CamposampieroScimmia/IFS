/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Entity
@Table(name="Segnalazioni")
public class Segnalazioni implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="codice", nullable=false)
    private int codice;
    @Column(name="descrizione", nullable=false,length=200)
    private String descrizione;
    @Column(name="data", nullable=false)
    private Date data;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="dipendente")
    private Dipendenti dipendente;

    public Segnalazioni() {
    }
    
    public Segnalazioni(int codice, String descrizione, Date data){
        this.codice=codice;
        this.descrizione=descrizione;
        this.data=data;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Dipendenti getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendenti dipendente) {
        this.dipendente = dipendente;
    }
    
    
}
