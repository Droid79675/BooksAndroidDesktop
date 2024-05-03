package presentation.ui.viewmodel

import domain.dto.Book

sealed class MainViewState {
    data object Idle : MainViewState()
    data object Loading : MainViewState()

    data class Success (val books: List<Book>) :
        MainViewState()

    data class Error (val error: Throwable) :
        MainViewState()
}
