/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author damien
 */
public class MailServiceIOImpl implements MailServiceIO{

    private static String HOST = "smtp.gmail.com";
    private static String USER = "securisation.site.gvi@gmail.com";
    private static String PASSWORD = "securisation";
    private static String PORT = "465";
    private static String FROM = "securisation.site.gvi@gmail.com";
    private static String TO = "ches.damien@gmail.com";

    private static String STARTTLS = "true";
    private static String AUTH = "true";
    private static String DEBUG = "true";
    private static String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static String OBJET = "Un nouvel evenement viens d'étre crée";
    private static String CONTENU = "Sécurisation site GVI \n\n Un nouvel evenement à été crée, connectez-vous pour en savoir plus. ";
    @Override
    public boolean envoyer(String email, String contenu, String objet) {
        boolean ret = false;
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.user", USER);
        props.put("mail.smtp.auth", AUTH);
        props.put("mail.smtp.starttls.enable", STARTTLS);
        props.put("mail.smtp.debug", DEBUG);
        props.put("mail.smtp.socketFactory.port", PORT);
        props.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        try {
            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setText(contenu);
            message.setSubject(objet);
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(RecipientType.TO, new InternetAddress(email));
            message.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
    
}
