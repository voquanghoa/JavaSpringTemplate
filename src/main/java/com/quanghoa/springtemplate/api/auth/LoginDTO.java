package com.quanghoa.springtemplate.api.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class LoginDTO {

    private String username;
    private String password;
}
