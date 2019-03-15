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
 * @author scartlett
 */
@Entity
@Table(name = "post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
    , @NamedQuery(name = "Post.findByIdPost", query = "SELECT p FROM Post p WHERE p.idPost = :idPost")
    , @NamedQuery(name = "Post.findByContentPost", query = "SELECT p FROM Post p WHERE p.contentPost = :contentPost")
    , @NamedQuery(name = "Post.findByType", query = "SELECT p FROM Post p WHERE p.type = :type"
    )})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idPost")
    private String idPost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "contentPost")
    private String contentPost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "idPeople__", referencedColumnName = "idPeople")
    @ManyToOne(optional = false)
    private People idPeople;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPost")
    private Collection<Reply> replyCollection;

    public Post() {
    }

    public Post(String idPost) {
        this.idPost = idPost;
    }

    public Post(String idPost, String contentPost, String type) {
        this.idPost = idPost;
        this.contentPost = contentPost;
        this.type = type;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getContentPost() {
        return contentPost;
    }

    public void setContentPost(String contentPost) {
        this.contentPost = contentPost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setType1() {
        this.setType("人文生活");
    }
    
    public void setType2() {
        this.setType("科技生活");
    }
    
     public void setType3() {
        this.setType("情感生活");
    }
     
      public void setType4() {
        this.setType("健康");
    }
      
       public void setType5() {
        this.setType("学习");
    }
       
        public void setType6() {
        this.setType("实习");
    }
        
         public void setType7() {
        this.setType("美食");
    }
         
          public void setType8() {
        this.setType("体育健身");
    }
          
         public void setType9() {
        this.setType("乡亲乡爱");
    }
         
          public void setType10() {
        this.setType("游戏对战");
    }
          
           public void setType11() {
        this.setType("人文艺术");
    }
           
            public void setType12() {
        this.setType("信息社会");
    }
            
             public void setType13() {
        this.setType("其他");
    }
    public People getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(People idPeople) {
        this.idPeople = idPeople;
    }

    @XmlTransient
    public Collection<Reply> getReplyCollection() {
        return replyCollection;
    }

    public void setReplyCollection(Collection<Reply> replyCollection) {
        this.replyCollection = replyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPost != null ? idPost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.idPost == null && other.idPost != null) || (this.idPost != null && !this.idPost.equals(other.idPost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Post[ idPost=" + idPost + " ]";
    }
    
}
