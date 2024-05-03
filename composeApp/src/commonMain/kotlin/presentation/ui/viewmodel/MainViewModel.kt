package presentation.ui.viewmodel

import di.DataContainer
import domain.GetBooksByAuthorUseCase
import domain.GetBooksByTitleUseCase
import domain.dto.Book
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel (
    private val getBooksByTitleUseCase: GetBooksByTitleUseCase = DataContainer.getBooksByTitleUseCase,
    private val getBooksByAuthorUseCase: GetBooksByAuthorUseCase = DataContainer.getBooksByAuthorUseCase
){
    private val _uiState: MutableStateFlow<MainViewState> = MutableStateFlow(
        MainViewState.Idle
    )

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()
    val uiState = _uiState.asStateFlow()

    private fun loading(){
        _uiState.update {
            MainViewState.Loading
        }
    }

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    suspend fun validateInput(text: String){
        if(text.isBlank()){
            throwError(Throwable("Invalid input"))
        }
    }

    fun getBooks(input: String, flag: Boolean){
        CoroutineScope(Dispatchers.IO).launch{
            loading()
            try {
                val books: List<Book> = if (flag) {
                    getBooksByTitleUseCase.getBooksByTitle(input)
                } else {
                    getBooksByAuthorUseCase.getBooksByAuthor(input)
                }
                println("size: " + books.size)
                withContext(Dispatchers.Main) {
                    success(books)
                }
            } catch (error: Throwable){
                throwError(error)
            }
        }
    }

    private fun success(books: List<Book>) {
        _uiState.update {
            MainViewState.Success(books)
        }
    }

    private suspend fun throwError(error: Throwable) {
        withContext(Dispatchers.Main){
            _uiState.update {
                println("UI Error: ${error.message}")
                MainViewState.Error(error)
            }
        }
    }

}
