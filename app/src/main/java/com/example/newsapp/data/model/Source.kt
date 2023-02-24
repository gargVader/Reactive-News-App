package com.example.newsapp.data.model

import com.squareup.moshi.Json

data class Source(
    @field:Json(name = "name")
    val source_name: String?,
)