/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mails;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import java.security.InvalidParameterException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author sebas
 */

public class EnviarCorreos {
  public static BodyPart texto = new MimeBodyPart();  
  public static Properties props = System.getProperties();
  public static Session session = Session.getDefaultInstance(props);
  public static MimeMessage message = new MimeMessage(session);
  public static MimeMultipart multiParte = new MimeMultipart();
    public void enviarCorreos (String cuerpo, String asunto, String destinatario) throws MessagingException{
    
       Correo correo = new Correo("ucrinforma7@gmail.com","Ucr.informa.7");
       
        
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", correo.getRemitente());
        props.put("mail.smtp.clave", correo.getClave());
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        
        
        
        new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(correo.getRemitente(), correo.getClave());
      }
  };
        try {
        message.setFrom(new InternetAddress(correo.getRemitente()));
        message.addRecipients(Message.RecipientType.TO,destinatario);   //Se podrían añadir varios de la misma manera
        message.setSubject(asunto);
        message.setText(cuerpo);
        // Se mete el texto y la foto adjunta.
        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource("src/images/LogoUCR.png")));
        adjunto.setFileName("LogoUCR.png");

        

       

        multiParte.addBodyPart(texto);
        multiParte.addBodyPart(adjunto);
        message.setContent(multiParte);

            Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", correo.getRemitente(), correo.getClave());
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    catch (MessagingException me) {
        me.printStackTrace();   //Si se produce un error
    }
        
    }
}

  
  
  

