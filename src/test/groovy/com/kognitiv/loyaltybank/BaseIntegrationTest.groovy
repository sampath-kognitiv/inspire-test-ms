package com.kognitiv.loyaltybank

import com.fasterxml.jackson.databind.ObjectMapper
import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureEmbeddedDatabase
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BaseIntegrationTest extends BaseSpockSpec {

    @Autowired
    public MockMvc mvc

    @Autowired
    ObjectMapper objectMapper

    def setup() {
        //do common setup tasks here
        //insert dummy data, configure objects etc
    }
}
