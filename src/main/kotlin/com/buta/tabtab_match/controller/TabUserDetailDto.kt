package com.buta.tabtab_match.controller

import io.swagger.annotations.ApiModelProperty

data class TabUserDetailDto(
    @ApiModelProperty("유저 id")
    var id: Long,

    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var displayName: String? = null,
    var displayPhone: String? = null,
    var ageRange: Int? = null,
    var skillLevel: Int? = null,

    @ApiModelProperty("팀생성시 세팅")
    val teamIds: String? = null,

    val profileImgUrl: String? = null,
    val introduction: String? = null,
)