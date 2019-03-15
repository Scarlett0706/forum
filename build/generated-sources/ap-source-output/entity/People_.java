package entity;

import entity.Post;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-21T16:27:11")
@StaticMetamodel(People.class)
public class People_ { 

    public static volatile SingularAttribute<People, String> password;
    public static volatile SingularAttribute<People, String> namePeople;
    public static volatile CollectionAttribute<People, Post> postCollection;
    public static volatile SingularAttribute<People, String> idPeople;

}