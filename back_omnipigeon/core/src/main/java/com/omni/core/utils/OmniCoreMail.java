/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.utils;


import com.omni.core.model.Mail;
import static com.omni.core.utils.OmniCoreUtils.getVelocityEngine;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.exception.ParseErrorException;

/**
 *
 * @author
 */
public class OmniCoreMail {

    private static final Logger logger = OmniCoreUtils.getLogger(OmniCoreMail.class);
    private static final String environnement = OmniCoreUtils.getValueFromPropertyCode("projectConfig");

    public static Message getMessageSession(Mail mail) throws UnsupportedEncodingException, MessagingException {
        final String frome = OmniCoreConstants.MAIL_COMPTE;
        final String password = OmniCoreConstants.KEY_EMAIL;
        //config
        String host = OmniCoreConstants.MAIL_SERVEUR;
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.socketFactory.port", "587");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.user", OmniCoreConstants.MAIL_MARQUE);

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(frome, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setSubject(MimeUtility.encodeText(mail.getSubject(), OmniCoreConstants.EMAIL_ENCODING, "Q"));
        message.setFrom(new InternetAddress(mail.getEmailFrom(), OmniCoreConstants.MAIL_MARQUE));
        message.setHeader("Content-Type", OmniCoreConstants.CHARSET_UTF8);
        message.setSentDate(new Date());

        return message;
    }

    /**
     * send mail
     *
     * @param mail
     * @throws java.lang.Exception
     */
    public static void sendMail(Mail mail) throws ParseErrorException, Exception {
        Message message = getMessageSession(mail);
        //TO
        if (mail.getEmailTo() != null && !OmniCoreConstants.EMPTY_STRING.equalsIgnoreCase(mail.getEmailTo().trim())) {
            String mailTo = mail.getEmailTo().trim();
            String[] mailTos;
            mailTos = mailTo.split(";");
            if (mailTos.length > 0) {
                for (String m : mailTos) {
                    if (OmniCoreUtils.isValidEmailAddress(m)) {
                        try {
                            InternetAddress to = new InternetAddress(m);
                            message.addRecipient(Message.RecipientType.TO, to);
                        } catch (MessagingException e) {
                            logger.error(e);
                        }
                    } else {
                        logger.info(m + " invalid mail adress.");
                    }
                }
            } else {
                InternetAddress to = new InternetAddress(mail.getEmailTo());
                message.addRecipient(Message.RecipientType.TO, to);
            }
        }
        //CC
        if (mail.getCc() != null && !OmniCoreConstants.EMPTY_STRING.equalsIgnoreCase(mail.getCc().trim())) {
            String ccs = mail.getCc().trim();
            String[] tabCcs;
            tabCcs = ccs.split(";");
            if (tabCcs.length > 0) {
                for (String c : tabCcs) {
                    if (OmniCoreUtils.isValidEmailAddress(c)) {
                        try {
                            InternetAddress cc = new InternetAddress(c);
                            message.addRecipient(Message.RecipientType.CC, cc);
                        } catch (MessagingException e) {
                            logger.error(e);
                        }
                    } else {
                        logger.info(c + " invalid mail adress.");
                    }
                }
            } else {
                InternetAddress cc = new InternetAddress(mail.getCc());
                message.addRecipient(Message.RecipientType.CC, cc);
            }
        }
        //CCI
        if (mail.getCci() != null && !OmniCoreConstants.EMPTY_STRING.equalsIgnoreCase(mail.getCci().trim())) {
            String ccis = mail.getCci().trim();
            String[] tabCCI;
            tabCCI = ccis.split(";");
            if (tabCCI.length > 0) {
                for (String cci : tabCCI) {
                    if (OmniCoreUtils.isValidEmailAddress(cci)) {
                        try {
                            InternetAddress cciIA = new InternetAddress(cci);
                            message.addRecipient(Message.RecipientType.BCC, cciIA);
                        } catch (MessagingException e) {
                            logger.error(e);
                        }
                    } else {
                        logger.info(cci + " invalid mail adress.");
                    }
                }
            } else {
                InternetAddress cci = new InternetAddress(mail.getCci());
                message.addRecipient(Message.RecipientType.BCC, cci);
            }
        }
        MimeBodyPart mbp1 = new MimeBodyPart();
        mbp1.setText(new String(mail.getBody().getBytes(OmniCoreConstants.EMAIL_ENCODING), OmniCoreConstants.EMAIL_ENCODING), OmniCoreConstants.EMAIL_ENCODING, "html");
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(mbp1);
        message.setContent(mp);
        Transport.send(message);
    }

    public static String getHeader(String subject, String titre, String sousTitre, String action, String urlToken) {
        Template t = getVelocityEngine().getTemplate("header.vm", "utf-8");
        VelocityContext context = new VelocityContext();
        context.put("subject", subject);
        context.put("titre", titre);
        context.put("sousTitre", sousTitre);
        context.put("action", action);
        context.put("urlToken", urlToken);
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        return writer.toString();

    }
    /**
     * Send mail To Destinataire
     *
     * @param mail
     * @param context
     */
    public static void sendMailToDest(Mail mail, VelocityContext context) {
        logger.debug("Début d'envoi de mail : " + mail.getEmailTo());

        try {
            Template t = getVelocityEngine().getTemplate("send_mail_to_client.vm");
            StringWriter writer = new StringWriter();
            t.merge(context, writer);
            mail.setBody(writer.toString());
            mail.setEmailFrom(OmniCoreConstants.MAIL_TEAM);
            if (environnement.equalsIgnoreCase("localhost") || environnement.equalsIgnoreCase("recette")) {
                mail.setEmailTo(OmniCoreConstants.MAIL_TEAM);
            } else {
                mail.setCci(OmniCoreConstants.MAIL_TEAM);
            }
            sendMail(mail);
        } catch (Exception ex) {
            logger.error(ex);
        }
        logger.debug("Fin d'envoi de mail : " + mail.getEmailTo());
    }
}
