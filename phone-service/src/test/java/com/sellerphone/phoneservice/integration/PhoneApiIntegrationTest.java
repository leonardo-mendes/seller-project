package com.sellerphone.phoneservice.integration;

import com.sellerphone.phoneservice.PhoneServiceApplication;
import com.sellerphone.phoneservice.model.PhoneEntity;
import com.sellerphone.phoneservice.repository.PhoneRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = PhoneServiceApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class PhoneApiIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PhoneRepository phoneRepository;

    @After
    public void resetDb() {
        phoneRepository.deleteAll();
    }

    @Test
    public void whenSave_thenCreateProduct() throws Exception {
        createPhone();
        mvc.perform(get("/phones"))
                .andExpect(status().isOk());

    }


    private PhoneEntity createPhone() {
        return phoneRepository.save(
                PhoneEntity.builder()
                        .brand("Samsung")
                        .cost(2000.0)
                        .model("s7")
                        .build()
        );
    }

}
