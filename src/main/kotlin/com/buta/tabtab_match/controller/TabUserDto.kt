package com.buta.tabtab_match.controller

import java.time.LocalDateTime

data class TabUserDto(

    var id: Long? = null,
    var name: String,
    var email: String,
    var phone: String?,
    var createdAt: LocalDateTime?,
    var updatedAt: LocalDateTime?
)