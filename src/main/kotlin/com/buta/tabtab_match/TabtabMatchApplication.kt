package com.buta.tabtab_match

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDateTime
import java.util.*

@SpringBootApplication
class TabtabMatchApplication

fun main(args: Array<String>) {
    runApplication<TabtabMatchApplication>(*args)

    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
    println("íėŽėę°:${LocalDateTime.now()}")
}
