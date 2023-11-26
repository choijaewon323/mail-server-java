package com.darkknight.mailserver.controller;

import com.darkknight.mailserver.dto.MailDto;
import com.darkknight.mailserver.util.MailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailApiController {
    private final MailSender mailSender;

    public MailApiController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping("/mailserver")
    public Integer send(@RequestBody MailDto mailDto) {
        return mailSender.send(mailDto);
    }
}
