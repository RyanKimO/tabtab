package com.buta.tabtab_match.controller

import java.time.LocalDateTime

data class TabTeamDto(

    var id: Long? = null,
    val name: String,
    var phone: String? = null,
    var ageRangeStart: Int? = null,
    var ageRangeEnd: Int? = null,
    var level: Int? = null,
    var profileImgUrl: String? = null,
    var intro: String? = null,
    var uniformTop: String? = null,
    var uniformBottom: String? = null,
    var masterId: Long,
    var createdAt: LocalDateTime?,
    var updatedAt: LocalDateTime?
)
