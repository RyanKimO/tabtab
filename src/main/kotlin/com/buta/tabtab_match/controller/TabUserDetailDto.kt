package com.buta.tabtab_match.controller

import java.time.Instant

data class TabUserDetailDto(
    var id: Long,
    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var displayName: String? = null,
    var displayPhone: String? = null,
    var ageRange: Int? = null,
    var skillLevel: Int? = null,
    val teamIds: String? = null,
    val profileImgUrl: String? = null,
    val introduction: String? = null,
    var createdAt: Instant? = null,
    var updatedAt: Instant? = null
)