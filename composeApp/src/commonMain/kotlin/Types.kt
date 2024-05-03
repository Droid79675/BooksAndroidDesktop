
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun getAndroidTypography(): androidx.compose.material3.Typography{
    val androidFonts = FontFamily(
        font(
            "ApothemBold","apothem_bold", FontWeight.Bold, FontStyle.Normal
        ),
        font(
            "ApothemRegular", "apothem_regular", FontWeight.Normal, FontStyle.Normal
        )
    )
    return androidx.compose.material3.Typography(
        titleMedium = TextStyle(
            fontFamily = androidFonts,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        ),
        bodyMedium = TextStyle(
            fontFamily = androidFonts,
            fontSize = 26.sp,
            fontWeight = FontWeight.Normal
        )
    )
}

@Composable
fun getDesktopTypography(): androidx.compose.material3.Typography{
    val desktopFonts = FontFamily(
        font(
            "BankGothicLight", "bank_gothic_light", FontWeight.Light, FontStyle.Normal
        ),
        font(
            "BankGothicMedium", "bank_gothic_medium", FontWeight.Medium, FontStyle.Normal
        )
    )
    return androidx.compose.material3.Typography(
        titleMedium = TextStyle(
            fontFamily = desktopFonts,
            fontSize = 34.sp,
            fontWeight = FontWeight.Medium
        ),
        bodyMedium = TextStyle(
            fontFamily = desktopFonts,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light
        )
    )
}
