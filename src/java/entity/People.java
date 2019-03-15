/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author scartlett
 */
@Entity
@Table(name = "people")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p")
    , @NamedQuery(name = "People.findByIdPeople", query = "SELECT p FROM People p WHERE p.idPeople = :idPeople")
    , @NamedQuery(name = "People.findByNamePeople", query = "SELECT p FROM People p WHERE p.namePeople = :namePeople")
    , @NamedQuery(name = "People.findByPassword", query = "SELECT p FROM People p WHERE p.password = :password")
    ,@NamedQuery(name="People.findByIdAndPassword",query="SELECT p FROM People p WHERE p.idPeople=:idPeople AND p.password=:password")})
public class People implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idPeople")
    private String idPeople;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NamePeople")
    private String namePeople;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeople")
    private Collection<Post> postCollection;

    public People() {
    }

    public People(String idPeople) {
        this.idPeople = idPeople;
    }

    public People(String idPeople, String namePeople, String password) {
        this.idPeople = idPeople;
        this.namePeople = namePeople;
        this.password = password;
    }

    public String getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(String idPeople) {
        this.idPeople = idPeople;
    }

    public String getNamePeople() {
        return namePeople;
    }

    public void setNamePeople(String namePeople) {
        this.namePeople = namePeople;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeople != null ? idPeople.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.idPeople == null && other.idPeople != null) || (this.idPeople != null && !this.idPeople.equals(other.idPeople))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.People[ idPeople=" + idPeople + " ]";
    }
    
}
