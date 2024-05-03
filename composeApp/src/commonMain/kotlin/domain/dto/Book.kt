package domain.dto

import data.models.Item

data class Book (
    val id: String,
    val smallThumbnail: String,
    val thumbnail: String,
    val authors: List<String>,
    val canonicalVolumeLink: String,
    val description: String?,
    val language: String,
    val pageCount: Int,
    val title: String
)

fun Item.asBookDto(): Book{
    return Book(
        this.id,
        this.volumeInfo.imageLinks.smallThumbnail  + ".jpg",
        this.volumeInfo.imageLinks.thumbnail  + ".jpg",
        this.volumeInfo.authors,
        this.volumeInfo.canonicalVolumeLink,
        this.volumeInfo?.description,
        this.volumeInfo.language,
        this.volumeInfo.pageCount,
        this.volumeInfo.title
    )
}
