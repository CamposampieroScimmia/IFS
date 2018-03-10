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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
@Entity
@Table(name="Clienti")
public class Clienti  implements Serializable{
    @Id
    @Column(name="piva")
    private String piva;
    @Column(name="nomeCliente")
    private String nomeCliente;
    
    @OneToMany(fetch=FetchType.EAGER,mappedBy="cliente")
    private List<Report>report;
    
}
