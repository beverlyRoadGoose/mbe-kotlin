package me.tobiadeyinka.movies

import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}