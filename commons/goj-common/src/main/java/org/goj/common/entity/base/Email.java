package org.goj.common.entity.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author CK
 * @date 2020/12/15 19:04
 */
@Data
public class Email implements Serializable {

    /**
     * 收件人邮箱
     */
    private String to;

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 发件人
     */
    private String from;

    /**
     * 附件路径
     */
    private String filePath;

    /**
     * 附件名字
     */
    private String attachmentName;

    /**
     * 附件地址
     */
    private String attachmentPath;

}
