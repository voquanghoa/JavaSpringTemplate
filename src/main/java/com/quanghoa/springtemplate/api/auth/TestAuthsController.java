package com.quanghoa.springtemplate.api.auth;


import com.quanghoa.springtemplate.domain.auths.AuthsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.quanghoa.springtemplate.api.auth.UserProfileDTOMapper.toUserProfileDTO;

@RestController
@RequestMapping("api/v1/test-auths")
@RequiredArgsConstructor
public class TestAuthsController {

    private final AuthsProvider authsProvider;

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("users")
    public UserProfileDTO testUser() {
        return toUserProfileDTO(authsProvider.getCurrentAuthentication());
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("admin")
    public UserProfileDTO testAdmin() {
        return toUserProfileDTO(authsProvider.getCurrentAuthentication());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("all")
    public UserProfileDTO testAll() {
        return toUserProfileDTO(authsProvider.getCurrentAuthentication());
    }
}
