package org.convey.example.services;

import org.convey.example.dao.EmailMessageDao;
import org.convey.example.model.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tharanga
 * Date: 6/25/13
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("emailMessageService")
public class EmailMessageServicesImpl implements EmailMessageServices{
    @Autowired
    private EmailMessageDao emailMessageDao;

    @Override
    public EmailMessage findEmailMessageById(String id) {
        return emailMessageDao.findEmailMessageById(id);
    }

    @Override
    public List<EmailMessage> findAllEmailMessage(){
        return emailMessageDao.findAllEmailMessage();
    }

}
