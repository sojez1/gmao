package com.jpstechno.gmao.gmaoback.testControlleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WithMockUser(username = "sojez", password = "123456")
public abstract class CommonControlleurTestConfig {

    @Autowired
    protected MockMvc mockMvc;

}
