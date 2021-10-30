package com.buta.tabtab_match.controller

import io.swagger.annotations.ApiModelProperty

data class TabUserDto(

    @ApiModelProperty("응답용")
    var id: Long? = null,

    var name: String,
    var email: String,
    var phone: String?,
)