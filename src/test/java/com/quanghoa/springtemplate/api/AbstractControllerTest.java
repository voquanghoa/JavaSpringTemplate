package com.quanghoa.springtemplate.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@AutoConfigureMockMvc
@ActiveProfiles("TEST")
public abstract class AbstractControllerTest {

    @Autowired
    private MockMvc mvc;

    protected ResultActions get(final String path) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.get(path));
    }
}
