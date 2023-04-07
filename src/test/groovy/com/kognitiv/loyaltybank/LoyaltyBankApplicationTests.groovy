package com.kognitiv.loyaltybank

import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureEmbeddedDatabase
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LoyaltyBankApplicationTests extends BaseIntegrationTest {

	@Autowired
	MockMvc mvc

	@Test
	void contextLoads() {

	}

	@Test
	void currencyListTest() {
		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/currency"))
				.andExpect (MockMvcResultMatchers.status().isOk()).andReturn()
		//non mvc inline equivalent check
		Assertions.assertThat(result).isNotNull()
		Assertions.assertThat(result.response.status).isEqualTo(200)
		Assertions.assertThat(objectMapper.readTree(result.response.contentAsString))
				.isEqualTo(objectMapper.readTree(readResourceText("/expected/currency/currency-list.json")))
	}

	@Test
	void getCurrencyTest() {
		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/currency/1"))
				.andExpect (MockMvcResultMatchers.status().isOk()).andReturn()
		//non mvc inline equivalent check
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result.response.status).isEqualTo(200)
		Assertions.assertThat(objectMapper.readTree(result.response.contentAsString)).isEqualTo(objectMapper.readTree(readResourceText("/expected/currency/bank-app.json")))
	}

}
