package com.softaai.wikipedia_search_app.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class Page(
    @Json(name = "canonicalurl")
    val canonicalurl: String,
    @Json(name = "contentmodel")
    val contentmodel: String,
    @Json(name = "editurl")
    val editurl: String,
    @Json(name = "fullurl")
    val fullurl: String,
    @Json(name = "index")
    val index: Int,
    @Json(name = "lastrevid")
    val lastrevid: Int,
    @Json(name = "length")
    val length: Int,
    @Json(name = "ns")
    val ns: Int,
    @field:PrimaryKey
    @Json(name = "pageid")
    val pageid: Int,
    @Json(name = "pagelanguage")
    val pagelanguage: String,
    @Json(name = "pagelanguagedir")
    val pagelanguagedir: String,
    @Json(name = "pagelanguagehtmlcode")
    val pagelanguagehtmlcode: String,
    @Json(name = "terms")
    val terms: Terms,
    @Json(name = "thumbnail")
    val thumbnail: Thumbnail,
    @Json(name = "title")
    val title: String,
    @Json(name = "touched")
    val touched: String
)