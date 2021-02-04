package com.softaai.wikipedia_search_app.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Terms(
    @Json(name = "description")
    val description: List<String>
)