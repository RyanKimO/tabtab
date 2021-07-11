package com.buta.tabtab_match

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@SpringBootApplication
class TabtabMatchApplication

fun main(args: Array<String>) {
    runApplication<TabtabMatchApplication>(*args)
}
