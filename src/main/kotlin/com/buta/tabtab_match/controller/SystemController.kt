package com.buta.tabtab_match.controller

import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SystemController {

    @ApiOperation("health-check")
    @GetMapping("/health")
    fun health(): Boolean {
        return true
    }
}