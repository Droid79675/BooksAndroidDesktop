package presentation.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.dto.Book
import getAndroidTypography

@Composable
fun BookDetails(book: Book) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column {
            Text(
                text = book.title,
                modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                color = MaterialTheme.colorScheme.surface,
                style = getAndroidTypography().bodyMedium
            )
            Text(
                text = book.authors.joinToString(""),
                modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                color = MaterialTheme.colorScheme.surface,
                style = getAndroidTypography().bodyMedium
            )
            book?.description?.let {
                Text(
                    text = it,
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                    color = MaterialTheme.colorScheme.surface,
                    style = getAndroidTypography().bodyMedium
                )
            }
            Text(
                text = book.pageCount.toString(),
                modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                color = MaterialTheme.colorScheme.surface,
                style = getAndroidTypography().bodyMedium
            )
        }
    }
}
