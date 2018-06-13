/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INFERUS
 */
@Entity
@Table(name = "Stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findById", query = "SELECT s FROM Stock s WHERE s.id = :id")
    , @NamedQuery(name = "Stock.findByName", query = "SELECT s FROM Stock s WHERE s.name = :name")
    , @NamedQuery(name = "Stock.findByBlocked", query = "SELECT s FROM Stock s WHERE s.blocked = :blocked")
        , @NamedQuery(name = "Stock.findLast", query = "select s from Stock s order by s.id desc")
            , @NamedQuery(name = "Stock.search", query = "SELECT s FROM Stock s WHERE (s.name LIKE CONCAT('%',:name,'%'))")
})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Blocked")
    private boolean blocked;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStock")
    private Collection<StockUser> stockUserCollection;
    @JoinColumn(name = "Pattern", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pattern pattern;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private Collection<Thing> thingCollection;

    public Stock() {
    }

    public Stock(Integer id) {
        this.id = id;
    }

    public Stock(Integer id, String name, boolean blocked) {
        this.id = id;
        this.name = name;
        this.blocked = blocked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @XmlTransient
    public Collection<StockUser> getStockUserCollection() {
        return stockUserCollection;
    }

    public void setStockUserCollection(Collection<StockUser> stockUserCollection) {
        this.stockUserCollection = stockUserCollection;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    @XmlTransient
    public Collection<Thing> getThingCollection() {
        return thingCollection;
    }

    public void setThingCollection(Collection<Thing> thingCollection) {
        this.thingCollection = thingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Stock[ id=" + id + " ]";
    }
    
}
