package com.buta.tabtab_match.controller

import com.buta.tabtab_match.model.MatchPost
import com.buta.tabtab_match.model.MatchPostRepository
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/tabtab/post")
class MatchPostController(
    private val repository: MatchPostRepository
) {
    @ApiOperation("글쓰기")
    @PostMapping
    fun saveMatchPost(
        @RequestBody dto: MatchPostDto
    ): MatchPostDto {
        val saved = repository.save(toMatchPostEntity(dto).apply {
            matchYearMonth = matchDatetime?.let { it.year * 100 + it.month.value }
        })
        return toMatchPostDto(saved)
    }

    @ApiOperation("게시글 월단위 조회")
    @GetMapping("/monthly")
    fun getMatchPostMonthly(
        @RequestParam yyyyMM: Int,
    ): List<MatchPostDto> {
        val posts = repository.findByMatchYearMonth(yyyyMM)
        return posts.map(::toMatchPostDto)
    }

    @ApiOperation("게시글 유저단위 조회")
    @GetMapping("/user/{userId}")
    fun getMatchPostByUser(
        @PathVariable userId: Long,
    ): List<MatchPostDto> {
        val posts = repository.findByUserId(userId)
        return posts.map(::toMatchPostDto)
    }

    @ApiOperation("게시글 삭제")
    @DeleteMapping("/{postId}")
    fun deleteMatchPost(
        @PathVariable postId: Long,
    ): Boolean {
        repository.deleteById(postId)
        return true
    }

    private fun toMatchPostEntity(dto: MatchPostDto) = MatchPost(
        userId = dto.userId,
        matchDatetime = dto.matchDatetime,
        matchYearMonth = dto.matchYearMonth,
        locationTitle = dto.locationTitle,
        locationFull = dto.locationFull,
        locationX = dto.locationX,
        locationY = dto.locationY,
        playerCnt = dto.playerCnt,
        playerGender = dto.playerGender,
        shoesType = dto.shoesType,
        playFee = dto.playFee,
        uniformTop = dto.uniformTop,
        uniformBottom = dto.uniformBottom,
        teamName = dto.teamName,
        phone = dto.phone,
        ageRangeStart = dto.ageRangeStart,
        ageRangeEnd = dto.ageRangeEnd,
        skillLevel = dto.skillLevel,
        description = dto.description
    )

    private fun toMatchPostDto(
        entity: MatchPost,
    ) = MatchPostDto(
        id = entity.id!!,
        userId = entity.userId,
        matchDatetime = entity.matchDatetime,
        matchYearMonth = entity.matchYearMonth,
        locationTitle = entity.locationTitle,
        locationFull = entity.locationFull,
        locationX = entity.locationX,
        locationY = entity.locationY,
        playerCnt = entity.playerCnt,
        playerGender = entity.playerGender,
        shoesType = entity.shoesType,
        playFee = entity.playFee,
        uniformTop = entity.uniformTop,
        uniformBottom = entity.uniformBottom,
        teamName = entity.teamName,
        phone = entity.phone,
        ageRangeStart = entity.ageRangeStart,
        ageRangeEnd = entity.ageRangeEnd,
        skillLevel = entity.skillLevel,
        description = entity.description,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt
    )
}