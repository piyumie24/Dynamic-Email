package org.convey.example.controller;

import org.convey.example.email.EmailSender;
import org.convey.example.model.EmailMessage;
import org.convey.example.services.EmailMessageServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * $LastChangedDate:  $
 * $LastChangedBy:  $
 * $LastChangedRevision:  $
 */
@Controller
public class EmailController {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("emailConfiguration.xml");
    EmailSender emailSender=(EmailSender)context.getBean("emailSenderBean");


    final static Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailMessageServices emailMessageServices;

    /*@RequestMapping(value="/emailForm",method= RequestMethod.GET)
    public ModelAndView displayEmailForm(Map<String, Object> map){

        logger.debug(" setting up the Email form ");

        ModelAndView view=new ModelAndView("EmailFormView");

        //setting up the  required parameter value in the request scope for CommandName parameter
        map.put("email", new EmailMessage());

        return view;

    }    */

    @RequestMapping(value = "/emailForm/message_view",method = RequestMethod.GET)
    public ModelAndView CvTemplateRegisterView(){

        List<EmailMessage> emailMessages = emailMessageServices.findAllEmailMessage();
        ModelAndView modelAndView = new ModelAndView();
        //System.out.println(" application cv section ["+cvApplicationSection+"]");
        if (emailMessages!=null){
            modelAndView.setViewName("Email_Message_View");
            modelAndView.addObject("emailMessage",emailMessages);
        }
        else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }


    @RequestMapping(value="/sendEmail",method= RequestMethod.POST)
    public ModelAndView sendEmailUsingGmail(@ModelAttribute("email")EmailMessage email){


        logger.debug(" ********************* ready to send the email **********************");
        logger.debug(" receiver email address [{}]", email.getReceiverEmailAddress());
        logger.debug(" email subject [{}]", email.getSubject());
        logger.debug(" email body [{}]", email.getMessageBody());

        ModelAndView view=new ModelAndView("EmailView");

        view.addObject("emailAddress",email.getReceiverEmailAddress());
        emailSender.sendEmail(email);
        logger.debug(" ********************* email was sent **********************");

        return view;

    }


}
