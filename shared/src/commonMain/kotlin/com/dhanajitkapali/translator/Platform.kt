package com.dhanajitkapali.translator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform