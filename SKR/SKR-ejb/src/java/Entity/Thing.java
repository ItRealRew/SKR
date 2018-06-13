/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INFERUS
 */
@Entity
@Table(name = "Thing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thing.findAll", query = "SELECT t FROM Thing t")
    , @NamedQuery(name = "Thing.findById", query = "SELECT t FROM Thing t WHERE t.id = :id")
    , @NamedQuery(name = "Thing.findByName", query = "SELECT t FROM Thing t WHERE t.name = :name")
    , @NamedQuery(name = "Thing.findByQuantity", query = "SELECT t FROM Thing t WHERE t.quantity = :quantity")
    , @NamedQuery(name = "Thing.findByDateupdate", query = "SELECT t FROM Thing t WHERE t.dateupdate = :dateupdate")
    , @NamedQuery(name = "Thing.findByNameInStock", query = "SELECT t FROM Thing t WHERE (t.name = :name) AND (t.stock =:Stock)")
    , @NamedQuery(name = "Thing.findByStorage", query = "SELECT t FROM Thing t WHERE t.stock = :Stock")
    , @NamedQuery(name = "Thing.findByPathAndStock", query = "SELECT t FROM Thing t WHERE (t.name LIKE CONCAT('%',:name,'%')) AND (t.stock =:Stock)") 


})
public class Thing implements Serializable {

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
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_update")
    @Temporal(TemporalType.DATE)
    private Date dateupdate;
    @JoinColumn(name = "Stock", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stock stock;
    @JoinColumn(name = "Unit", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unit;
    @JoinColumn(name = "img", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Img img;

    public Thing() {
    }

    public Thing(Integer id) {
        this.id = id;
    }

    public Thing(Integer id, String name, int quantity, Date dateupdate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.dateupdate = dateupdate;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateupdate() {
        return dateupdate;
    }

    public void setDateupdate(Date dateupdate) {
        this.dateupdate = dateupdate;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
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
        if (!(object instanceof Thing)) {
            return false;
        }
        Thing other = (Thing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Thing[ id=" + id + " ]";
    }
    
}
