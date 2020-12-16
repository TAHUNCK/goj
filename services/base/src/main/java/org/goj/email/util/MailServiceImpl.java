package org.goj.email.util;

import org.goj.common.entity.base.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author CK
 * @date 2020/12/15 19:00
 */
@Service
public class MailServiceImpl implements MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Spring Boot 提供了一个发送邮件的简单抽象，使用的是下面这个接口，这里直接注入即可使用
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 配置文件中我的qq邮箱
     */
    private static final String FROM="1790286512@qq.com";

    /**
     * 简单文本邮件
     * @param email 邮件信息
     */
    @Override
    public void sendSimpleMail(Email email) {
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(FROM);
        //邮件接收人
        message.setTo(email.getTo());
        //邮件主题
        message.setSubject(email.getSubject());
        //邮件内容
        message.setText(email.getContent());
        //发送邮件
        mailSender.send(message);
    }

    /**
     * html邮件
     * @param email 邮件信息
     */
    @Override
    public void sendHtmlMail(Email email) {
        //获取MimeMessage对象
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message, true);
            //邮件发送人
            messageHelper.setFrom(FROM);
            //邮件接收人
            messageHelper.setTo(email.getTo());
            //邮件主题
            message.setSubject(email.getSubject());
            //邮件内容，html格式
            messageHelper.setText(email.getContent(), true);
            //发送
            mailSender.send(message);
            //日志信息
            logger.info("邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送邮件时发生异常！", e);
        }
    }

    /**
     * 带附件的邮件
     * @param email 邮件信息
     */
    @Override
    public void sendAttachmentsMail(Email email) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(FROM);
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getContent(), true);

            FileSystemResource file = new FileSystemResource(new File(email.getFilePath()));
            String fileName = email.getFilePath().substring(email.getFilePath().lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            //日志信息
            logger.info("邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送邮件时发生异常！", e);
        }


    }
}