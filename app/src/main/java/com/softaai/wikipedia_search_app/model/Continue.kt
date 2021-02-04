package com.softaai.wikipedia_search_app.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Continue(
    @Json(name = "continue")
    val continueX: String,
    @Json(name = "gpsoffset")
    val gpsoffset: Int
)