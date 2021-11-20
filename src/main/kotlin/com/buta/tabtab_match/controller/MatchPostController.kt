package com.buta.tabtab_match.controller

import com.buta.tabtab_match.model.MatchPost
import com.buta.tabtab_match.model.MatchPostRepository
import com.buta.tabtab_match.utils.ApiResponse
import com.buta.tabtab_match.utils.TAB_USER_HEADER
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
        @RequestHeader(TAB_USER_HEADER) uid: Long,
        @RequestBody dto: MatchPostDto
    ): ApiResponse<MatchPostDto> {
        val saved = repository.save(toMatchPostEntity(dto))
        return ApiResponse.success(toMatchPostDto(saved, uid))
    }

    @ApiOperation("게시글 id 단위 조회(상세)")
    @GetMapping("/{id}")
    fun getMatchPostById(
        @RequestHeader(TAB_USER_HEADER) uid: Long,
        @PathVariable id: Long,
    ): ApiResponse<MatchPostDto> {
        val post = repository.findById(id).get()
        return ApiResponse.success(toMatchPostDto(post, uid))
    }

    @ApiOperation("게시글 월단위 조회")
    @GetMapping("/monthly")
    fun getMatchPostMonthly(
        @RequestHeader(TAB_USER_HEADER) uid: Long = -1,
        @RequestParam yyyyMM: Int,
    ): ApiResponse<List<MatchPostDto>> {
        val posts = repository.findByMatchYearMonth(yyyyMM)
        return ApiResponse.success(posts.map { toMatchPostDto(it, uid) })
    }

    @ApiOperation("게시글 유저단위 조회")
    @GetMapping("/user/{uid}")
    fun getMatchPostByUser(
        @PathVariable uid: Long,
    ): ApiResponse<List<MatchPostDto>> {
        val posts = repository.findByUserId(uid)
        return ApiResponse.success(posts.map { toMatchPostDto(it, uid) })
    }

    @ApiOperation("게시글 삭제")
    @DeleteMapping("/{postId}")
    fun deleteMatchPost(
        @RequestHeader(TAB_USER_HEADER) uid: Long,
        @PathVariable postId: Long,
    ): ApiResponse<Boolean> {
        repository.deleteById(postId)
        return ApiResponse.success(true)
    }

    private fun toMatchPostEntity(dto: MatchPostDto) = MatchPost(
        userId = dto.userId,
        matchDatetime = dto.matchDatetime,
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
        userId: Long
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
        updatedAt = entity.updatedAt,
        isMe = entity.userId == userId
    )
}