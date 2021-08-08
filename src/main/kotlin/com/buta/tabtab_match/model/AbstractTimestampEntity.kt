package com.buta.tabtab_match.model

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

@MappedSuperclass
abstract class AbstractTimestampEntity {

    @Column(name = "reg_ts", nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null

    @Column(name = "upd_ts", insertable = false)
    var updatedAt: LocalDateTime? = null

    @PrePersist
    protected fun onCreate() {
        createdAt = LocalDateTime.now()
    }

    @PreUpdate
    protected fun onUpdate() {
        updatedAt = LocalDateTime.now()
    }
}