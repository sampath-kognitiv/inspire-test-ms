package com.kognitiv.loyaltybank.controller


import com.kognitiv.loyaltybank.domain.Currency

import com.kognitiv.loyaltybank.service.CurrencyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CurrencyController {

    @Autowired
    CurrencyService currencyService

    @GetMapping("/currency")
    ResponseEntity<List<Currency>> currencyList() {
        return ResponseEntity.ok(currencyService.findAll())
    }

    @GetMapping("/currency/{id}")
    ResponseEntity<Currency> getCurrency(@PathVariable Long id) {
        return ResponseEntity.ok(currencyService.getCurrency(id))
    }

    @PostMapping(path = "/currency", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> postCurrency(@RequestBody(required = true) Currency currency) {
        Currency createdCurrency
        try {
            createdCurrency = currencyService.saveCurrency(currency)
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request!")
        }
        return ResponseEntity
                .created(URI.create("currency/" + createdCurrency.id))
                .body("""{"id":$createdCurrency.id}""" as String)
    }
}