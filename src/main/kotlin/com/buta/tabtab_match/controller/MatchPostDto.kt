package com.buta.tabtab_match.controller

import java.math.BigDecimal
import java.time.LocalDateTime

data class MatchPostDto(
    var id: Long? = null,
    var userId: Long,
    val matchDatetime: LocalDateTime? = null,
    var matchYearMonth: Int? = null,
    var locationTitle: String? = null,
    var locationFull: String? = null,
    var locationX: BigDecimal? = null, // 경도 longitude
    var locationY: BigDecimal? = null, // 위도 lat
    var playerCnt: Int? = null,
    var playerGender: String? = null,
    var shoesType: String? = null,
    var playFee: Int? = null,
    var uniformTop: String? = null,
    var uniformBottom: String? = null,
    var teamName: String? = null,
    var phone: String? = null,
    var ageRangeStart: Int? = null,
    var ageRangeEnd: Int? = null,
    var skillLevel: Int? = null,
    var description: String? = null,
    var createdAt: LocalDateTime?,
    var updatedAt: LocalDateTime?,
    var isMe: Boolean,
)