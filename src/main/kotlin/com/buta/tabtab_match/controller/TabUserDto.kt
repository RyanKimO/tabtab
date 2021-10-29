package com.buta.tabtab_match.controller

import io.swagger.annotations.ApiModelProperty
import java.time.LocalDateTime

data class TabUserDto(

    @ApiModelProperty("응답용")
    var id: Long? = null,
    var name: String,
    var email: String,
    var phone: String?,
    var secret: String,
    @ApiModelProperty("응답용")
    var createdAt: LocalDateTime?,
    @ApiModelProperty("응답용")
    var updatedAt: LocalDateTime?
)