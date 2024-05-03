package data.models

import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    @SerializedName("authors")
    val authors: List<String>,
    @SerializedName("canonicalVolumeLink")
    val canonicalVolumeLink: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks,
    @SerializedName("language")
    val language: String,
    @SerializedName("pageCount")
    val pageCount: Int,
    @SerializedName("title")
    val title: String
)
