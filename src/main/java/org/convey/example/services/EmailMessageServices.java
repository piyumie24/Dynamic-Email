package org.convey.example.services;

import org.convey.example.model.EmailMessage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tharanga
 * Date: 6/25/13
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EmailMessageServices {
    /**
     * <p>
     *     find EmailMessage with given id
     * </p>
     * @param id as {@link String}
     * @return instance of {@link EmailMessage}
     */
    EmailMessage findEmailMessageById(String id);

    /**
     * <p>
     *     find all EmailMessage with given id
     * </p>
     *
     */
    List<EmailMessage> findAllEmailMessage();
}
