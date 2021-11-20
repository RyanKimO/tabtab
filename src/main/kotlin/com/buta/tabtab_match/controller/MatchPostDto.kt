package com.buta.tabtab_match.controller

import io.swagger.annotations.ApiModelProperty
import java.math.BigDecimal
import java.time.LocalDateTime

data class MatchPostDto(
    var id: Long? = null,
    var userId: Long,
    val matchDatetime: LocalDateTime? = null,
    var matchYearMonth: Int? = null,
    var locationTitle: String? = null,
    var locationFull: String? = null,
    @ApiModelProperty("경도")
    var locationX: BigDecimal? = null, // 경도 longitude
    @ApiModelProperty("위도")
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

    @ApiModelProperty("응답용")
    var createdAt: LocalDateTime?,
    @ApiModelProperty("응답용")
    var updatedAt: LocalDateTime?,
    var isMe: Boolean,
)