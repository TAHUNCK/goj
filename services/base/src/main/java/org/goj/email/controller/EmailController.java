package org.goj.email.controller;

import org.goj.common.entity.base.Email;
import org.goj.common.model.Result;
import org.goj.email.util.MailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CK
 * @date 2020/12/15 19:03
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Resource
    private MailService mailService;

    @PostMapping("/simpleEmail")
    public Result<String> sendSimpleEmail(@RequestBody Email email){
        mailService.sendSimpleMail(email);
        return Result.succeed("发送邮件成功！");
    }

}
