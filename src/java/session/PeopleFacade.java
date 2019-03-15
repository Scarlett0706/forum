/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.People;
import javax.ejb.Stateless;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayList;

/**
 *
 * @author scartlett
 */
@Stateful
public class PeopleFacade extends AbstractFacade<People> {

    @PersistenceContext(unitName = "WebApplication7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeopleFacade() {
        super(People.class);
    }
    
    public List<People> locatePeopleByIdAndPassword(String idPeople,String password){
        List<People> peoples=new ArrayList();
        try{
            String jsql="SELECT p FROM People p WHERE p.idPeople='"+idPeople+"' AND p.password='"+password+"'";
       List<People> peopleByidPeopleAndPassword=em.createQuery(jsql).getResultList();
        for(Iterator iterator=peopleByidPeopleAndPassword.iterator();iterator.hasNext();){
               People people1_=(People)iterator.next();
               peoples.add(people1_);
           }
    }
        catch(Exception e){
            
    }
        return peoples;
    }
    
    
    public List<People> locatePeopleById(String idPeople_){
        List<People> peoples_=new ArrayList();
        try{
            String jsql="SELECT p FROM People p WHERE p.idPeople='"+idPeople_+"'";
       List<People> peopleByid=em.createQuery(jsql).getResultList();
        for(Iterator iterator=peopleByid.iterator();iterator.hasNext();){
               People people1_=(People)iterator.next();
               peoples_.add(people1_);
           }
    }
        catch(Exception e){
            
    }
        return peoples_;
    }
}
