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
@Table(name = "Pattern")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pattern.findAll", query = "SELECT p FROM Pattern p")
    , @NamedQuery(name = "Pattern.findById", query = "SELECT p FROM Pattern p WHERE p.id = :id")
    , @NamedQuery(name = "Pattern.findByName", query = "SELECT p FROM Pattern p WHERE p.name = :name")
    , @NamedQuery(name = "Pattern.findByPathimg", query = "SELECT p FROM Pattern p WHERE p.pathimg = :pathimg")})
public class Pattern implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Name")
    private int name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Path_img")
    private String pathimg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatern")
    private Collection<Img> imgCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pattern")
    private Collection<Stock> stockCollection;

    public Pattern() {
    }

    public Pattern(Integer id) {
        this.id = id;
    }

    public Pattern(Integer id, int name, String pathimg) {
        this.id = id;
        this.name = name;
        this.pathimg = pathimg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getPathimg() {
        return pathimg;
    }

    public void setPathimg(String pathimg) {
        this.pathimg = pathimg;
    }

    @XmlTransient
    public Collection<Img> getImgCollection() {
        return imgCollection;
    }

    public void setImgCollection(Collection<Img> imgCollection) {
        this.imgCollection = imgCollection;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
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
        if (!(object instanceof Pattern)) {
            return false;
        }
        Pattern other = (Pattern) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Pattern[ id=" + id + " ]";
    }
    
}
