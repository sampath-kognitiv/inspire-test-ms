package com.kognitiv.loyaltybank

import com.github.tomakehurst.wiremock.WireMockServer
import com.kognitiv.loyaltybank.repository.CurrencyRepository
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Shared

class CurrencyIntegrationSpec extends BaseIntegrationTest {

    @Autowired
    CurrencyRepository currencyRepository

    @Shared
    WireMockServer wireMockServer = new WireMockServer(8080)

    def setupSpec() {
        wireMockServer.start()
    }

    def cleanupSpec() {
        wireMockServer.stop()
    }
    def "get currency by id"() {
        when:
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/currency/$id")).andReturn()

        then:
        Assertions.assertThat(result).isNotNull()
        Assertions.assertThat(result.response.status).isEqualTo(200)
        Assertions.assertThat(objectMapper.readTree(result.response.contentAsString))
                .isEqualTo(objectMapper.readTree(readResourceText(expected)))

        where:
        id | expected
        1  | "/expected/currency/air-miles.json"
        2  | "/expected/currency/gold.json"
        3  | "/expected/currency/swag.json"
    }

    def "currency post"() {
        when:
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/currency").content(body).contentType(MediaType.APPLICATION_JSON)).andReturn()

        then:
        Assertions.assertThat(result.response.status).isEqualTo(status)

        cleanup:
        currencyRepository.deleteById(4)

        where:
        body                                                                | status
        readResourceText("/sample-data/currency/valid-new-currency.json")   | 201
        readResourceText("/sample-data/currency/invalid-new-currency.json") | 400
    }

    def "get currency list"() {
        when:
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/currency")).andReturn()

        then:
        Assertions.assertThat(result.response.status).isEqualTo(200)
        Assertions.assertThat(objectMapper.readTree(result.response.contentAsString))
                .isEqualTo(objectMapper.readTree(readResourceText("/expected/currency/currency-list.json")))
    }
}
