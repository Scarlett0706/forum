package entity;

import entity.People;
import entity.Reply;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-21T16:27:11")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile CollectionAttribute<Post, Reply> replyCollection;
    public static volatile SingularAttribute<Post, String> contentPost;
    public static volatile SingularAttribute<Post, People> idPeople;
    public static volatile SingularAttribute<Post, String> type;
    public static volatile SingularAttribute<Post, String> idPost;

}