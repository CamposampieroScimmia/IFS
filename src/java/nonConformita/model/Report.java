/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Entity
@Table(name = "Report")
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codiceNC",nullable=false)
    private int codiceNC;
    @Column(name = "descrizioneProb")
    private String descrizioneProb;
    @Column(name = "dataInizio", nullable = false)
    private Date dataInizio;
    @Column(name = "dataFine")
    private Date dataFine;
    @Column(name = "cause")
    private String cause;
    @Column(name = "teamOp")
    private String teamOp;
    @Column(name = "azioniCorrettive")
    private String azioniCorrettive;
    @Column(name = "efficaciaAC")
    private String efficaciaAC;
    @Column(name = "azioniContenitive")
    private String azioniContenitive;
    @Column(name = "prevenzione")
    private String prevenzione;
    @Column(name = "costo")
    private int costo;
    @Column(name = "revisioneFinale")
    private String revisioneF;

    @OneToMany(fetch=FetchType.LAZY,mappedBy = "report")
    private Set<Report> report;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "tipoNC")
    private TipoNC tipoNC;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "fornitore")
    private Fornitori fornitore;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "reparto")
    private Reparti reparto;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "cliente")
    private Clienti cliente;
    
    @ManyToMany(fetch=FetchType.LAZY)
        @JoinTable(
        name = "Report_Pezzi", 
        joinColumns = { @JoinColumn(name = "codiceNC") }, 
        inverseJoinColumns = { @JoinColumn(name = "codice") }
    )
    private Set<Pezzi> pezzi;


    public Report() {
    }

    public int getCodiceNC() {
        return codiceNC;
    }

    public void setCodiceNC(int codiceNC) {
        this.codiceNC = codiceNC;
    }

    public String getDescrizioneProb() {
        return descrizioneProb;
    }

    public void setDescrizioneProb(String descrizioneProb) {
        this.descrizioneProb = descrizioneProb;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }


    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getTeamOp() {
        return teamOp;
    }

    public void setTeamOp(String teamOp) {
        this.teamOp = teamOp;
    }

    public String getAzioniCorrettive() {
        return azioniCorrettive;
    }

    public void setAzioniCorrettive(String azioniCorrettive) {
        this.azioniCorrettive = azioniCorrettive;
    }

    public String getEfficaciaAC() {
        return efficaciaAC;
    }

    public void setEfficaciaAC(String efficaciaAC) {
        this.efficaciaAC = efficaciaAC;
    }

    public String getAzioniContenitive() {
        return azioniContenitive;
    }

    public void setAzioniContenitive(String azioniContenitive) {
        this.azioniContenitive = azioniContenitive;
    }

    public String getPrevenzione() {
        return prevenzione;
    }

    public void setPrevenzione(String prevenzione) {
        this.prevenzione = prevenzione;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getRevisioneF() {
        return revisioneF;
    }

    public void setRevisioneF(String revisioneF) {
        this.revisioneF = revisioneF;
    }

    public Set<Report> getReport() {
        return report;
    }

    public void setReport(Set<Report> report) {
        this.report = report;
    }

    public TipoNC getTipoNC() {
        return tipoNC;
    }

    public void setTipoNC(TipoNC tipoNC) {
        this.tipoNC = tipoNC;
    }

    public Fornitori getFornitore() {
        return fornitore;
    }

    public void setFornitore(Fornitori fornitore) {
        this.fornitore = fornitore;
    }

    public Reparti getReparto() {
        return reparto;
    }

    public void setReparto(Reparti reparto) {
        this.reparto = reparto;
    }

    public Clienti getCliente() {
        return cliente;
    }

    public void setCliente(Clienti cliente) {
        this.cliente = cliente;
    }

    public Set<Pezzi> getPezzi() {
        return pezzi;
    }

    public void setPezzi(Set<Pezzi> pezzi) {
        this.pezzi = pezzi;
    }
    
    
}
