package com.studyKotlin.credit.application.system.domain.model

import com.studyKotlin.credit.application.system.domain.enumeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
data class Credit(
        @Column(nullable = false, unique = true)
        var creditCode: java.util.UUID = java.util.UUID.randomUUID(),
        @Column(nullable = false)
        val creditValue: BigDecimal = BigDecimal.ZERO,
        @Column(nullable = false)
        val dayFirstInstallment: LocalDate,
        @Column(nullable = false)
        val numberOfInstallment: Int = 0,
        @Enumerated
        var status: Status = Status.IN_PROGRESS,
        @ManyToOne
        var customer: Customer? = null,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
) {
}