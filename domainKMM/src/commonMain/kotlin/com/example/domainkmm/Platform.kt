package com.example.domainkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform