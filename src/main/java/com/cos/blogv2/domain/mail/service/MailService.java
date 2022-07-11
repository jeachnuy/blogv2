package com.cos.blogv2.domain.mail.service;

import com.cos.blogv2.constants.MAIL;
import com.cos.blogv2.domain.mail.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.server.ResponseStatusException;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class MailService {
    private final TemplateEngine engine;
    private final JavaMailSender sender;

    @Autowired
    public MailService(TemplateEngine engine, JavaMailSender sender) {
        this.engine = engine;
        this.sender = sender;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    public void send(Email email) {
        try {
            var message = sender.createMimeMessage();
            var helper = new MimeMessageHelper(message);
            helper.setTo(email.getDestination());
            helper.setSubject(email.getSubject());
            helper.setText(engine.process(email.getTemplate(), email.getContext()), MAIL.CONTENT_IS_HTML);
            sender.send(message);
            LOGGER.info(MAIL.EMAIL_SUCCESSFULLY_SENT_TO, email.getDestination());
        } catch (MessagingException | MailException exception) {
            LOGGER.error(MAIL.ERROR_SENDING_EMAIL_MESSAGE, exception);
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, MAIL.ERROR_SENDING_EMAIL_MESSAGE);
        }
    }
}
