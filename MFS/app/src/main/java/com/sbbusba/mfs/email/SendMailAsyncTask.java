package com.sbbusba.mfs.email;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailAsyncTask extends AsyncTask<EmailDTO, Void, Void> {

    @Override
    protected Void doInBackground(EmailDTO... emailDTOS) {
        FirebaseFirestore mDatabase =  FirebaseFirestore.getInstance();
        final List<EmailPropertiesDTO> emailPropertiesDTOs = new ArrayList<>();
        EmailPropertiesDTO emailPropertiesDTO = null;
        try {
            FirebaseFirestore.getInstance()
                    .collection("properties")
                    .document("emailProperties")
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot queryDocumentSnapshots) {
                            if(queryDocumentSnapshots!=null){
                                EmailPropertiesDTO  emailPropertiesDTO = queryDocumentSnapshots.toObject(EmailPropertiesDTO.class);

                              new Thread(){
                                  @Override
                                  public void run() {
                                      sendEmails(emailPropertiesDTO, emailDTOS);
                                  }
                              }.start();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    });

            } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void sendEmails(EmailPropertiesDTO emailPropertiesDTO, EmailDTO... emailDTOS) {
        EmailDTO emailDTO = emailDTOS[0];
        sendEmailConsumer(emailPropertiesDTO, emailDTO.clone());
        sendEmailStoreTeam(emailPropertiesDTO, emailDTO.clone());


    }

    private void sendEmailConsumer(EmailPropertiesDTO emailPropertiesDTO, EmailDTO emailDTO) {
        try {
            FirebaseFirestore.getInstance()
                    .collection("properties")
                    .document("emailConsumerTemplateOrder"+ emailDTO.getOrderStatus())
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot queryDocumentSnapshots) {
                            if(queryDocumentSnapshots!=null){
                                EmailTemplateDTO emailTemplateDTO = queryDocumentSnapshots.toObject(EmailTemplateDTO.class);
                                String subject = emailTemplateDTO.getSubject();
                                subject = format(subject, emailDTO.getOrderNumber());
                                String body = emailTemplateDTO.getBody();
                                    if("Pending".equalsIgnoreCase(emailDTO.getOrderStatus())){
                                        body = format(body, emailDTO.getFullName(), emailDTO.getOrderNumber(), emailDTO.getOrderComment());
                                    }else{
                                        body = format(body, emailDTO.getFullName(), emailDTO.getOrderNumber());
                                    }
                                emailTemplateDTO.setSubject(subject);
                                emailTemplateDTO.setBody(body);
                                new Thread(){
                                    @Override
                                    public void run() {
                                        sendEmail(emailPropertiesDTO,emailTemplateDTO, emailDTO);
                                    }
                                }.start();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void sendEmailStoreTeam(EmailPropertiesDTO emailPropertiesDTO, EmailDTO emailDTO) {
        try {
            FirebaseFirestore.getInstance()
                    .collection("properties")
                    .document("emailStoreTeamTemplateOrder"+ emailDTO.getOrderStatus())
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot queryDocumentSnapshots) {
                            if(queryDocumentSnapshots!=null){
                                EmailTemplateDTO emailTemplateDTO = queryDocumentSnapshots.toObject(EmailTemplateDTO.class);
                                String subject = emailTemplateDTO.getSubject();
                                subject = format(subject, emailDTO.getOrderNumber());
                                String body = emailTemplateDTO.getBody();
                                emailPropertiesDTO.setAdminAddress(emailPropertiesDTO.getAdminAddress()!=null?emailPropertiesDTO.getAdminAddress():emailPropertiesDTO.getFromAddress());
                                emailPropertiesDTO.setAdminName(emailPropertiesDTO.getAdminName()!=null?emailPropertiesDTO.getAdminName():emailPropertiesDTO.getFromName());
                                emailDTO.setTo(emailPropertiesDTO.getAdminAddress());
                                if("Cancelled".equalsIgnoreCase(emailDTO.getOrderStatus())){
                                    body = format(body,  emailDTO.getOrderNumber(), emailDTO.getOrderComment(),emailDTO.getFullName());
                                }else{
                                    body = format(body, emailDTO.getOrderNumber(),emailDTO.getFullName());
                                }
                                emailTemplateDTO.setSubject(subject);
                                emailTemplateDTO.setBody(body);

                                new Thread(){
                                    @Override
                                    public void run() {
                                        sendEmail(emailPropertiesDTO,emailTemplateDTO, emailDTO);
                                    }
                                }.start();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void sendEmail(EmailPropertiesDTO emailPropertiesDTO,EmailTemplateDTO emailTemplateDTO, EmailDTO emailDTO){
        try{
            final String username = emailPropertiesDTO.getFromAddress();
            final String password = emailPropertiesDTO.getPassword();
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS
            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            Message message = new MimeMessage(session);
            InternetAddress  fromEmailAddress = new InternetAddress(username);
            fromEmailAddress.setPersonal(emailPropertiesDTO.getFromName());
            message.setFrom(fromEmailAddress);
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailDTO.getTo())
            );
            message.setSubject(emailTemplateDTO.getSubject());
          //  message.setText(emailTemplateDTO.getBody());
            message.setContent(emailTemplateDTO.getBody(),"text/html");
            Transport.send(message);
            System.out.println("email is sent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String format(String s, Object... var2) {
        int i = 0;
        while (s.contains("{}")) {
            s = s.replaceFirst(Pattern.quote("{}"), "{" + i++ + "}");
        }
        return MessageFormat.format(s, var2);
    }
}
