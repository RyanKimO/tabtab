package com.buta.tabtab_match.controller

import com.buta.tabtab_match.model.TabTeam
import com.buta.tabtab_match.model.TabTeamRepository
import com.buta.tabtab_match.utils.ApiResponse
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/tabtab/team")
class TeamController(
    private val repository: TabTeamRepository
) {
    @ApiOperation("팀 저장")
    @PostMapping(headers = ["secret"])
    fun saveTeam(
        @RequestBody dto: TabTeamDto,
        @RequestHeader secret: String = "empty",
    ): ApiResponse<TabTeamDto> {
        val saved = repository.save(
            TabTeam(
                id = dto.id,
                name = dto.name,
                phone = dto.phone,
                ageRangeStart = dto.ageRangeStart,
                ageRangeEnd = dto.ageRangeEnd,
                level = dto.level,
                profileImgUrl = dto.profileImgUrl,
                intro = dto.intro,
                uniformTop = dto.uniformTop,
                uniformBottom = dto.uniformBottom,
                masterId = dto.masterId
            )
        )
        return ApiResponse.success(tabTeamDto(saved))
    }

    @ApiOperation("팀 정보 조회")
    @GetMapping("/{masterId}")
    fun getUserDetails(
        @PathVariable masterId: Long,
    ): ApiResponse<List<TabTeamDto>> {
        val list = repository.findByMasterId(masterId)
        return ApiResponse.success(list.map { tabTeamDto(it) })
    }

    private fun tabTeamDto(entity: TabTeam) = TabTeamDto(
        id = entity.id,
        name = entity.name,
        phone = entity.phone,
        ageRangeStart = entity.ageRangeStart,
        ageRangeEnd = entity.ageRangeEnd,
        level = entity.level,
        profileImgUrl = entity.profileImgUrl,
        intro = entity.intro,
        uniformTop = entity.uniformTop,
        uniformBottom = entity.uniformBottom,
        masterId = entity.masterId,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt,
    )
}