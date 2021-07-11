package com.buta.tabtab_match.controller

import com.buta.tabtab_match.model.TabUser
import com.buta.tabtab_match.model.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/tabtab/user")
class UserController(
    private val repository: UserRepository
) {
    @GetMapping("/{id}")
    fun getUser(
        @PathVariable id: Long,
    ): TabUser {
        return repository.findById(id).get()
    }
}