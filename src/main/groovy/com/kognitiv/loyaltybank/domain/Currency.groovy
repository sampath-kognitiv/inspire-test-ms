package com.kognitiv.loyaltybank.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.NoArgsConstructor

@Entity
@Table(name = "currency")
@NoArgsConstructor
@JsonIgnoreProperties(["hibernateLazyInitializer", "handler","activations"])
class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id

    String name

    @Column(name = "short_name")
    String shortName

    @Column(name = "ext")
     Boolean external
}
