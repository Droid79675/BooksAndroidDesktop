
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.MainTheme
import presentation.appBackgroundColors
import presentation.ui.view.ErrorView
import presentation.ui.view.ListView
import presentation.ui.view.LoadingView
import presentation.ui.viewmodel.MainViewModel
import presentation.ui.viewmodel.MainViewState

val mainViewModel = MainViewModel()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {

    MainTheme {
        val uiState: MainViewState by mainViewModel.uiState.collectAsState()
        val searchText by mainViewModel.searchText.collectAsState()
        val checkedState = remember { mutableStateOf(true) }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.secondary
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Checkbox(
                        checked = checkedState.value,
                        modifier = Modifier.padding(16.dp),
                        onCheckedChange = { checkedState.value = it }
                    )
                    TextField(
                        value = searchText,
                        onValueChange = { mainViewModel.onSearchTextChange(it) },
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        maxLines = 1
                    )
                }

                TextButton(
                    onClick = { mainViewModel.getBooks(searchText, checkedState.value) },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.padding(10.dp).width(80.dp).height(60.dp),
                    enabled = true,
                    colors = ButtonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.DarkGray,
                        disabledContainerColor = Color.Transparent,
                        disabledContentColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "Search",
                        color = Color.White
                    )
                }


                Box(
                    Modifier.background(
                        brush = Brush.linearGradient(
                            colors = appBackgroundColors(isSystemInDarkTheme()),
                        ), alpha = (0.7f)
                    )
                ) {

                    when (uiState) {
                        is MainViewState.Idle -> {

                        }

                        is MainViewState.Loading -> {
                            LoadingView()
                        }

                        is MainViewState.Success -> {
                            ListView((uiState as MainViewState.Success).books)
                        }

                        is MainViewState.Error -> {
                            ErrorView("Error")
                        }
                    }
                }
            }

        }


    }

//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
}
