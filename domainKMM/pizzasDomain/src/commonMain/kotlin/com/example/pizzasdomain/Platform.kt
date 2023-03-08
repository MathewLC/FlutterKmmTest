package com.example.pizzasdomain

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform