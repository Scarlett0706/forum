/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author scartlett
 */
@Entity
@Table(name = "reply")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reply.findAll", query = "SELECT r FROM Reply r")
    , @NamedQuery(name = "Reply.findByIdReply", query = "SELECT r FROM Reply r WHERE r.idReply = :idReply")
    , @NamedQuery(name = "Reply.findByContentReply", query = "SELECT r FROM Reply r WHERE r.contentReply = :contentReply")
    , @NamedQuery(name = "Reply.findByIdPeople", query = "SELECT r FROM Reply r WHERE r.idPeople = :idPeople")})
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idReply")
    private String idReply;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "contentReply")
    private String contentReply;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idPeople_")
    private String idPeople;
    @JoinColumn(name = "idPost_", referencedColumnName = "idPost")
    @ManyToOne(optional = false)
    private Post idPost;

    public Reply() {
    }

    public Reply(String idReply) {
        this.idReply = idReply;
    }

    public Reply(String idReply, String contentReply, String idPeople) {
        this.idReply = idReply;
        this.contentReply = contentReply;
        this.idPeople = idPeople;
    }

    public String getIdReply() {
        return idReply;
    }

    public void setIdReply(String idReply) {
        this.idReply = idReply;
    }

    public String getContentReply() {
        return contentReply;
    }

    public void setContentReply(String contentReply) {
        this.contentReply = contentReply;
    }

    public String getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(String idPeople) {
        this.idPeople = idPeople;
    }

    public Post getIdPost() {
        return idPost;
    }

    public void setIdPost(Post idPost) {
        this.idPost = idPost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReply != null ? idReply.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reply)) {
            return false;
        }
        Reply other = (Reply) object;
        if ((this.idReply == null && other.idReply != null) || (this.idReply != null && !this.idReply.equals(other.idReply))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reply[ idReply=" + idReply + " ]";
    }
    
}
