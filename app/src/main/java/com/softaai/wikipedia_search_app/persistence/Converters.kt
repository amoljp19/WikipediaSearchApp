package com.softaai.wikipedia_search_app.persistence

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.softaai.wikipedia_search_app.model.Terms
import com.softaai.wikipedia_search_app.model.Thumbnail
import java.lang.reflect.Type

class Converters {

    @TypeConverter
    fun fromStringToTerms(value: String?): Terms? {
        val categoryType: Type = object : TypeToken<Terms>() {}.type
        return Gson().fromJson(value, categoryType)
    }

    @TypeConverter
    fun fromTermsToString(terms: Terms?): String {
        val gson = Gson()
        return gson.toJson(terms)
    }

    @TypeConverter
    fun fromStringToThumbnail(value: String?): Thumbnail{
        val idType: Type = object : TypeToken<Thumbnail>() {}.type
        return Gson().fromJson(value, idType)
    }

    @TypeConverter
    fun fromThumbnailToString(thumbnail: Thumbnail?): String {
        val gson = Gson()
        return gson.toJson(thumbnail)
    }
}