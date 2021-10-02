package com.buta.tabtab_match.controller

import com.buta.tabtab_match.model.TabUser
import com.buta.tabtab_match.model.TabUserDetails
import com.buta.tabtab_match.model.UserDetailsRepository
import com.buta.tabtab_match.model.UserRepository
import com.buta.tabtab_match.utils.ApiResponse
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/tabtab/user")
class UserController(
    private val repository: UserRepository,
    private val detailsRepository: UserDetailsRepository
) {
    @ApiOperation("회원가입")
    @PostMapping(path = ["/add"], headers = ["secret"])
    fun saveUser(
        @RequestBody dto: TabUserDto,
        @RequestHeader secret: String = "empty",
    ): ApiResponse<TabUserDto> {
        val saved = repository.save(
            TabUser(
                id = dto.id,
                name = dto.name,
                email = dto.email,
                phone = dto.phone,
                secret = secret
            )
        )
        return ApiResponse.success(tabUserDto(saved))
    }

    @ApiOperation("회원 상세정보 조회")
    @GetMapping("/{id}")
    fun getUserDetails(
        @PathVariable id: Long,
    ): ApiResponse<TabUserDetailDto> {
        val entity = repository.findById(id).get()
        return ApiResponse.success(tabUserDetailDto(entity))
    }

    @ApiOperation("회원 상세정보 저장/수정")
    @PostMapping(headers = ["secret"])
    fun saveUserDetails(
        @RequestBody dto: TabUserDetailDto,
    ): ApiResponse<TabUserDetailDto> {
        val entity = repository.findById(dto.id).get()

        val saveTarget = entity.details?.let {
            it.userId = it.userId
            it.ageRange = dto.ageRange ?: it.ageRange
            it.displayName = dto.displayName ?: it.displayName
            it.displayPhone = dto.displayPhone ?: it.displayPhone
            it.skillLevel = dto.skillLevel ?: it.skillLevel
            it.teamIds = dto.teamIds ?: it.teamIds
            it.profileImgUrl = dto.profileImgUrl ?: it.profileImgUrl
            it.introduction = dto.introduction ?: it.introduction
            it
        } ?: TabUserDetails(
            userId = entity.id,
            ageRange = dto.ageRange,
            displayName = dto.displayName,
            displayPhone = dto.displayPhone,
            skillLevel = dto.skillLevel,
            teamIds = dto.teamIds,
            profileImgUrl = dto.profileImgUrl,
            introduction = dto.introduction,
            tabUser = entity
        )
        entity.details = saveTarget
        repository.save(entity)

        return ApiResponse.success(tabUserDetailDto(entity))
    }

    private fun tabUserDetailDto(
        entity: TabUser,
    ) = TabUserDetailDto(
        id = entity.id!!,
        name = entity.name,
        email = entity.email,
        phone = entity.phone,
        ageRange = entity.details?.ageRange,
        displayName = entity.details?.displayName,
        displayPhone = entity.details?.displayPhone,
        skillLevel = entity.details?.skillLevel,
        teamIds = entity.details?.teamIds,
        profileImgUrl = entity.details?.profileImgUrl,
        introduction = entity.details?.introduction,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt
    )

    private fun tabUserDto(entity: TabUser) = TabUserDto(
        id = entity.id,
        name = entity.name,
        email = entity.email,
        phone = entity.phone,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt
    )
}