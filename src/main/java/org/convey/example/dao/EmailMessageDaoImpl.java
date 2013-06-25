package org.convey.example.dao;

import org.convey.example.model.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tharanga
 * Date: 6/25/13
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("emailMessageDao")
public class EmailMessageDaoImpl implements EmailMessageDao{

    @Qualifier("mongoTemplate")
    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "EmailMessage_Sender";

    /**
     * {@inheritDoc}
     */
    @Override
    public EmailMessage findEmailMessageById(String id) {
        return mongoTemplate.findById(id,EmailMessage.class,COLLECTION_NAME);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmailMessage> findAllEmailMessage() {
        return mongoTemplate.findAll(EmailMessage.class);
    }


}
