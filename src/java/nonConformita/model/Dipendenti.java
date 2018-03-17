/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Entity
@Table(name = "Dipendenti")
public class Dipendenti implements Serializable {

    @Id
    @Column(name = "matricola", nullable = false)
    private String matricola;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cognome", nullable = false)
    private String cognome;
    @Enumerated(EnumType.STRING)
    @Column(name = "ruolo", nullable = false)
    private Ruolo ruolo;
     
    @OneToMany(fetch=FetchType.EAGER,mappedBy="dipendente")
    private List<Segnalazioni>segnalazioni;
    
    @OneToMany(fetch=FetchType.EAGER,mappedBy="dipendente")
    private List<Elaborazioni>elaborazioni;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="reparto")
    private Reparti reparto;
    
    public Dipendenti() {
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Enumerated(EnumType.STRING)
    public Ruolo getRuolo() {
        return ruolo;
    }

    @Enumerated(EnumType.STRING)
    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public List<Segnalazioni> getSegnalazioni() {
        return segnalazioni;
    }

    public void setSegnalazioni(List<Segnalazioni> segnalazioni) {
        this.segnalazioni = segnalazioni;
    }

    public List<Elaborazioni> getElaborazioni() {
        return elaborazioni;
    }

    public void setElaborazioni(List<Elaborazioni> elaborazioni) {
        this.elaborazioni = elaborazioni;
    }

    public Reparti getReparto() {
        return reparto;
    }

    public void setReparto(Reparti reparto) {
        this.reparto = reparto;
    }

}
