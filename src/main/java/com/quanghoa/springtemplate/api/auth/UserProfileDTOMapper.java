package com.quanghoa.springtemplate.api.auth;


import com.quanghoa.springtemplate.domain.auths.UserAuthenticationToken;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserProfileDTOMapper {

    public static UserProfileDTO toUserProfileDTO(final UserAuthenticationToken userAuthenticationToken) {
        return UserProfileDTO.builder()
                .userId(userAuthenticationToken.getUserId())
                .username(userAuthenticationToken.getUsername())
                .role(userAuthenticationToken.getRole())
                .build();
    }
}
