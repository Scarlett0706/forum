/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Post;
import javax.ejb.Stateless;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import jsf.PeopleController;

/**
 *
 * @author scartlett
 */
@Stateful
public class PostFacade extends AbstractFacade<Post> {

    @PersistenceContext(unitName = "WebApplication7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Post> locatePostByLike(String like){
        List posts=new ArrayList();
        try{
        String jsql="SELECT p FROM Post p WHERE p.contentPost LIKE '"+"%"+like+"%'";
        List postsByLike=em.createQuery(jsql).getResultList();
        for(Iterator iterator=postsByLike.iterator();iterator.hasNext();){
               Post post1_=(Post)iterator.next();
               posts.add(post1_);
           }
    }
        catch(Exception e){
            
    }
        return posts;
    }
    
    public List<Post> locatePostByType(String type){
          List posts=new ArrayList();
        try{
        String jsql="SELECT p FROM Post p WHERE p.type='"+type+"' ";
        List postsByType=em.createQuery(jsql).getResultList();
        for(Iterator iterator=postsByType.iterator();iterator.hasNext();){
               Post post1_=(Post)iterator.next();
               posts.add(post1_);
           }
    }
        catch(Exception e){
            
    }
        return posts;
    }
    
    public List<Post> locatePostByPeopleId(String s){
          List posts=new ArrayList();
        try{
        String jsql="SELECT p FROM Post p WHERE p.idPeople.idPeople ='"+s+"'";
        List postsByPeopleId=em.createQuery(jsql).getResultList();
        for(Iterator iterator=postsByPeopleId.iterator();iterator.hasNext();){
               Post post1_=(Post)iterator.next();
               posts.add(post1_);
           }
    }
        catch(Exception e){
            
    }
        return posts;
    }
    
    public PostFacade() {
        super(Post.class);
    }
    
}
