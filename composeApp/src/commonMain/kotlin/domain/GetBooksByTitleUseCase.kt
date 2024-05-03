package domain

import data.repository.BooksRepository
import domain.dto.Book
import domain.dto.asBookDto

class GetBooksByTitleUseCase (
    private val booksRepository: BooksRepository
) {
    suspend fun getBooksByTitle(input: String): List<Book>{
        val books: MutableList<Book> = mutableListOf()
        booksRepository.getBooksByTitle(input).forEach {
            books.add(it.asBookDto())
        }
        println("Title " + books.size)
        return books
    }
}
