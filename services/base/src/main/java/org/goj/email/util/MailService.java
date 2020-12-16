package org.goj.email.util;

import org.goj.common.entity.base.Email;

/**
 * @author CK
 * @date 2020/12/15 18:59
 */
public interface MailService {

    /**
     * 发送文本邮件
     * @param email 邮件信息
     */
    void sendSimpleMail(Email email);

    /**
     * 发送HTML邮件
     * @param email 邮件信息
     */
    void sendHtmlMail(Email email);


    /**
     * 发送带附件的邮件
     * @param email 邮件信息
     */
    void sendAttachmentsMail(Email email);

}
