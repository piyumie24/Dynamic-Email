package org.convey.example.dao;

import org.convey.example.model.EmailMessage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tharanga
 * Date: 6/25/13
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EmailMessageDao {

    /**
     * <p>
     *     find cv application section with given id
     * </p>
     * @param id as {@link String}
     * @return instance of {@link EmailMessage}
     */
    EmailMessage findEmailMessageById(String id);

    /**
     * <p>
     *     find all cv application section
     * </p>
     * @return instance of {@link List<EmailMessage>}
     */
    List<EmailMessage> findAllEmailMessage();
}
