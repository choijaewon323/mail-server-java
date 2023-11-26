package com.darkknight.mailserver.util;

import com.darkknight.mailserver.dto.MailDto;
import com.darkknight.mailserver.security.SenderInfo;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Component
public class MailSender {
    private final Integer SUCCESS = 1;
    private final Integer FAIL = 0;

    private final String user;
    private final String password;
    private final String mockSender;

    public MailSender() {
        user = SenderInfo.getUser();
        password = SenderInfo.getPassword();
        mockSender = SenderInfo.getMockSender();
    }

    public Integer send(MailDto mailDto) {
        String email = mailDto.getEmail();
        String content = mailDto.getContent();

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 465);
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(user, mockSender, "UTF-8"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            message.setSubject("항공편 취소표 알림");
            message.setText(content);

            Transport.send(message);

            return SUCCESS;
        } catch (AddressException e) {
            e.printStackTrace();

            return FAIL;
        } catch (MessagingException e) {
            e.printStackTrace();

            return FAIL;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

            return FAIL;
        }
    }
}
