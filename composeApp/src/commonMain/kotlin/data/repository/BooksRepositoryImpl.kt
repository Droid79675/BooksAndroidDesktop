package data.repository

import data.apiservice.BookService
import data.mappers.BookMapper
import data.models.Item

class BooksRepositoryImpl(
    private val bookService: BookService,
    private val bookMapper: BookMapper
): BooksRepository {
    override suspend fun getBooksByTitle(title: String): List<Item> {
        val dataModel = bookService.getBooksByTitle(title)
        return bookMapper.mapUniqueBooks(dataModel)
    }

    override suspend fun getBooksByAuthor(author: String): List<Item> {
        val dataModel = bookService.getBooksByAuthor(author)
        return bookMapper.mapUniqueBooks(dataModel)
    }

}
