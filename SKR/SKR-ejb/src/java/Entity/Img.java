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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INFERUS
 */
@Entity
@Table(name = "Img")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Img.findAll", query = "SELECT i FROM Img i")
    , @NamedQuery(name = "Img.findById", query = "SELECT i FROM Img i WHERE i.id = :id")})
public class Img implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "img")
    private byte[] img;
    @JoinColumn(name = "id_patern", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pattern idPatern;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "img")
    private Collection<Thing> thingCollection;

    public Img() {
    }

    public Img(Integer id) {
        this.id = id;
    }

    public Img(Integer id, byte[] img) {
        this.id = id;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public Pattern getIdPatern() {
        return idPatern;
    }

    public void setIdPatern(Pattern idPatern) {
        this.idPatern = idPatern;
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
        if (!(object instanceof Img)) {
            return false;
        }
        Img other = (Img) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Img[ id=" + id + " ]";
    }
    
}
