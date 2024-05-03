package data.repository

import data.models.Item

interface BooksRepository {
    suspend fun getBooksByTitle(title: String): List<Item>
    suspend fun getBooksByAuthor(author: String): List<Item>
}
