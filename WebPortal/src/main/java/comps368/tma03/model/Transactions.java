/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comps368.tma03.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cyrus Cheng
 */
@Entity
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findByTransId", query = "SELECT t FROM Transactions t WHERE t.transId = :transId")
    , @NamedQuery(name = "Transactions.findByClientId", query = "SELECT t FROM Transactions t WHERE t.clientId = :clientId")
    , @NamedQuery(name = "Transactions.findByTransDtm", query = "SELECT t FROM Transactions t WHERE t.transDtm = :transDtm")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transId")
    private Long transId;
    
    @Basic(optional = false)
    @Column(name = "clientId")
    private int clientId;
    
    @Basic(optional = false)
    @Column(name = "transDtm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDtm;
    
    @Transient
    private int ttlQty;
    
    @Transient
    private double ttlAmt;    

    public int getTtlQty() {
        return ttlQty;
    }

    public double getTtlAmt() {
        return ttlAmt;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transId")
    private List<TransactionDetails> transactiondetailsList;

    public Transactions() {
    }

    public Transactions(Long transId) {
        this.transId = transId;
    }

    public Transactions(Long transId, int clientId, Date transDtm) {
        this.transId = transId;
        this.clientId = clientId;
        this.transDtm = transDtm;
    }
    
    @PostLoad
    public void CalTotal(){
        for(TransactionDetails d : transactiondetailsList){
            ttlQty += d.getQty();
            Items i = d.getItemId();
            if(i != null){
                ttlAmt += (i.getItemPrice() * d.getQty());
            }
        }
    }

    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getTransDtm() {
        return transDtm;
    }

    public void setTransDtm(Date transDtm) {
        this.transDtm = transDtm;
    }

    @XmlTransient
    public List<TransactionDetails> getTransactiondetailsList() {
        return transactiondetailsList;
    }

    public void setTransactiondetailsList(List<TransactionDetails> transactiondetailsList) {
        this.transactiondetailsList = transactiondetailsList;
    }
}