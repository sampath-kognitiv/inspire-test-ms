package com.kognitiv.loyaltybank.config

import org.apache.hc.client5.http.classic.HttpClient
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HttpClientConfig {

    @Bean
    HttpClient httpClient() {
        return HttpClientBuilder
                .create()
                .setUserAgent("loyalty-bank")
                .build()
    }
}
