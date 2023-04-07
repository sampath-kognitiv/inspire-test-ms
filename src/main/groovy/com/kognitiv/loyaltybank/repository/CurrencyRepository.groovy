package com.kognitiv.loyaltybank.repository


import com.kognitiv.loyaltybank.domain.Currency
import org.springframework.data.jpa.repository.JpaRepository

interface CurrencyRepository extends JpaRepository<Currency, Long> {

}