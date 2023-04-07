package com.kognitiv.loyaltybank.service


import com.kognitiv.loyaltybank.domain.Currency
import com.kognitiv.loyaltybank.repository.CurrencyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository

    List<Currency> findAll() {
        return currencyRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
    }

    Currency getCurrency(Long id) {
        currencyRepository.getReferenceById(id)
    }

    Currency saveCurrency(Currency currency) {
        return currencyRepository.save(currency)
    }
}
