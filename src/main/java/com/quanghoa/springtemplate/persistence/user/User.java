package com.quanghoa.springtemplate.persistence.user;


import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class User {

    private UUID id;
    private String username;
    private String password;
    private UUID roleId;
}
