package ru.emelyanov

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
//    private val andrViewModel: AndrViewModel()
//    private val scanLauncherActivityInfo = registerForActivityResult(
//        ScanContract()
//    ) { result ->
//        if (result.contents != null) {
//            andrViewModel.onScanned(result.contents)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                val uiState: AndrViewState by andrViewModel.uiState.collectAsState()
//                val result by andrViewModel.result.collectAsState()
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.Top,
//                    horizontalAlignment = Alignment.CenterHorizontally){
//                    Button(onClick = {
//                        scanQR()
//                    }) {
//                        Text(text = "Scan")
//                    }
//                    QRList(
//                        QRModel(
//                            "QR",
//                            result
//                        )
//                    )
//                }
//            }
        }
    }

//    private fun scanQR() {
//        scanLauncherActivityInfo.launch(ScanOptions())
//    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}
