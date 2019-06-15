package my.com.maybank.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class EmailTriggerApplication implements CommandLineRunner {

    @Autowired
    public JavaMailSender mailSender;

    public void run(String... args) throws Exception {
        SimpleMailMessage simpleEmail = new SimpleMailMessage();
        simpleEmail.setTo("sreedhar.manam@gmail.com");
        simpleEmail.setSubject("SpringBoot Sample Message");
        simpleEmail.setText("This email is generated from Springboot");
        mailSender.send(simpleEmail);
        System.out.println("Email has been sent");
    }

    public static void main(String[] args) {
        SpringApplication.run(EmailTriggerApplication.class, args);
    }
}