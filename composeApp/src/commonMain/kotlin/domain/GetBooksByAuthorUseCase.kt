package domain

import data.repository.BooksRepository
import domain.dto.Book
import domain.dto.asBookDto

class GetBooksByAuthorUseCase (
    private val booksRepository: BooksRepository
) {
    suspend fun getBooksByAuthor(input: String): List<Book>{
        val books: MutableList<Book> = mutableListOf()
        booksRepository.getBooksByAuthor(input).forEach {
            println("Books title: " + it.volumeInfo.title)
            books.add(it.asBookDto())
        }
        println("Author " + books.size)
        return books
    }
}
