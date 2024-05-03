package di

import data.apiservice.BookServiceImpl
import data.mappers.BookMapper
import data.repository.BooksRepositoryImpl
import domain.GetBooksByAuthorUseCase
import domain.GetBooksByTitleUseCase

object DataContainer {
    val bookServiceImpl = BookServiceImpl()
    val bookMapper = BookMapper()
    private val booksRepository = BooksRepositoryImpl(bookServiceImpl, bookMapper)

    val getBooksByTitleUseCase: GetBooksByTitleUseCase
        get() = GetBooksByTitleUseCase(booksRepository)
    val getBooksByAuthorUseCase: GetBooksByAuthorUseCase
        get() = GetBooksByAuthorUseCase(booksRepository)
}
