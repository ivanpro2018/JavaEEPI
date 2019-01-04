package tn.uniteam.services.analytics;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.Repport;

/**
 * Session Bean implementation class RepportManagement
 */
@Stateless
@LocalBean
public class RepportManagement implements RepportManagementRemote, RepportManagementLocal {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public RepportManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void sendReport(Repport r) {
		// TODO Auto-generated method stub
		r.setRepportDate(new Date());
		em.persist(r);
	}

	@Override
	public List<Repport> getAllSentReports(AspNetUser doctor) {
		// TODO Auto-generated method stub
		String req = "select r from Repport r where r.aspNetUser =:id";
		Query query = em.createQuery(req).setParameter("id", doctor);
		return query.getResultList();
	}

	@Override
	public List<Repport> getAllReceivedReports(AspNetUser doctor) {
		// TODO Auto-generated method stub
		String req = "select r from Repport r, AspNetUser a "
				+ "where a.id =:id and r.referentDoctor =:name";
		Query query = em.createQuery(req).setParameter("id", doctor.getId()).setParameter("name", doctor.getFirstName() + " " + doctor.getLastName());
		return query.getResultList();
	}
	
	@Override
	public void sendMail(String fromMail,String username,String password,
            String toMail,String subject,String message){
    
        Properties props=System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        
        
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.socketFactory.port", "587");
                props.put("mail.smtp.socketFactory.fallback", "false");
                
                Session mailSession=Session.getDefaultInstance(props, null);
                mailSession.setDebug(true);
                
                Message mailMessage=new MimeMessage(mailSession);
                
                try {
					mailMessage.setFrom(new InternetAddress(fromMail));
	                mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
	                mailMessage.setContent(message,"text/html");
	                mailMessage.setSubject(subject);
	                
	                Transport transport=mailSession.getTransport("smtp");
	                transport.connect("smtp.gmail.com", username, password);
	                transport.sendMessage(mailMessage, mailMessage.getAllRecipients()); 
	                System.out.println("Email envoyé !");
	                
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
    }

}
