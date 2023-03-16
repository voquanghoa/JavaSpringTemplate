package com.quanghoa.springtemplate.api.auth;

import com.quanghoa.springtemplate.api.AbstractControllerTest;
import com.quanghoa.springtemplate.api.WithMockAdmin;
import com.quanghoa.springtemplate.api.WithMockUser;
import com.quanghoa.springtemplate.domain.auths.AuthsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TestAuthsController.class)
@ExtendWith(SpringExtension.class)
class TestAuthsControllerTest extends AbstractControllerTest {

    private static final String BASE_URL = "/api/v1/test-auths";

    @MockBean
    private AuthsProvider authsProvider;

    @BeforeEach
    void init() {
        when(authsProvider.getCurrentAuthentication())
                .thenCallRealMethod();
    }

    @Test
    @WithMockUser
    void shouldTestUser_OK() throws Exception {
        get(BASE_URL + "/users")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user"))
                .andExpect(jsonPath("$.role").value("ROLE_USER"));
    }

    @Test
    @WithMockAdmin
    void shouldTestAdmin_OK() throws Exception {
        get(BASE_URL + "/admin")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("admin"))
                .andExpect(jsonPath("$.role").value("ROLE_ADMIN"));
    }

    @Test
    @WithMockUser
    void shouldTestAll_User_OK() throws Exception {
        get(BASE_URL + "/all")
                .andExpect(status().isOk());
    }

    @Test
    @WithMockAdmin
    void shouldTestAll_Admin_OK() throws Exception {
        get(BASE_URL + "/all")
                .andExpect(status().isOk());
    }
}