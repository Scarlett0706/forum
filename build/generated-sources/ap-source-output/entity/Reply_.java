package entity;

import entity.Post;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-21T16:27:11")
@StaticMetamodel(Reply.class)
public class Reply_ { 

    public static volatile SingularAttribute<Reply, String> contentReply;
    public static volatile SingularAttribute<Reply, String> idReply;
    public static volatile SingularAttribute<Reply, String> idPeople;
    public static volatile SingularAttribute<Reply, Post> idPost;

}