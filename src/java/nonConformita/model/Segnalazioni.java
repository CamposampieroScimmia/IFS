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
    private int codice;
    @Column(name="descrizione", nullable=false)
    private String descrizione;
    @Column(name="data", nullable=false)
    private Date data;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="dipendente")
    private Dipendenti dipendente;
}
