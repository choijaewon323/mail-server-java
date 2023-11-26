package com.darkknight.mailserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailDto {
    private String email;
    private String content;

    public MailDto(String email, String content) {
        this.email = email;
        this.content = content;
    }
}
