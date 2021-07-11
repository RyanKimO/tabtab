package com.buta.tabtab_match.model

import java.time.Instant
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

@MappedSuperclass
abstract class AbstractTimestampEntity {

    @Column(name = "reg_ts", nullable = false, updatable = false)
    var createdAt: Instant? = null

    @Column(name = "upd_ts", insertable = false)
    var updatedAt: Instant? = null

    fun getRegTs() = createdAt?.toEpochMilli() ?: 0L
    fun getUpdTs() = updatedAt?.toEpochMilli() ?: 0L

    @PrePersist
    protected fun onCreate() {
        createdAt = Instant.now()
    }

    @PreUpdate
    protected fun onUpdate() {
        updatedAt = Instant.now()
    }
}