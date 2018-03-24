/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Entity
@Table(name = "Elaborazioni")
public class Elaborazioni implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, length=11)
    private int ID;
    @Column(name = "descrizione", nullable = false, length=200)
    private String descrizione;
    @Column(name = "dataI", nullable = false)
    private Date dataI;
    @Column(name = "dataF")
    private Date dataF;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dipendente")
    private Dipendenti dipendente;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="report")
    private Report report;

    public Elaborazioni() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataI() {
        return dataI;
    }

    public void setDataI(Date dataI) {
        this.dataI = dataI;
    }

    public Date getDataF() {
        return dataF;
    }

    public void setDataF(Date dataF) {
        this.dataF = dataF;
    }

    public Dipendenti getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendenti dipendente) {
        this.dipendente = dipendente;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
    
}
