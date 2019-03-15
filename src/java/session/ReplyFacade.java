/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Reply;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author scartlett
 */
@Stateful
public class ReplyFacade extends AbstractFacade<Reply> {

    @PersistenceContext(unitName = "WebApplication7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Reply> locateReplyByPostId(String PostId){
          List replys=new ArrayList();
        try{
        String jsql="SELECT r FROM Reply r WHERE r.idPost.idPost ='"+PostId+"'";
        List replysByPostId=em.createQuery(jsql).getResultList();
        for(Iterator iterator=replysByPostId.iterator();iterator.hasNext();){
               Reply reply1_=(Reply)iterator.next();
               replys.add(reply1_);
           }
    }
        catch(Exception e){
            
    }
        return replys;
    }
    
     public List<Reply> locateReplyByPeopleId(String PeopleId){
          List replys=new ArrayList();
        try{
        String jsql="SELECT r FROM Reply r WHERE r.idPost.idPeople.idPeople ='"+PeopleId+"'";
        List replysByPostId=em.createQuery(jsql).getResultList();
        for(Iterator iterator=replysByPostId.iterator();iterator.hasNext();){
               Reply reply1_=(Reply)iterator.next();
               replys.add(reply1_);
           }
    }
        catch(Exception e){
            
    }
        return replys;
    }
    public ReplyFacade() {
        super(Reply.class);
    }
    
}
