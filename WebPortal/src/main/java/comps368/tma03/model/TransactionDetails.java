/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comps368.tma03.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cyrus Cheng
 */
@Entity
@Table(name = "transactiondetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionDetails.findAll", query = "SELECT t FROM TransactionDetails t")
    , @NamedQuery(name = "TransactionDetails.findByTransDetailId", query = "SELECT t FROM TransactionDetails t WHERE t.transDetailId = :transDetailId")
    , @NamedQuery(name = "TransactionDetails.findByQty", query = "SELECT t FROM TransactionDetails t WHERE t.qty = :qty")})
public class TransactionDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transDetailId")
    private Long transDetailId;
    
    @Basic(optional = false)
    @Column(name = "qty")
    private int qty;
    
    @JoinColumn(name = "itemId", referencedColumnName = "itemId")
    @ManyToOne(optional = false)
    private Items itemId;
    
    @JoinColumn(name = "transId", referencedColumnName = "transId")
    @ManyToOne(optional = false)
    private Transactions transId;

    public TransactionDetails() {
    }

    public TransactionDetails(Long transDetailId) {
        this.transDetailId = transDetailId;
    }

    public TransactionDetails(Long transDetailId, int qty) {
        this.transDetailId = transDetailId;
        this.qty = qty;
    }

    public Long getTransDetailId() {
        return transDetailId;
    }

    public void setTransDetailId(Long transDetailId) {
        this.transDetailId = transDetailId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Items getItemId() {
        return itemId;
    }

    public void setItemId(Items itemId) {
        this.itemId = itemId;
    }

    public Transactions getTransId() {
        return transId;
    }

    public void setTransId(Transactions transId) {
        this.transId = transId;
    }
}