package presentation.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.dto.Book

@Composable
fun ListView(
    bookList: List<Book>,
) {
    LazyColumn(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(bookList){
            ItemBookCard(
                it
            )
        }
    }
}

//@Composable
//fun CallbackList(
//    modifier: Modifier = Modifier,
//    callbackListDataItem: ArrayList<Book>,
//    itemClickedCallback: (callbackListDataItem: CallbackListDataItem) -> Unit,
//) {
//    LazyColumn(modifier = modifier) {
//        items(callbackListDataItem) { item ->
//            CallbackListItem(
//                callbackListDataItem = item,
//                itemClickedCallback = itemClickedCallback
//            )
//        }
//    }
//}
//
//@Composable
//fun CallbackListItem(
//    callbackListDataItem: Book,
//    itemClickedCallback: (callbackListDataItem: CallbackListDataItem) -> Unit,
//) {
//    Button(onClick = { itemClickedCallback(callbackListDataItem) }) {
//        Text(text = callbackListDataItem.text)
//    }
//}
