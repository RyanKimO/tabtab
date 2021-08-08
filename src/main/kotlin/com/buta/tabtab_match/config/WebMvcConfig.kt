package com.buta.tabtab_match.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.time.LocalDateTime
import java.util.*


@Configuration
@EnableWebMvc
class WebMvcConfig : WebMvcConfigurer {

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(
            MappingJackson2HttpMessageConverter(
                ObjectMapperFactory.create()
                    .copy()
                    .registerModule(
                        object : SimpleModule() {
                            init {
                                addSerializer(LocalDateTime::class.java, ToStringJsonSerializer())
                            }
                        }
                    )
            )
        )
        super.configureMessageConverters(converters)
    }
}

object ObjectMapperFactory {

    fun create(vararg modules: Module): ObjectMapper = jacksonObjectMapper()
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true)
        .registerModule(JavaTimeModule())
        .registerModule(ParameterNamesModule())
        .registerModule(Jdk8Module())
        .registerModule(KotlinModule())
        .apply { modules.forEach(this::registerModule) }
        .setTimeZone(TimeZone.getTimeZone("Asia/Seoul"))
}

class ToStringJsonSerializer<T> : JsonSerializer<T>() {
    override fun serialize(value: T, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString("$value")
    }
}