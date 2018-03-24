/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.model;

import java.io.Serializable;
import java.util.Set;
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
    @Column(name = "matricola", nullable = false, length=8)
    private String matricola;
    @Column(name = "password", nullable = false, length=20)
    private String password;
    @Column(name = "nome", nullable = false, length=20)
    private String nome;
    @Column(name = "cognome", nullable = false, length=20)
    private String cognome;
    @Enumerated(EnumType.STRING)
    @Column(name = "ruolo", nullable = false, length=20)
    private Ruolo ruolo;
     
    @OneToMany(fetch=FetchType.LAZY,mappedBy="dipendente")
    private Set<Segnalazioni>segnalazioni;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="dipendente")
    private Set<Elaborazioni>elaborazioni;
    
    @ManyToOne(fetch=FetchType.LAZY)
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

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public Set<Segnalazioni> getSegnalazioni() {
        return segnalazioni;
    }

    public void setSegnalazioni(Set<Segnalazioni> segnalazioni) {
        this.segnalazioni = segnalazioni;
    }

    public Set<Elaborazioni> getElaborazioni() {
        return elaborazioni;
    }

    public void setElaborazioni(Set<Elaborazioni> elaborazioni) {
        this.elaborazioni = elaborazioni;
    }

    public Reparti getReparto() {
        return reparto;
    }

    public void setReparto(Reparti reparto) {
        this.reparto = reparto;
    }

}
