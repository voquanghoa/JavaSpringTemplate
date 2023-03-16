package com.quanghoa.springtemplate.api.auth;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class JwtTokenResponseDTO {

    private final String token;
}
